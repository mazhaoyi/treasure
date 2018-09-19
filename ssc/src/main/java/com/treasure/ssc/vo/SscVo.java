package com.treasure.ssc.vo;

import java.io.Serializable;

/**
 * @author: mazy
 * @date: 2018/9/18 13:23
 */
public class SscVo implements Serializable {
    private static final long serialVersionUID = -5856910006975907007L;
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
     * 前三最大相同个数
     */
    private Integer bef3MaxCount;
    /**
     * 中三最大相同个数
     */
    private Integer mid3MaxCount;
    /**
     * 后三最大相同个数
     */
    private Integer aft3MaxCount;

    public Integer getBef3MaxCount() {
        return this.bef3MaxCount;
    }

    public void setBef3MaxCount(Integer bef3MaxCount) {
        this.bef3MaxCount = bef3MaxCount;
    }

    public Integer getMid3MaxCount() {
        return this.mid3MaxCount;
    }

    public void setMid3MaxCount(Integer mid3MaxCount) {
        this.mid3MaxCount = mid3MaxCount;
    }

    public Integer getAft3MaxCount() {
        return this.aft3MaxCount;
    }

    public void setAft3MaxCount(Integer aft3MaxCount) {
        this.aft3MaxCount = aft3MaxCount;
    }

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
