package com.treasure.ssc.svc.impl;

import com.treasure.common.util.SscUtils;
import com.treasure.ssc.dao.AdcCenterDao;
import com.treasure.ssc.entity.BuyItem;
import com.treasure.ssc.entity.SscUser;
import com.treasure.ssc.svc.AdcCenterSvc;
import com.treasure.ssc.vo.TicketSscVo;
import com.treasure.ssc.vo.adc.req.BuyReqVo;
import com.treasure.ssc.vo.adc.req.NextnoReqVo;
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
    public TicketSscVo nextNum(NextnoReqVo reqVo) {
        if (reqVo == null) {
            throw new RuntimeException("请求参数不能为空！");
        }
        LocalDate date = reqVo.getTicketDate();
        String nowTicketNo = reqVo.getNowTicketNo();
        if (date == null || StringUtils.isBlank(nowTicketNo)) {
            throw new RuntimeException("日期和当前期号不能为空！");
        }
        Integer ticketNo = Integer.valueOf(nowTicketNo) + 1;
        if (ticketNo > 120) {
            throw new RuntimeException("已经是最后一期了！");
        }
        TicketSscVo vo = adcCenterDao.getByDateAndNo(date, SscUtils.frontZero(ticketNo, 3));
        if (vo == null) {
            vo = new TicketSscVo();
            vo.setTicketDate(date);
            vo.setTicketNo(SscUtils.frontZero(ticketNo, 3));
            vo.setTicketNum("");
            vo.setAft3num(1);
        } else {
            Integer maxNum = SscUtils.maxCountChar(SscUtils.create3After(vo.getTicketNum()));
            vo.setAft3num(maxNum);
            // 计算本期金钱
            computeMoney(vo.getTicketId(), vo.getTicketNum());
        }

        recordUserNowNo(date, vo.getTicketNo());

        SscUser sscUser = adcCenterDao.getUserByUsername(uname);
        if (sscUser != null) {
            vo.setNowMoney(sscUser.getMoney());
        }

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
                getFee = BigDecimal.valueOf(32.3).multiply(bd).divide(BigDecimal.valueOf(9));
            } else if (maxNum == 3) {
                // 豹子赚
                getFee = bzDb.multiply(BigDecimal.valueOf(96.9));
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
        // 当前用户
        SscUser sscUser = adcCenterDao.getUserByUsername(uname);
        BigDecimal money = sscUser.getMoney();

        return null;
    }
}
