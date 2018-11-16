package com.treasure.ssc.svc.impl;

import com.treasure.common.util.SscUtils;
import com.treasure.ssc.dao.AdcCenterDao;
import com.treasure.ssc.entity.BuyItem;
import com.treasure.ssc.entity.SscUser;
import com.treasure.ssc.svc.AdcCenterSvc;
import com.treasure.ssc.vo.TicketSscVo;
import com.treasure.ssc.vo.adc.req.BuyReqVo;
import com.treasure.ssc.vo.adc.resp.AdcListVo;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

/**
 * @author: mazy
 * @date: 2018/11/12 16:52
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class AdcCenterSvcImpl implements AdcCenterSvc {
    /**
     * 用户名
     */
    private static final String uname = "mzy";

    @Autowired
    private AdcCenterDao adcCenterDao;

    @Override
    public AdcListVo nowList() {
        // 当前用户
        SscUser sscUser = adcCenterDao.getUserByUsername(uname);
        LocalDate date = sscUser.getNowDate();
        String nowTicketNo = sscUser.getNowNo();

        List<TicketSscVo> list = adcCenterDao.listByDateAndNo(date, nowTicketNo);
        if (CollectionUtils.isNotEmpty(list)) {
            list.forEach(e -> {
                String tn = e.getTicketNum();
                e.setIfzu5(SscUtils.checkZu5(tn));
                e.setIfzu10(SscUtils.checkZu10(tn));
            });
        }

        AdcListVo vo = new AdcListVo();
        vo.setNowMoney(sscUser.getMoney());
        vo.setTicketSscVos(list);
        return vo;
    }

    @Override
    public TicketSscVo nextNum() {
        // 当前用户
        SscUser sscUser = adcCenterDao.getUserByUsername(uname);

        LocalDate date = sscUser.getNowDate();
        String nowTicketNo = sscUser.getNowNo();
        Integer ticketNo = Integer.valueOf(nowTicketNo) + 1;
        if (ticketNo > 120) {
            ticketNo = 1;
            date = date.plusDays(1);
        }
        TicketSscVo vo = adcCenterDao.getByDateAndNo(date, SscUtils.frontZero(ticketNo, 3));
        if (vo == null) {
            vo = new TicketSscVo();
            vo.setTicketDate(date);
            vo.setTicketNo(SscUtils.frontZero(ticketNo, 3));
            vo.setTicketNum("");
            vo.setAft3num(1);
            vo.setIfzu5(false);
            vo.setIfzu10(false);
        } else {
            Integer maxNum = SscUtils.maxCountChar(SscUtils.create3After(vo.getTicketNum()));
            vo.setAft3num(maxNum);
            String tn = vo.getTicketNum();
            vo.setIfzu5(SscUtils.checkZu5(tn));
            vo.setIfzu10(SscUtils.checkZu10(tn));
            // 计算本期金钱
            computeMoney(vo.getTicketId(), vo.getTicketNum());
        }

        recordUserNowNo(date, vo.getTicketNo());

        // 计算过金钱后的用户
        SscUser lastUser = adcCenterDao.getUserByUsername(uname);

        vo.setNowMoney(lastUser.getMoney());

        return vo;
    }

    @Override
    public void recordUserNowNo(LocalDate date, String ticketNo) {
        SscUser sscUser = new SscUser();
        sscUser.setNowDate(date);
        sscUser.setNowNo(ticketNo);
        sscUser.setUsername(uname);
        adcCenterDao.updateSscUserByUsername(sscUser);
    }

    @Override
    public void computeMoney(Integer ticketId, String ticketNum) {
        // 查询本期所有未开奖的选项
        List<BuyItem> items = adcCenterDao.listBuyItem(ticketId, (short) 1);
        if (CollectionUtils.isEmpty(items)) {
            return;
        }
        // 后三最大重复数
        Integer maxNum = SscUtils.maxCountChar(SscUtils.create3After(ticketNum));
        for (BuyItem item : items) {
            // 组3资金
            BigDecimal bd = item.getBuyMoney();
            Integer userId = item.getUserId();
            // 豹子资金
            BigDecimal bzDb = bd.divide(BigDecimal.valueOf(10));
            // 赚
            BigDecimal getFee = BigDecimal.ZERO;
            // 组3
            if (maxNum == 2) {
                // 组三赚
                getFee = BigDecimal.valueOf(32.3).multiply(bd).divide(BigDecimal.valueOf(9), BigDecimal.ROUND_HALF_UP);
            } else if (maxNum == 3) {
                // 豹子赚
                getFee = bzDb.multiply(BigDecimal.valueOf(96.9));
            }

            // 修改组3子订单状态
            if (maxNum == 2) {
                // 中奖组3
                adcCenterDao.updateItemFlag(item.getBuyItemId(), (short) 2);
            } else {
                // 组3未中奖
                adcCenterDao.updateItemFlag(item.getBuyItemId(), (short) 3);
            }

            SscUser sscUser = adcCenterDao.getUserById(userId);
            if (sscUser != null) {
                // 更新用户资金
                BigDecimal money = sscUser.getMoney();
                money = money.add(getFee);
                sscUser.setMoney(money);
                SscUser userVo = new SscUser();
                userVo.setMoney(money);
                userVo.setUsername(sscUser.getUsername());
                adcCenterDao.updateSscUserByUsername(userVo);
            }
        }
    }

    @Override
    public BigDecimal buy(BuyReqVo reqVo) {
        if (reqVo == null) {
            throw new RuntimeException("请求参数不能为空！");
        }
        // 购买组3金钱
        BigDecimal zu3money = reqVo.getBuyMoney();
        if (zu3money == null) {
            throw new RuntimeException("必须填写金钱！");
        }
        // 当前用户
        SscUser sscUser = adcCenterDao.getUserByUsername(uname);

        LocalDate date = sscUser.getNowDate();
        String no = sscUser.getNowNo();
        if (date == null) {
            throw new RuntimeException("日期不能为空！");
        }
        Integer nowNo = Integer.valueOf(no);

        if (nowNo > 119) {
            nowNo = 0;
            date = date.plusDays(1);
        }


        // 还剩金钱
        BigDecimal money = sscUser.getMoney();
        // 购买豹子金钱
        BigDecimal bzmoney = zu3money.divide(BigDecimal.valueOf(10));
        // 判断是否还有钱购买
        BigDecimal remainMoney = money.subtract(zu3money).subtract(bzmoney);
        if (remainMoney.compareTo(BigDecimal.ZERO) < 0) {
            throw new RuntimeException("所剩余的钱不够购买组三和豹子！剩余¥ " + money + "，需要¥ " + zu3money.add(bzmoney));
        }
        TicketSscVo ticketSscVo = adcCenterDao.getByDateAndNo(date, SscUtils.frontZero(nowNo + 1, 3));
        if (ticketSscVo == null) {
            throw new RuntimeException("该期票还没有出来，请耐心等待！");
        }
        // 新增购买项
        int buyRes = adcCenterDao.buyTicket(sscUser.getUserId(), ticketSscVo.getTicketId(), zu3money);
        if (buyRes > 0) {
            // 用户账号扣钱
            SscUser su = new SscUser();
            su.setMoney(remainMoney);
            su.setUsername(uname);
            adcCenterDao.updateSscUserByUsername(su);
        } else {
            throw new RuntimeException("购买失败！");
        }
        return remainMoney;
    }

    @Override
    public void resetMoney(BigDecimal money) {
        // 当前用户
        SscUser sscUser = adcCenterDao.getUserByUsername(uname);
        adcCenterDao.resetMoney(sscUser.getUserId(), money);
    }
}
