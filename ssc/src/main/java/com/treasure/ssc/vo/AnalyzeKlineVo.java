package com.treasure.ssc.vo;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

/**
 * 组3日K线VO
 * @author: mazy
 * @date: 2018/11/5 11:47
 */
public class AnalyzeKlineVo implements Serializable {
    private static final long serialVersionUID = 7464860294804232412L;
    /**
     * 前三
     */
    private Integer bef3times;
    /**
     * 中三
     */
    private Integer mid3times;
    /**
     * 后三
     */
    private Integer aft3times;
    /**
     * 万千十
     */
    private Integer wqs3times;
    /**
     * 万千个
     */
    private Integer wqg3times;
    /**
     * 万百十
     */
    private Integer wbs3times;
    /**
     * 万百个
     */
    private Integer wbg3times;
    /**
     * 万十个
     */
    private Integer wsg3times;
    /**
     * 千百个
     */
    private Integer qbg3times;
    /**
     * 千十个
     */
    private Integer qsg3times;
    /**
     * 日期
     */
    private LocalDate date;

    public Integer getBef3times() {
        return this.bef3times;
    }

    public void setBef3times(Integer bef3times) {
        this.bef3times = bef3times;
    }

    public Integer getMid3times() {
        return this.mid3times;
    }

    public void setMid3times(Integer mid3times) {
        this.mid3times = mid3times;
    }

    public Integer getAft3times() {
        return this.aft3times;
    }

    public void setAft3times(Integer aft3times) {
        this.aft3times = aft3times;
    }

    public Integer getWqs3times() {
        return this.wqs3times;
    }

    public void setWqs3times(Integer wqs3times) {
        this.wqs3times = wqs3times;
    }

    public Integer getWqg3times() {
        return this.wqg3times;
    }

    public void setWqg3times(Integer wqg3times) {
        this.wqg3times = wqg3times;
    }

    public Integer getWbs3times() {
        return this.wbs3times;
    }

    public void setWbs3times(Integer wbs3times) {
        this.wbs3times = wbs3times;
    }

    public Integer getWbg3times() {
        return this.wbg3times;
    }

    public void setWbg3times(Integer wbg3times) {
        this.wbg3times = wbg3times;
    }

    public Integer getWsg3times() {
        return this.wsg3times;
    }

    public void setWsg3times(Integer wsg3times) {
        this.wsg3times = wsg3times;
    }

    public Integer getQbg3times() {
        return this.qbg3times;
    }

    public void setQbg3times(Integer qbg3times) {
        this.qbg3times = qbg3times;
    }

    public Integer getQsg3times() {
        return this.qsg3times;
    }

    public void setQsg3times(Integer qsg3times) {
        this.qsg3times = qsg3times;
    }

    public LocalDate getDate() {
        return this.date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {return true;}
        if (o == null || getClass() != o.getClass()) {return false;}
        AnalyzeKlineVo that = (AnalyzeKlineVo) o;
        return Objects.equals(date, that.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(date);
    }
}
