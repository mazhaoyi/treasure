package com.treasure.ssc.vo;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;
import java.util.Date;

/**
 * 外网豹子数据
 * @author: mazy
 * @date: 2018/10/8 14:25
 */
public class BzOtherVo implements Serializable {
    private static final long serialVersionUID = -2917525618798720890L;
    @JSONField(format = "yyyy-MM-dd")
    private Date day;
    private Short bsgType;
    private Short isBsg;
    private Short isQbg;
    private Short isQbs;
    private Short isQsg;
    private Short isWbg;
    private Short isWbs;
    private Short isWqb;
    private Short isWqg;
    private Short isWqs;
    private Short isWsg;
    private Short wxType;

    public Date getDay() {
        return this.day;
    }

    public void setDay(Date day) {
        this.day = day;
    }

    public Short getBsgType() {
        return this.bsgType;
    }

    public void setBsgType(Short bsgType) {
        this.bsgType = bsgType;
    }

    public Short getIsBsg() {
        return this.isBsg;
    }

    public void setIsBsg(Short isBsg) {
        this.isBsg = isBsg;
    }

    public Short getIsQbg() {
        return this.isQbg;
    }

    public void setIsQbg(Short isQbg) {
        this.isQbg = isQbg;
    }

    public Short getIsQbs() {
        return this.isQbs;
    }

    public void setIsQbs(Short isQbs) {
        this.isQbs = isQbs;
    }

    public Short getIsQsg() {
        return this.isQsg;
    }

    public void setIsQsg(Short isQsg) {
        this.isQsg = isQsg;
    }

    public Short getIsWbg() {
        return this.isWbg;
    }

    public void setIsWbg(Short isWbg) {
        this.isWbg = isWbg;
    }

    public Short getIsWbs() {
        return this.isWbs;
    }

    public void setIsWbs(Short isWbs) {
        this.isWbs = isWbs;
    }

    public Short getIsWqb() {
        return this.isWqb;
    }

    public void setIsWqb(Short isWqb) {
        this.isWqb = isWqb;
    }

    public Short getIsWqg() {
        return this.isWqg;
    }

    public void setIsWqg(Short isWqg) {
        this.isWqg = isWqg;
    }

    public Short getIsWqs() {
        return this.isWqs;
    }

    public void setIsWqs(Short isWqs) {
        this.isWqs = isWqs;
    }

    public Short getIsWsg() {
        return this.isWsg;
    }

    public void setIsWsg(Short isWsg) {
        this.isWsg = isWsg;
    }

    public Short getWxType() {
        return this.wxType;
    }

    public void setWxType(Short wxType) {
        this.wxType = wxType;
    }
}
