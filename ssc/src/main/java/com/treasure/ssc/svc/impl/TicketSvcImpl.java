package com.treasure.ssc.svc.impl;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.treasure.common.constant.SscConst;
import com.treasure.common.util.HttpUtils;
import com.treasure.common.util.SscUtils;
import com.treasure.common.vo.Point;
import com.treasure.ssc.dao.TicketDao;
import com.treasure.ssc.entity.BuyItem;
import com.treasure.ssc.entity.Ticket;
import com.treasure.ssc.svc.TicketSvc;
import com.treasure.ssc.vo.*;
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
import java.util.*;
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

            // 查询的当天日期
            LocalDate theDate = startDate;

            // 开始时间+1天
            startDate = startDate.plusDays(1);

            List<BaseDataVo> datas = HttpUtils.postList(dataUrl, params, BaseDataVo.class);
            if (CollectionUtils.isEmpty(datas)) {
                continue;
            }

            // 查询当天最新的票的no，如果没有票的话，那么返回000
            String maxNo = ticketDao.selectMaxNoByDate(theDate);
            // list只要数据库中没有的票
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
            }).filter(t -> {
                String tkNo = t.getTicketNo();
                if (StringUtils.compare(tkNo, maxNo) > 0) {
                    return true;
                } else {
                    return false;
                }
            }).filter(t -> StringUtils.isNotBlank(t.getTicketNum())).collect(Collectors.toList());

            if (CollectionUtils.isNotEmpty(list)) {
                ticketDao.insertBatch(list);
            }
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
    public List<AnalyzeKlineVo> zu3KList(LocalDate startDate, LocalDate endDate, Boolean ifk5) {
        if (ifk5 == null) {
            ifk5 = false;
        }
        if (startDate == null) {
            throw new RuntimeException("开始时间不能为空！");
        }
        if (endDate == null) {
            throw new RuntimeException("结束时间不能为空！");
        }
        if (startDate.isAfter(endDate)) {
            throw new RuntimeException("开始时间不能晚于结束时间！");
        }
        List<TicketSscVo> list = null;
        if (ifk5) {
            list = ticketDao.ticket5List(startDate, endDate);
        } else {
            list = ticketDao.ticketList(startDate, endDate);
        }
        if (CollectionUtils.isEmpty(list)) {
            return null;
        }
        Map<LocalDate, AnalyzeKlineVo> tmpMap = Maps.newHashMap();

        list.stream().forEach(e -> {
            String num = e.getTicketNum();
            LocalDate date = e.getTicketDate();
            AnalyzeKlineVo vo = tmpMap.get(date);
            if (vo == null) {
                vo = new AnalyzeKlineVo();
                vo.setDate(date);
            }

            /**
             * 前三
             */
            Integer bef3timesInit = vo.getBef3times() == null ? 0 : vo.getBef3times();
            /**
             * 中三
             */
            Integer mid3timesInit = vo.getMid3times() == null ? 0 : vo.getMid3times();
            /**
             * 后三
             */
            Integer aft3timesInit = vo.getAft3times() == null ? 0 : vo.getAft3times();
            /**
             * 万千十
             */
            Integer wqs3timesInit = vo.getWqs3times() == null ? 0 : vo.getWqs3times();
            /**
             * 万千个
             */
            Integer wqg3timesInit = vo.getWqg3times() == null ? 0 : vo.getWqg3times();
            /**
             * 万百十
             */
            Integer wbs3timesInit = vo.getWbs3times() == null ? 0 : vo.getWbs3times();
            /**
             * 万百个
             */
            Integer wbg3timesInit = vo.getWbg3times() == null ? 0 : vo.getWbg3times();
            /**
             * 万十个
             */
            Integer wsg3timesInit = vo.getWsg3times() == null ? 0 : vo.getWsg3times();
            /**
             * 千百个
             */
            Integer qbg3timesInit = vo.getQbg3times() == null ? 0 : vo.getQbg3times();
            /**
             * 千十个
             */
            Integer qsg3timesInit = vo.getQsg3times() == null ? 0 : vo.getQsg3times();

            /**
             * 前三
             */
            String bef3num = SscUtils.pickUp3Char(num, Point.W, Point.Q, Point.B);
            Integer bef3times = SscUtils.zu3times(bef3num);
            vo.setBef3times(bef3timesInit + bef3times);
            /**
             * 中三
             */
            String mid3num = SscUtils.pickUp3Char(num, Point.Q, Point.B, Point.S);
            Integer mid3times = SscUtils.zu3times(mid3num);
            vo.setMid3times(mid3timesInit + mid3times);
            /**
             * 后三
             */
            String aft3num = SscUtils.pickUp3Char(num, Point.B, Point.S, Point.G);
            Integer aft3times = SscUtils.zu3times(aft3num);
            vo.setAft3times(aft3timesInit + aft3times);
            /**
             * 万千十
             */
            String wqs3num = SscUtils.pickUp3Char(num, Point.W, Point.Q, Point.S);
            Integer wqs3times = SscUtils.zu3times(wqs3num);
            vo.setWqs3times(wqs3timesInit + wqs3times);
            /**
             * 万千个
             */
            String wqg3num = SscUtils.pickUp3Char(num, Point.W, Point.Q, Point.G);
            Integer wqg3times = SscUtils.zu3times(wqg3num);
            vo.setWqg3times(wqg3timesInit + wqg3times);
            /**
             * 万百十
             */
            String wbs3num = SscUtils.pickUp3Char(num, Point.W, Point.B, Point.S);
            Integer wbs3times = SscUtils.zu3times(wbs3num);
            vo.setWbs3times(wbs3timesInit + wbs3times);
            /**
             * 万百个
             */
            String wbg3num = SscUtils.pickUp3Char(num, Point.W, Point.B, Point.G);
            Integer wbg3times = SscUtils.zu3times(wbg3num);
            vo.setWbg3times(wbg3timesInit + wbg3times);
            /**
             * 万十个
             */
            String wsg3num = SscUtils.pickUp3Char(num, Point.W, Point.S, Point.G);
            Integer wsg3times = SscUtils.zu3times(wsg3num);
            vo.setWsg3times(wsg3timesInit + wsg3times);
            /**
             * 千百个
             */
            String qbg3num = SscUtils.pickUp3Char(num, Point.Q, Point.B, Point.G);
            Integer qbg3times = SscUtils.zu3times(qbg3num);
            vo.setQbg3times(qbg3timesInit + qbg3times);
            /**
             * 千十个
             */
            String qsg3num = SscUtils.pickUp3Char(num, Point.Q, Point.S, Point.G);
            Integer qsg3times = SscUtils.zu3times(qsg3num);
            vo.setQsg3times(qsg3timesInit + qsg3times);

            tmpMap.put(date, vo);
        });
        List<AnalyzeKlineVo> results = tmpMap.values().stream().sorted(Comparator.comparing(e -> e.getDate())).collect(Collectors.toList());
        return results;
    }

    @Override
    public List<AnalyzeKlineVo> zu3K5List(LocalDate startDate, LocalDate endDate) {
        return zu3KList(startDate, endDate, true);
    }

}
