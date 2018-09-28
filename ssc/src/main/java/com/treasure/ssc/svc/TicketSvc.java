package com.treasure.ssc.svc;

import com.alibaba.fastjson.annotation.JSONField;
import com.treasure.ssc.vo.SscOutVo;

import java.util.Date;

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
}
