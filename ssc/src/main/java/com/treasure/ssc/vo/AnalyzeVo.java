package com.treasure.ssc.vo;

import java.io.Serializable;

/**
 * @author: mazy
 * @date: 2018/10/9 15:05
 */
public class AnalyzeVo implements Serializable {
    private static final long serialVersionUID = -8001985273920304673L;
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
     * 前三012路
     */
    private Boolean bef3012;
    /**
     * 中三最大相同个数
     */
    private Integer mid3MaxCount;
    /**
     * 中三012路
     */
    private Boolean mid3012;
    /**
     * 后三最大相同个数
     */
    private Integer aft3MaxCount;
    /**
     * 后三012路
     */
    private Boolean aft3012;

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

    public Integer getBef3MaxCount() {
        return this.bef3MaxCount;
    }

    public void setBef3MaxCount(Integer bef3MaxCount) {
        this.bef3MaxCount = bef3MaxCount;
    }

    public Boolean getBef3012() {
        return this.bef3012;
    }

    public void setBef3012(Boolean bef3012) {
        this.bef3012 = bef3012;
    }

    public Integer getMid3MaxCount() {
        return this.mid3MaxCount;
    }

    public void setMid3MaxCount(Integer mid3MaxCount) {
        this.mid3MaxCount = mid3MaxCount;
    }

    public Boolean getMid3012() {
        return this.mid3012;
    }

    public void setMid3012(Boolean mid3012) {
        this.mid3012 = mid3012;
    }

    public Integer getAft3MaxCount() {
        return this.aft3MaxCount;
    }

    public void setAft3MaxCount(Integer aft3MaxCount) {
        this.aft3MaxCount = aft3MaxCount;
    }

    public Boolean getAft3012() {
        return this.aft3012;
    }

    public void setAft3012(Boolean aft3012) {
        this.aft3012 = aft3012;
    }
}
