package com.treasure.analyze.vo;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;
import java.util.Date;

/**
 * @author: mazy
 * @date: 2018/10/30 15:14
 */
public class TicketVo implements Serializable {
    private static final long serialVersionUID = -3505414085902428706L;
    private Integer ticket_id;
    private Integer ticket_no;
    private Integer ticket_num;
    @JSONField(format = "MM/dd/yyyy")
    private Date ticket_date;
    private Integer line;

    public Integer getTicket_id() {
        return this.ticket_id;
    }

    public void setTicket_id(Integer ticket_id) {
        this.ticket_id = ticket_id;
    }

    public Integer getTicket_no() {
        return this.ticket_no;
    }

    public void setTicket_no(Integer ticket_no) {
        this.ticket_no = ticket_no;
    }

    public Integer getTicket_num() {
        return this.ticket_num;
    }

    public void setTicket_num(Integer ticket_num) {
        this.ticket_num = ticket_num;
    }

    public Date getTicket_date() {
        return this.ticket_date;
    }

    public void setTicket_date(Date ticket_date) {
        this.ticket_date = ticket_date;
    }

    public Integer getLine() {
        return this.line;
    }

    public void setLine(Integer line) {
        this.line = line;
    }
}
