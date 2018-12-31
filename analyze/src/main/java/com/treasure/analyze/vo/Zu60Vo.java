package com.treasure.analyze.vo;

import java.io.Serializable;

/**
 * @author: mazy
 * @date: 2018/12/31 16:35
 */
public class Zu60Vo implements Serializable {
    private static final long serialVersionUID = 8203355950992016963L;
    /**
     * 日期
     */
    private String day;
    /**
     * 期数
     */
    private String no;
    /**
     * 号码
     */
    private String num;
    /**
     * 是否组60
     */
    private Boolean if60;

    public String getDay() {
        return this.day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getNo() {
        return this.no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getNum() {
        return this.num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public Boolean getIf60() {
        return this.if60;
    }

    public void setIf60(Boolean if60) {
        this.if60 = if60;
    }
}
