package com.treasure.ssc.vo;

import java.io.Serializable;
import java.time.LocalDate;

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
    private String bef3times;
    private String bef6times;
    /**
     * 中三
     */
    private String mid3times;
    private String mid6times;
    /**
     * 后三
     */
    private String aft3times;
    private String aft6times;
    /**
     * 万千十
     */
    private String wqs3times;
    private String wqs6times;
    /**
     * 万千个
     */
    private String wqg3times;
    private String wqg6times;
    /**
     * 万百十
     */
    private String wbs3times;
    private String wbs6times;
    /**
     * 万百个
     */
    private String wbg3times;
    private String wbg6times;
    /**
     * 万十个
     */
    private String wsg3times;
    private String wsg6times;
    /**
     * 千百个
     */
    private String qbg3times;
    private String qbg6times;
    /**
     * 千十个
     */
    private String qsg3times;
    private String qsg6times;
    /**
     * 日期
     */
    private LocalDate date;

    public String getBef3times() {
        return this.bef3times;
    }

    public void setBef3times(String bef3times) {
        this.bef3times = bef3times;
    }

    public String getBef6times() {
        return this.bef6times;
    }

    public void setBef6times(String bef6times) {
        this.bef6times = bef6times;
    }

    public String getMid3times() {
        return this.mid3times;
    }

    public void setMid3times(String mid3times) {
        this.mid3times = mid3times;
    }

    public String getMid6times() {
        return this.mid6times;
    }

    public void setMid6times(String mid6times) {
        this.mid6times = mid6times;
    }

    public String getAft3times() {
        return this.aft3times;
    }

    public void setAft3times(String aft3times) {
        this.aft3times = aft3times;
    }

    public String getAft6times() {
        return this.aft6times;
    }

    public void setAft6times(String aft6times) {
        this.aft6times = aft6times;
    }

    public String getWqs3times() {
        return this.wqs3times;
    }

    public void setWqs3times(String wqs3times) {
        this.wqs3times = wqs3times;
    }

    public String getWqs6times() {
        return this.wqs6times;
    }

    public void setWqs6times(String wqs6times) {
        this.wqs6times = wqs6times;
    }

    public String getWqg3times() {
        return this.wqg3times;
    }

    public void setWqg3times(String wqg3times) {
        this.wqg3times = wqg3times;
    }

    public String getWqg6times() {
        return this.wqg6times;
    }

    public void setWqg6times(String wqg6times) {
        this.wqg6times = wqg6times;
    }

    public String getWbs3times() {
        return this.wbs3times;
    }

    public void setWbs3times(String wbs3times) {
        this.wbs3times = wbs3times;
    }

    public String getWbs6times() {
        return this.wbs6times;
    }

    public void setWbs6times(String wbs6times) {
        this.wbs6times = wbs6times;
    }

    public String getWbg3times() {
        return this.wbg3times;
    }

    public void setWbg3times(String wbg3times) {
        this.wbg3times = wbg3times;
    }

    public String getWbg6times() {
        return this.wbg6times;
    }

    public void setWbg6times(String wbg6times) {
        this.wbg6times = wbg6times;
    }

    public String getWsg3times() {
        return this.wsg3times;
    }

    public void setWsg3times(String wsg3times) {
        this.wsg3times = wsg3times;
    }

    public String getWsg6times() {
        return this.wsg6times;
    }

    public void setWsg6times(String wsg6times) {
        this.wsg6times = wsg6times;
    }

    public String getQbg3times() {
        return this.qbg3times;
    }

    public void setQbg3times(String qbg3times) {
        this.qbg3times = qbg3times;
    }

    public String getQbg6times() {
        return this.qbg6times;
    }

    public void setQbg6times(String qbg6times) {
        this.qbg6times = qbg6times;
    }

    public String getQsg3times() {
        return this.qsg3times;
    }

    public void setQsg3times(String qsg3times) {
        this.qsg3times = qsg3times;
    }

    public String getQsg6times() {
        return this.qsg6times;
    }

    public void setQsg6times(String qsg6times) {
        this.qsg6times = qsg6times;
    }

    public LocalDate getDate() {
        return this.date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
