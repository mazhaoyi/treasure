package com.treasure.ssc.svc;

import com.treasure.ssc.entity.BuyItem;
import com.treasure.ssc.vo.SscOutVo;

import java.math.BigDecimal;
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
}
