package com.treasure.auto.entity;

import java.util.Date;

public class Bz {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bz.bz_id
     *
     * @mbg.generated
     */
    private Integer bzId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bz.count_num
     *
     * @mbg.generated
     */
    private Short countNum;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bz.the_date
     *
     * @mbg.generated
     */
    private Date theDate;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column bz.bz_id
     *
     * @return the value of bz.bz_id
     *
     * @mbg.generated
     */
    public Integer getBzId() {
        return bzId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column bz.bz_id
     *
     * @param bzId the value for bz.bz_id
     *
     * @mbg.generated
     */
    public void setBzId(Integer bzId) {
        this.bzId = bzId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column bz.count_num
     *
     * @return the value of bz.count_num
     *
     * @mbg.generated
     */
    public Short getCountNum() {
        return countNum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column bz.count_num
     *
     * @param countNum the value for bz.count_num
     *
     * @mbg.generated
     */
    public void setCountNum(Short countNum) {
        this.countNum = countNum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column bz.the_date
     *
     * @return the value of bz.the_date
     *
     * @mbg.generated
     */
    public Date getTheDate() {
        return theDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column bz.the_date
     *
     * @param theDate the value for bz.the_date
     *
     * @mbg.generated
     */
    public void setTheDate(Date theDate) {
        this.theDate = theDate;
    }
}