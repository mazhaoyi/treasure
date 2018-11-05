package com.treasure.ssc.svc.impl;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.treasure.common.constant.SscConst;
import com.treasure.common.util.HttpUtils;
import com.treasure.common.util.SscUtils;
import com.treasure.ssc.dao.TicketDao;
import com.treasure.ssc.entity.BuyItem;
import com.treasure.ssc.entity.Ticket;
import com.treasure.ssc.svc.TicketSvc;
import com.treasure.ssc.vo.AnalyzeKlineVo;
import com.treasure.ssc.vo.BaseDataVo;
import com.treasure.ssc.vo.SscOutVo;
import com.treasure.ssc.vo.SscVo;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author: mazy
 * @date: 2018/9/28 15:25
 */
@Service
@Transactional(rollbackFor = {Exception.class})
public class TicketSvcImpl implements TicketSvc {
    private static final Logger log = LoggerFactory.getLogger(TicketSvcImpl.class);

    @Value("${self.data.data-url}")
    private String dataUrl;
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
    public void dataToDb(LocalDate startDate, LocalDate endDate) {
        if (startDate == null || endDate == null) {
            throw new RuntimeException("开始、结束时间不能为空！");
        }
        if (startDate.isAfter(endDate)) {
            throw new RuntimeException("开始时间不能在结束时间后面！");
        }
        while (!startDate.isAfter(endDate)) {
            Map<String, Object> params = null;
            if (startDate != null) {
                params = new HashMap<>(1);
                params.put("selectDay", startDate.format(DateTimeFormatter.ofPattern("yyyyMMdd")));
            }
            // 开始时间+1天
            startDate = startDate.plusDays(1);

            List<BaseDataVo> datas = HttpUtils.postList(dataUrl, params, BaseDataVo.class);
            if (CollectionUtils.isEmpty(datas)) {
                continue;
            }
            List<Ticket> list = datas.stream().map(t -> {
                Ticket ticket = new Ticket();
                ticket.setTicketDate(LocalDate.parse(t.getDay(), DateTimeFormatter.ofPattern("yyyyMMdd")));
                ticket.setTicketNo(t.getNo());
                ticket.setTicketNum(t.getNum());
                ticket.setBef3MaxCount(Integer.valueOf(SscUtils.maxCountChar(SscUtils.create3Before(t.getNum()))).shortValue());
                ticket.setMid3MaxCount(Integer.valueOf(SscUtils.maxCountChar(SscUtils.create3Middle(t.getNum()))).shortValue());
                ticket.setAft3MaxCount(Integer.valueOf(SscUtils.maxCountChar(SscUtils.create3After(t.getNum()))).shortValue());
                ticket.setMaxCount((short) SscUtils.maxCountChar(t.getNum()));
                Integer line = Integer.valueOf(t.getNo()) / 20 + (Integer.valueOf(t.getNo()) % 20 == 0 ? 0 : 1);
                ticket.setLine(line.shortValue());
                return ticket;
            }).collect(Collectors.toList());
            ticketDao.insertBatch(list);
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

    @Override
    public List<AnalyzeKlineVo> zu3KList(LocalDate startDate, LocalDate endDate) {
        return null;
    }

}
