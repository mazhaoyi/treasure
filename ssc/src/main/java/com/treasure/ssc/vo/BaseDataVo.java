package com.treasure.ssc.vo;

import java.io.Serializable;

/**
 * 远端数据
 * @author: mazy
 * @date: 2018/11/2 15:10
 */
public class BaseDataVo implements Serializable {
    private static final long serialVersionUID = -2541661760704383578L;
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
}
