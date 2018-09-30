package com.treasure.ssc.svc.impl;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.treasure.ssc.cons.SscConst;
import com.treasure.ssc.dao.BuyItemDao;
import com.treasure.ssc.dao.SscUserDao;
import com.treasure.ssc.dao.TicketDao;
import com.treasure.ssc.entity.BuyItem;
import com.treasure.ssc.entity.SscUser;
import com.treasure.ssc.entity.Ticket;
import com.treasure.ssc.svc.FrontSvc;
import com.treasure.ssc.svc.TicketSvc;
import com.treasure.ssc.util.SscUtils;
import com.treasure.ssc.vo.BuyVo;
import com.treasure.ssc.vo.SscOutVo;
import com.treasure.ssc.vo.SscVo;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

/**
 * @author: mazy
 * @date: 2018/9/28 15:25
 */
@Service
@Transactional(rollbackFor = {Exception.class})
public class TicketSvcImpl implements TicketSvc {
    private static final Logger log = LoggerFactory.getLogger(TicketSvcImpl.class);

    @Autowired
    private TicketDao ticketDao;
    @Autowired
    private BuyItemDao buyItemDao;
    @Autowired
    private SscUserDao sscUserDao;
    @Autowired
    private FrontSvc frontSvc;

    @Override
    public void initTickets() {
        try {
            Files.walk(SscConst.SOURCE_DIR)
                    .filter(f -> !Files.isDirectory(f))
                    .forEach(f -> {
                        try {
                            byte[] bytes = Files.readAllBytes(f);
                            List<SscVo> tickets = JSON.parseArray(new String(bytes, Charset.defaultCharset()), SscVo.class);
                            List<Ticket> list = Lists.newArrayList();
                            tickets.stream().forEach(t -> {
                                if (StringUtils.isBlank(t.getNo())) {
                                    log.error("{}", JSON.toJSONString(t));
                                    return;
                                }
                                Ticket ticket = new Ticket();
                                ticket.setTicketDate(LocalDate.parse(t.getDay(), DateTimeFormatter.ofPattern("yyyyMMdd")));
                                ticket.setTicketNo(t.getNo());
                                ticket.setTicketNum(t.getNum());
                                ticket.setBef3MaxCount(t.getBef3MaxCount().shortValue());
                                ticket.setMid3MaxCount(t.getMid3MaxCount().shortValue());
                                ticket.setAft3MaxCount(t.getAft3MaxCount().shortValue());
                                ticket.setMaxCount((short) SscUtils.maxCountChar(t.getNum()));
                                Integer line = Integer.valueOf(t.getNo()) / 20 + (Integer.valueOf(t.getNo()) % 20 == 0 ? 0 : 1);
                                ticket.setLine(line.shortValue());
                                list.add(ticket);
                            });
                            ticketDao.insertBatch(list);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public SscOutVo next(String ticketNo, Date ticketDate) {
        // 查询用户
        SscUser sscUser = sscUserDao.getByUsername("mzy");
        if (sscUser == null) {
            throw new RuntimeException("用户 [mzy] 不存在！");
        }
        // 获取票
        SscOutVo outVo = ticketDao.getByNoAndDate(ticketNo, ticketDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
        // 买的金钱
        List<BigDecimal> buyMoneys = buyItemDao.selectMoneyNowNo("mzy", outVo.getTicketId());
        // 原金额
        BigDecimal money = sscUser.getMoney();

        outVo.setMoney(money);
        // 总金额
        BigDecimal allMoney = money;

        // 中奖
        short bingoShort = (short) 2;
        boolean bingo = false;
        // 后三中奖
        if (outVo.getAft3MaxCount() == bingoShort) {
            bingo = true;
            // 这一期买了
            if (CollectionUtils.isNotEmpty(buyMoneys)) {
                // 中奖金额
                BigDecimal fee = buyMoneys.stream()
                        .map(e -> e.multiply(SscConst.ZU_3_MULTIPLE))
                        .reduce((a, b) -> a.add(b)).get();
                allMoney = allMoney.add(fee);
                outVo.setFee(fee);
            }
        }

        // 更新购买的票
        buyItemDao.updateNowNo(bingo ? (short) 2 : (short) 3, sscUser.getUserId(), outVo.getTicketId());
        // 撤单
        if (bingo) {
            // 查询要撤单的钱
            List<BigDecimal> reMo = buyItemDao.selectMoneyRe(sscUser.getUsername(), outVo.getTicketId());
            if (CollectionUtils.isNotEmpty(reMo)) {
                // 撤单的钱
                BigDecimal bd = reMo.stream().reduce((a, b) -> a.add(b)).get();
                // 放入总金钱
                allMoney.add(bd);
                outVo.setReFee(bd);
            }
            buyItemDao.updateReNo(sscUser.getUserId());
        }
        outVo.setAllMoney(allMoney);
        // 更新用户
        sscUser.setMoney(allMoney);
        sscUser.setNowNo(ticketNo);
        sscUser.setNowDate(ticketDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
        sscUserDao.updateByUsername(sscUser);
        return outVo;
    }

    @Override
    public void compBingo(Integer ticketId) {

    }

    @Override
    public List<BuyItem> buy(String ticketNo, Date ticketDate, Short count, BigDecimal start) {
        // 查询用户
        SscUser sscUser = sscUserDao.getByUsername("mzy");
        if (sscUser == null) {
            throw new RuntimeException("用户 [mzy] 不存在！");
        }
        List<BuyItem> list = Lists.newArrayList();
        // no转换成int类型
        int noInt = Integer.valueOf(ticketNo);
        for (int i = 0; i < count.intValue(); i++) {
            // 本期金钱
            BigDecimal thisMoney = frontSvc.getMoneyByTimes(start, i + 1);

            BuyItem buyVo = new BuyItem();

            String no = SscUtils.frontZero(noInt++, 3);

            SscOutVo sscOutVo = ticketDao.getByNoAndDate(no, ticketDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate());

            buyVo.setTicketId(sscOutVo.getTicketId());
            buyVo.setBuyMoney(thisMoney);
            buyVo.setCreateTime(LocalDateTime.now());
            buyVo.setUpdateTime(LocalDateTime.now());
            buyVo.setUserId(sscUser.getUserId());
            buyVo.setItemFlag((short) 1);
            list.add(buyVo);
        }
        // 耗费
        BigDecimal costMoney = list.stream().map(e -> e.getBuyMoney()).reduce((a, b) -> a.add(b)).get();
        // 剩余
        BigDecimal restMoney = sscUser.getMoney().subtract(costMoney);
        // 写入buyItem
        buyItemDao.insertBatch(list);
        // 更新总金钱
        sscUser.setUpdateTime(LocalDateTime.now());
        sscUser.setMoney(restMoney);
        sscUserDao.updateByUsername(sscUser);
        return list;
    }

}
