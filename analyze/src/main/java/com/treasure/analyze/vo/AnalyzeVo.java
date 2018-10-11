package com.treasure.analyze.vo;

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
    /**
     * 万千十
     */
    private Integer wqsMaxCount;
    /**
     * 万千十012路
     */
    private Boolean wqs012;
    /**
     * 万千个
     */
    private Integer wqgMaxCount;
    /**
     * 万千个012路
     */
    private Boolean wqg012;
    /**
     * 万百十
     */
    private Integer wbsMaxCount;
    /**
     * 万百十012路
     */
    private Boolean wbs012;
    /**
     * 万百个
     */
    private Integer wbgMaxCount;
    /**
     * 万百个012路
     */
    private Boolean wbg012;
    /**
     * 万十个
     */
    private Integer wsgMaxCount;
    /**
     * 万十个012路
     */
    private Boolean wsg012;
    /**
     * 千百个
     */
    private Integer qbgMaxCount;
    /**
     * 千百个012路
     */
    private Boolean qbg012;
    /**
     * 千十个
     */
    private Integer qsgMaxCount;
    /**
     * 千十个012路
     */
    private Boolean qsg012;
    /**
     * 五星组30
     */
    private Boolean wxz30;
    /**
     * 五星组20
     */
    private Boolean wxz20;
    /**
     * 五星组10
     */
    private Boolean wxz10;
    /**
     * 五星组5
     */
    private Boolean wxz5;

    public Boolean getWqs012() {
        return this.wqs012;
    }

    public void setWqs012(Boolean wqs012) {
        this.wqs012 = wqs012;
    }

    public Boolean getWqg012() {
        return this.wqg012;
    }

    public void setWqg012(Boolean wqg012) {
        this.wqg012 = wqg012;
    }

    public Boolean getWbs012() {
        return this.wbs012;
    }

    public void setWbs012(Boolean wbs012) {
        this.wbs012 = wbs012;
    }

    public Boolean getWbg012() {
        return this.wbg012;
    }

    public void setWbg012(Boolean wbg012) {
        this.wbg012 = wbg012;
    }

    public Boolean getWsg012() {
        return this.wsg012;
    }

    public void setWsg012(Boolean wsg012) {
        this.wsg012 = wsg012;
    }

    public Boolean getQbg012() {
        return this.qbg012;
    }

    public void setQbg012(Boolean qbg012) {
        this.qbg012 = qbg012;
    }

    public Boolean getQsg012() {
        return this.qsg012;
    }

    public void setQsg012(Boolean qsg012) {
        this.qsg012 = qsg012;
    }

    public Integer getWqsMaxCount() {
        return this.wqsMaxCount;
    }

    public void setWqsMaxCount(Integer wqsMaxCount) {
        this.wqsMaxCount = wqsMaxCount;
    }

    public Integer getWqgMaxCount() {
        return this.wqgMaxCount;
    }

    public void setWqgMaxCount(Integer wqgMaxCount) {
        this.wqgMaxCount = wqgMaxCount;
    }

    public Integer getWbsMaxCount() {
        return this.wbsMaxCount;
    }

    public void setWbsMaxCount(Integer wbsMaxCount) {
        this.wbsMaxCount = wbsMaxCount;
    }

    public Integer getWbgMaxCount() {
        return this.wbgMaxCount;
    }

    public void setWbgMaxCount(Integer wbgMaxCount) {
        this.wbgMaxCount = wbgMaxCount;
    }

    public Integer getWsgMaxCount() {
        return this.wsgMaxCount;
    }

    public void setWsgMaxCount(Integer wsgMaxCount) {
        this.wsgMaxCount = wsgMaxCount;
    }

    public Integer getQbgMaxCount() {
        return this.qbgMaxCount;
    }

    public void setQbgMaxCount(Integer qbgMaxCount) {
        this.qbgMaxCount = qbgMaxCount;
    }

    public Integer getQsgMaxCount() {
        return this.qsgMaxCount;
    }

    public void setQsgMaxCount(Integer qsgMaxCount) {
        this.qsgMaxCount = qsgMaxCount;
    }

    public Boolean getWxz10() {
        return this.wxz10;
    }

    public void setWxz10(Boolean wxz10) {
        this.wxz10 = wxz10;
    }

    public Boolean getWxz5() {
        return this.wxz5;
    }

    public void setWxz5(Boolean wxz5) {
        this.wxz5 = wxz5;
    }

    public Boolean getWxz30() {
        return this.wxz30;
    }

    public void setWxz30(Boolean wxz30) {
        this.wxz30 = wxz30;
    }

    public Boolean getWxz20() {
        return this.wxz20;
    }

    public void setWxz20(Boolean wxz20) {
        this.wxz20 = wxz20;
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
