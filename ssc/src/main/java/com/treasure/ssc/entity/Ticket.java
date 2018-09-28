package com.treasure.ssc.entity;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * @author: mazy
 * @date: 2018/9/28 15:12
 */
public class Ticket implements Serializable {
    private static final long serialVersionUID = 5066263126148171578L;
    private Integer ticketId;
    private String ticketNo;
    private String ticketNum;
    private LocalDate ticketDate;
    private Short bef3MaxCount;
    private Short mid3MaxCount;
    private Short aft3MaxCount;
    private Short maxCount;
    private Short line;

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

    public Short getBef3MaxCount() {
        return this.bef3MaxCount;
    }

    public void setBef3MaxCount(Short bef3MaxCount) {
        this.bef3MaxCount = bef3MaxCount;
    }

    public Short getMid3MaxCount() {
        return this.mid3MaxCount;
    }

    public void setMid3MaxCount(Short mid3MaxCount) {
        this.mid3MaxCount = mid3MaxCount;
    }

    public Short getAft3MaxCount() {
        return this.aft3MaxCount;
    }

    public void setAft3MaxCount(Short aft3MaxCount) {
        this.aft3MaxCount = aft3MaxCount;
    }

    public Short getMaxCount() {
        return this.maxCount;
    }

    public void setMaxCount(Short maxCount) {
        this.maxCount = maxCount;
    }

    public Short getLine() {
        return this.line;
    }

    public void setLine(Short line) {
        this.line = line;
    }
}
