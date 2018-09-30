package com.treasure.ssc.svc.impl;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.treasure.ssc.cons.SscConst;
import com.treasure.ssc.dao.TicketDao;
import com.treasure.ssc.entity.BuyItem;
import com.treasure.ssc.entity.Ticket;
import com.treasure.ssc.svc.TicketSvc;
import com.treasure.ssc.util.SscUtils;
import com.treasure.ssc.vo.SscOutVo;
import com.treasure.ssc.vo.SscVo;
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
        // 获取票
        SscOutVo outVo = ticketDao.getByNoAndDate(ticketNo, ticketDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
        return outVo;
    }

    @Override
    public void compBingo(Integer ticketId) {

    }

    @Override
    public List<BuyItem> buy(String ticketNo, Date ticketDate, Short count, BigDecimal start) {
        return null;
    }

    @Override
    public BigDecimal getMoneyByTimes(BigDecimal start, int times) {
        BigDecimal end = start;
        for (int i = 1; i < times; i++) {
            end = end.multiply(BigDecimal.valueOf(2));
        }
        return end;
    }

}
