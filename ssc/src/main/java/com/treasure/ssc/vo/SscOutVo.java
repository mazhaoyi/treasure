package com.treasure.ssc.vo;

import com.treasure.ssc.entity.Ticket;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author: mazy
 * @date: 2018/9/28 16:45
 */
public class SscOutVo extends Ticket implements Serializable {
    private static final long serialVersionUID = 2636177024471500313L;
    /**
     * 总金额
     */
    private BigDecimal allMoney;
    /**
     * 原金额
     */
    private BigDecimal money;
    /**
     * 中奖金额
     */
    private BigDecimal fee;
    /**
     * 撤单的钱
     */
    private BigDecimal reFee;

    public BigDecimal getReFee() {
        return this.reFee;
    }

    public void setReFee(BigDecimal reFee) {
        this.reFee = reFee;
    }

    public BigDecimal getFee() {
        return this.fee;
    }

    public void setFee(BigDecimal fee) {
        this.fee = fee;
    }

    public BigDecimal getMoney() {
        return this.money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    public BigDecimal getAllMoney() {
        return this.allMoney;
    }

    public void setAllMoney(BigDecimal allMoney) {
        this.allMoney = allMoney;
    }
}
