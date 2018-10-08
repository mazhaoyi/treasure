package com.treasure.auto.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class BzExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table bz
     *
     * @mbg.generated
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table bz
     *
     * @mbg.generated
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table bz
     *
     * @mbg.generated
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bz
     *
     * @mbg.generated
     */
    public BzExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bz
     *
     * @mbg.generated
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bz
     *
     * @mbg.generated
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bz
     *
     * @mbg.generated
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bz
     *
     * @mbg.generated
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bz
     *
     * @mbg.generated
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bz
     *
     * @mbg.generated
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bz
     *
     * @mbg.generated
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bz
     *
     * @mbg.generated
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bz
     *
     * @mbg.generated
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bz
     *
     * @mbg.generated
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table bz
     *
     * @mbg.generated
     */
    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
        }

        public Criteria andBzIdIsNull() {
            addCriterion("bz_id is null");
            return (Criteria) this;
        }

        public Criteria andBzIdIsNotNull() {
            addCriterion("bz_id is not null");
            return (Criteria) this;
        }

        public Criteria andBzIdEqualTo(Integer value) {
            addCriterion("bz_id =", value, "bzId");
            return (Criteria) this;
        }

        public Criteria andBzIdNotEqualTo(Integer value) {
            addCriterion("bz_id <>", value, "bzId");
            return (Criteria) this;
        }

        public Criteria andBzIdGreaterThan(Integer value) {
            addCriterion("bz_id >", value, "bzId");
            return (Criteria) this;
        }

        public Criteria andBzIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("bz_id >=", value, "bzId");
            return (Criteria) this;
        }

        public Criteria andBzIdLessThan(Integer value) {
            addCriterion("bz_id <", value, "bzId");
            return (Criteria) this;
        }

        public Criteria andBzIdLessThanOrEqualTo(Integer value) {
            addCriterion("bz_id <=", value, "bzId");
            return (Criteria) this;
        }

        public Criteria andBzIdIn(List<Integer> values) {
            addCriterion("bz_id in", values, "bzId");
            return (Criteria) this;
        }

        public Criteria andBzIdNotIn(List<Integer> values) {
            addCriterion("bz_id not in", values, "bzId");
            return (Criteria) this;
        }

        public Criteria andBzIdBetween(Integer value1, Integer value2) {
            addCriterion("bz_id between", value1, value2, "bzId");
            return (Criteria) this;
        }

        public Criteria andBzIdNotBetween(Integer value1, Integer value2) {
            addCriterion("bz_id not between", value1, value2, "bzId");
            return (Criteria) this;
        }

        public Criteria andCountNumIsNull() {
            addCriterion("count_num is null");
            return (Criteria) this;
        }

        public Criteria andCountNumIsNotNull() {
            addCriterion("count_num is not null");
            return (Criteria) this;
        }

        public Criteria andCountNumEqualTo(Short value) {
            addCriterion("count_num =", value, "countNum");
            return (Criteria) this;
        }

        public Criteria andCountNumNotEqualTo(Short value) {
            addCriterion("count_num <>", value, "countNum");
            return (Criteria) this;
        }

        public Criteria andCountNumGreaterThan(Short value) {
            addCriterion("count_num >", value, "countNum");
            return (Criteria) this;
        }

        public Criteria andCountNumGreaterThanOrEqualTo(Short value) {
            addCriterion("count_num >=", value, "countNum");
            return (Criteria) this;
        }

        public Criteria andCountNumLessThan(Short value) {
            addCriterion("count_num <", value, "countNum");
            return (Criteria) this;
        }

        public Criteria andCountNumLessThanOrEqualTo(Short value) {
            addCriterion("count_num <=", value, "countNum");
            return (Criteria) this;
        }

        public Criteria andCountNumIn(List<Short> values) {
            addCriterion("count_num in", values, "countNum");
            return (Criteria) this;
        }

        public Criteria andCountNumNotIn(List<Short> values) {
            addCriterion("count_num not in", values, "countNum");
            return (Criteria) this;
        }

        public Criteria andCountNumBetween(Short value1, Short value2) {
            addCriterion("count_num between", value1, value2, "countNum");
            return (Criteria) this;
        }

        public Criteria andCountNumNotBetween(Short value1, Short value2) {
            addCriterion("count_num not between", value1, value2, "countNum");
            return (Criteria) this;
        }

        public Criteria andBzDateIsNull() {
            addCriterion("bz_date is null");
            return (Criteria) this;
        }

        public Criteria andBzDateIsNotNull() {
            addCriterion("bz_date is not null");
            return (Criteria) this;
        }

        public Criteria andBzDateEqualTo(Date value) {
            addCriterionForJDBCDate("bz_date =", value, "bzDate");
            return (Criteria) this;
        }

        public Criteria andBzDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("bz_date <>", value, "bzDate");
            return (Criteria) this;
        }

        public Criteria andBzDateGreaterThan(Date value) {
            addCriterionForJDBCDate("bz_date >", value, "bzDate");
            return (Criteria) this;
        }

        public Criteria andBzDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("bz_date >=", value, "bzDate");
            return (Criteria) this;
        }

        public Criteria andBzDateLessThan(Date value) {
            addCriterionForJDBCDate("bz_date <", value, "bzDate");
            return (Criteria) this;
        }

        public Criteria andBzDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("bz_date <=", value, "bzDate");
            return (Criteria) this;
        }

        public Criteria andBzDateIn(List<Date> values) {
            addCriterionForJDBCDate("bz_date in", values, "bzDate");
            return (Criteria) this;
        }

        public Criteria andBzDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("bz_date not in", values, "bzDate");
            return (Criteria) this;
        }

        public Criteria andBzDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("bz_date between", value1, value2, "bzDate");
            return (Criteria) this;
        }

        public Criteria andBzDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("bz_date not between", value1, value2, "bzDate");
            return (Criteria) this;
        }

        public Criteria andBzTypeCodeIsNull() {
            addCriterion("bz_type_code is null");
            return (Criteria) this;
        }

        public Criteria andBzTypeCodeIsNotNull() {
            addCriterion("bz_type_code is not null");
            return (Criteria) this;
        }

        public Criteria andBzTypeCodeEqualTo(String value) {
            addCriterion("bz_type_code =", value, "bzTypeCode");
            return (Criteria) this;
        }

        public Criteria andBzTypeCodeNotEqualTo(String value) {
            addCriterion("bz_type_code <>", value, "bzTypeCode");
            return (Criteria) this;
        }

        public Criteria andBzTypeCodeGreaterThan(String value) {
            addCriterion("bz_type_code >", value, "bzTypeCode");
            return (Criteria) this;
        }

        public Criteria andBzTypeCodeGreaterThanOrEqualTo(String value) {
            addCriterion("bz_type_code >=", value, "bzTypeCode");
            return (Criteria) this;
        }

        public Criteria andBzTypeCodeLessThan(String value) {
            addCriterion("bz_type_code <", value, "bzTypeCode");
            return (Criteria) this;
        }

        public Criteria andBzTypeCodeLessThanOrEqualTo(String value) {
            addCriterion("bz_type_code <=", value, "bzTypeCode");
            return (Criteria) this;
        }

        public Criteria andBzTypeCodeLike(String value) {
            addCriterion("bz_type_code like", value, "bzTypeCode");
            return (Criteria) this;
        }

        public Criteria andBzTypeCodeNotLike(String value) {
            addCriterion("bz_type_code not like", value, "bzTypeCode");
            return (Criteria) this;
        }

        public Criteria andBzTypeCodeIn(List<String> values) {
            addCriterion("bz_type_code in", values, "bzTypeCode");
            return (Criteria) this;
        }

        public Criteria andBzTypeCodeNotIn(List<String> values) {
            addCriterion("bz_type_code not in", values, "bzTypeCode");
            return (Criteria) this;
        }

        public Criteria andBzTypeCodeBetween(String value1, String value2) {
            addCriterion("bz_type_code between", value1, value2, "bzTypeCode");
            return (Criteria) this;
        }

        public Criteria andBzTypeCodeNotBetween(String value1, String value2) {
            addCriterion("bz_type_code not between", value1, value2, "bzTypeCode");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table bz
     *
     * @mbg.generated do_not_delete_during_merge
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table bz
     *
     * @mbg.generated
     */
    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}