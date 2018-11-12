package com.treasure.ssc.svc;

import com.treasure.ssc.entity.BuyItem;
import com.treasure.ssc.vo.AnalyzeKlineVo;
import com.treasure.ssc.vo.SscOutVo;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

/**
 * @author: mazy
 * @date: 2018/9/28 15:24
 */
public interface TicketSvc {
    /**
     * 初始化数据到ticket
     * @return
     */
    void initTickets();

    /**
     * 源数据放入数据库
     * @param startDate
     * @param endDate
     */
    void dataToDb(LocalDate startDate, LocalDate endDate);

    /**
     * 下一期
     * @param ticketNo
     * @param ticketDate
     * @return
     */
    SscOutVo next(String ticketNo, Date ticketDate);

    /**
     * 计算本次中奖
     * @param ticketId
     */
    void compBingo(Integer ticketId);

    /**
     * 购买
     * @param ticketNo
     * @param ticketDate
     * @param count
     */
    List<BuyItem> buy(String ticketNo, Date ticketDate, Short count, BigDecimal start);
    /**
     * 根据初始金钱，第几次翻倍，计算这一期的金钱数
     * @param start 初始金钱
     * @param times 第几次翻倍
     * @return
     */
    BigDecimal getMoneyByTimes(BigDecimal start, int times);

    /**
     * 查询组3日K列表
     * @param startDate
     * @param endDate
     * @return
     */
    List<AnalyzeKlineVo> zu3KList(LocalDate startDate, LocalDate endDate, Boolean if54);
    /**
     * 查询组3日K列表
     * @param startDate
     * @param endDate
     * @return
     */
    List<AnalyzeKlineVo> zu3K5List(LocalDate startDate, LocalDate endDate);

}
