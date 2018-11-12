package com.treasure.ssc.vo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * @author: mazy
 * @date: 2018/11/5 14:36
 */
public class TicketSscVo implements Serializable {
    private static final long serialVersionUID = -834790903764509842L;
    private Integer ticketId;
    private String ticketNo;
    private String ticketNum;
    private LocalDate ticketDate;
    private Integer aft3num;
    /**
     * 用户当前金钱
     */
    private BigDecimal nowMoney;

    public BigDecimal getNowMoney() {
        return this.nowMoney;
    }

    public void setNowMoney(BigDecimal nowMoney) {
        this.nowMoney = nowMoney;
    }

    public Integer getAft3num() {
        return this.aft3num;
    }

    public void setAft3num(Integer aft3num) {
        this.aft3num = aft3num;
    }

    public Integer getTicketId() {
        return this.ticketId;
    }

    public void setTicketId(Integer ticketId) {
        this.ticketId = ticketId;
    }

    public String getTicketNo() {
        return this.ticketNo;
    }

    public void setTicketNo(String ticketNo) {
        this.ticketNo = ticketNo;
    }

    public String getTicketNum() {
        return this.ticketNum;
    }

    public void setTicketNum(String ticketNum) {
        this.ticketNum = ticketNum;
    }

    public LocalDate getTicketDate() {
        return this.ticketDate;
    }

    public void setTicketDate(LocalDate ticketDate) {
        this.ticketDate = ticketDate;
    }
}
