package com.treasure.ssc.vo.adc.req;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * @author: mazy
 * @date: 2018/11/12 15:45
 */
public class BuyReqVo implements Serializable {
    private static final long serialVersionUID = -6331867832512956725L;
    /**
     * 日期
     */
    private LocalDate ticketDate;
    /**
     * 当前期
     */
    private String nowTicketNo;
    /**
     * 购买额度
     */
    private BigDecimal buyMoney;

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

    public BigDecimal getBuyMoney() {
        return this.buyMoney;
    }

    public void setBuyMoney(BigDecimal buyMoney) {
        this.buyMoney = buyMoney;
    }
}
