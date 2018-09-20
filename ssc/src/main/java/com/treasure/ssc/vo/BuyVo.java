package com.treasure.ssc.vo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * @author: mazy
 * @date: 2018/9/20 23:33
 */
public class BuyVo implements Serializable {
    private static final long serialVersionUID = 180142428727702086L;
    /**
     * 日期
     */
    private LocalDate date;
    /**
     * 期数
     */
    private String no;
    /**
     * 购买金钱
     */
    private BigDecimal money;

    public LocalDate getDate() {
        return this.date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getNo() {
        return this.no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public BigDecimal getMoney() {
        return this.money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }
}
