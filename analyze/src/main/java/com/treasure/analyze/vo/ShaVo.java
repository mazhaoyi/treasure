package com.treasure.analyze.vo;

import java.io.Serializable;

/**
 * @author: mazy
 * @date: 2018/12/1 14:08
 */
public class ShaVo implements Serializable {
    private static final long serialVersionUID = -3103428815426897766L;
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
     * 要杀的数字
     */
    private String shaNum;
    /**
     * 后三是否杀中
     */
    private Boolean ifAftSha;

    public Boolean getIfAftSha() {
        return this.ifAftSha;
    }

    public void setIfAftSha(Boolean ifAftSha) {
        this.ifAftSha = ifAftSha;
    }

    public String getShaNum() {
        return this.shaNum;
    }

    public void setShaNum(String shaNum) {
        this.shaNum = shaNum;
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
