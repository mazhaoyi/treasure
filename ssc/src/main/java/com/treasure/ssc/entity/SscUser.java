package com.treasure.ssc.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @author: mazy
 * @date: 2018/9/28 17:31
 */
public class SscUser implements Serializable {
    private static final long serialVersionUID = 439711104747899992L;
    private Integer userId;
    private String username;
    private BigDecimal money;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
    private String nowNo;
    private LocalDate nowDate;
    private Boolean newDate;

    public Boolean getNewDate() {
        return this.newDate;
    }

    public void setNewDate(Boolean newDate) {
        this.newDate = newDate;
    }

    public String getNowNo() {
        return this.nowNo;
    }

    public void setNowNo(String nowNo) {
        this.nowNo = nowNo;
    }

    public LocalDate getNowDate() {
        return this.nowDate;
    }

    public void setNowDate(LocalDate nowDate) {
        this.nowDate = nowDate;
    }

    public Integer getUserId() {
        return this.userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public BigDecimal getMoney() {
        return this.money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
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
}
