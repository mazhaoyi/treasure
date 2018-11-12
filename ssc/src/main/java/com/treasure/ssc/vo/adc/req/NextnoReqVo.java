package com.treasure.ssc.vo.adc.req;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * @author: mazy
 * @date: 2018/11/12 15:44
 */
public class NextnoReqVo implements Serializable {
    private static final long serialVersionUID = 159365933998879917L;
    /**
     * 日期
     */
    private LocalDate ticketDate;
    /**
     * 当前期
     */
    private String nowTicketNo;

    public LocalDate getTicketDate() {
        return this.ticketDate;
    }

    public void setTicketDate(LocalDate ticketDate) {
        this.ticketDate = ticketDate;
    }

    public String getNowTicketNo() {
        return this.nowTicketNo;
    }

    public void setNowTicketNo(String nowTicketNo) {
        this.nowTicketNo = nowTicketNo;
    }
}
