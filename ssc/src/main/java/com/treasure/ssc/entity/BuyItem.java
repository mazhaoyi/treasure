package com.treasure.ssc.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @author: mazy
 * @date: 2018/9/28 19:22
 */
public class BuyItem implements Serializable {
    private static final long serialVersionUID = -7104434568568432642L;
    private Integer buyItemId;
    private Integer userId;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
    private Short itemFlag;
    private BigDecimal buyMoney;
    private Integer ticketId;

    public Integer getBuyItemId() {
        return this.buyItemId;
    }

    public void setBuyItemId(Integer buyItemId) {
        this.buyItemId = buyItemId;
    }

    public Integer getUserId() {
        return this.userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public LocalDateTime getCreateTime() {
        return this.createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public LocalDateTime getUpdateTime() {
        return this.updateTime;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }

    public Short getItemFlag() {
        return this.itemFlag;
    }

    public void setItemFlag(Short itemFlag) {
        this.itemFlag = itemFlag;
    }

    public BigDecimal getBuyMoney() {
        return this.buyMoney;
    }

    public void setBuyMoney(BigDecimal buyMoney) {
        this.buyMoney = buyMoney;
    }

    public Integer getTicketId() {
        return this.ticketId;
    }

    public void setTicketId(Integer ticketId) {
        this.ticketId = ticketId;
    }
}
