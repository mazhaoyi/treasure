package com.treasure.auto.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BuyItemExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table buy_item
     *
     * @mbg.generated Sun Sep 30 16:04:29 CST 2018
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table buy_item
     *
     * @mbg.generated Sun Sep 30 16:04:29 CST 2018
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table buy_item
     *
     * @mbg.generated Sun Sep 30 16:04:29 CST 2018
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table buy_item
     *
     * @mbg.generated Sun Sep 30 16:04:29 CST 2018
     */
    public BuyItemExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table buy_item
     *
     * @mbg.generated Sun Sep 30 16:04:29 CST 2018
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table buy_item
     *
     * @mbg.generated Sun Sep 30 16:04:29 CST 2018
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table buy_item
     *
     * @mbg.generated Sun Sep 30 16:04:29 CST 2018
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table buy_item
     *
     * @mbg.generated Sun Sep 30 16:04:29 CST 2018
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table buy_item
     *
     * @mbg.generated Sun Sep 30 16:04:29 CST 2018
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table buy_item
     *
     * @mbg.generated Sun Sep 30 16:04:29 CST 2018
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table buy_item
     *
     * @mbg.generated Sun Sep 30 16:04:29 CST 2018
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table buy_item
     *
     * @mbg.generated Sun Sep 30 16:04:29 CST 2018
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
     * This method corresponds to the database table buy_item
     *
     * @mbg.generated Sun Sep 30 16:04:29 CST 2018
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table buy_item
     *
     * @mbg.generated Sun Sep 30 16:04:29 CST 2018
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table buy_item
     *
     * @mbg.generated Sun Sep 30 16:04:29 CST 2018
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

        public Criteria andBuy_item_idIsNull() {
            addCriterion("buy_item_id is null");
            return (Criteria) this;
        }

        public Criteria andBuy_item_idIsNotNull() {
            addCriterion("buy_item_id is not null");
            return (Criteria) this;
        }

        public Criteria andBuy_item_idEqualTo(Integer value) {
            addCriterion("buy_item_id =", value, "buy_item_id");
            return (Criteria) this;
        }

        public Criteria andBuy_item_idNotEqualTo(Integer value) {
            addCriterion("buy_item_id <>", value, "buy_item_id");
            return (Criteria) this;
        }

        public Criteria andBuy_item_idGreaterThan(Integer value) {
            addCriterion("buy_item_id >", value, "buy_item_id");
            return (Criteria) this;
        }

        public Criteria andBuy_item_idGreaterThanOrEqualTo(Integer value) {
            addCriterion("buy_item_id >=", value, "buy_item_id");
            return (Criteria) this;
        }

        public Criteria andBuy_item_idLessThan(Integer value) {
            addCriterion("buy_item_id <", value, "buy_item_id");
            return (Criteria) this;
        }

        public Criteria andBuy_item_idLessThanOrEqualTo(Integer value) {
            addCriterion("buy_item_id <=", value, "buy_item_id");
            return (Criteria) this;
        }

        public Criteria andBuy_item_idIn(List<Integer> values) {
            addCriterion("buy_item_id in", values, "buy_item_id");
            return (Criteria) this;
        }

        public Criteria andBuy_item_idNotIn(List<Integer> values) {
            addCriterion("buy_item_id not in", values, "buy_item_id");
            return (Criteria) this;
        }

        public Criteria andBuy_item_idBetween(Integer value1, Integer value2) {
            addCriterion("buy_item_id between", value1, value2, "buy_item_id");
            return (Criteria) this;
        }

        public Criteria andBuy_item_idNotBetween(Integer value1, Integer value2) {
            addCriterion("buy_item_id not between", value1, value2, "buy_item_id");
            return (Criteria) this;
        }

        public Criteria andBuy_idIsNull() {
            addCriterion("buy_id is null");
            return (Criteria) this;
        }

        public Criteria andBuy_idIsNotNull() {
            addCriterion("buy_id is not null");
            return (Criteria) this;
        }

        public Criteria andBuy_idEqualTo(Integer value) {
            addCriterion("buy_id =", value, "buy_id");
            return (Criteria) this;
        }

        public Criteria andBuy_idNotEqualTo(Integer value) {
            addCriterion("buy_id <>", value, "buy_id");
            return (Criteria) this;
        }

        public Criteria andBuy_idGreaterThan(Integer value) {
            addCriterion("buy_id >", value, "buy_id");
            return (Criteria) this;
        }

        public Criteria andBuy_idGreaterThanOrEqualTo(Integer value) {
            addCriterion("buy_id >=", value, "buy_id");
            return (Criteria) this;
        }

        public Criteria andBuy_idLessThan(Integer value) {
            addCriterion("buy_id <", value, "buy_id");
            return (Criteria) this;
        }

        public Criteria andBuy_idLessThanOrEqualTo(Integer value) {
            addCriterion("buy_id <=", value, "buy_id");
            return (Criteria) this;
        }

        public Criteria andBuy_idIn(List<Integer> values) {
            addCriterion("buy_id in", values, "buy_id");
            return (Criteria) this;
        }

        public Criteria andBuy_idNotIn(List<Integer> values) {
            addCriterion("buy_id not in", values, "buy_id");
            return (Criteria) this;
        }

        public Criteria andBuy_idBetween(Integer value1, Integer value2) {
            addCriterion("buy_id between", value1, value2, "buy_id");
            return (Criteria) this;
        }

        public Criteria andBuy_idNotBetween(Integer value1, Integer value2) {
            addCriterion("buy_id not between", value1, value2, "buy_id");
            return (Criteria) this;
        }

        public Criteria andCreate_timeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreate_timeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreate_timeEqualTo(Date value) {
            addCriterion("create_time =", value, "create_time");
            return (Criteria) this;
        }

        public Criteria andCreate_timeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "create_time");
            return (Criteria) this;
        }

        public Criteria andCreate_timeGreaterThan(Date value) {
            addCriterion("create_time >", value, "create_time");
            return (Criteria) this;
        }

        public Criteria andCreate_timeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "create_time");
            return (Criteria) this;
        }

        public Criteria andCreate_timeLessThan(Date value) {
            addCriterion("create_time <", value, "create_time");
            return (Criteria) this;
        }

        public Criteria andCreate_timeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "create_time");
            return (Criteria) this;
        }

        public Criteria andCreate_timeIn(List<Date> values) {
            addCriterion("create_time in", values, "create_time");
            return (Criteria) this;
        }

        public Criteria andCreate_timeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "create_time");
            return (Criteria) this;
        }

        public Criteria andCreate_timeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "create_time");
            return (Criteria) this;
        }

        public Criteria andCreate_timeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "create_time");
            return (Criteria) this;
        }

        public Criteria andUpdate_timeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdate_timeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdate_timeEqualTo(Date value) {
            addCriterion("update_time =", value, "update_time");
            return (Criteria) this;
        }

        public Criteria andUpdate_timeNotEqualTo(Date value) {
            addCriterion("update_time <>", value, "update_time");
            return (Criteria) this;
        }

        public Criteria andUpdate_timeGreaterThan(Date value) {
            addCriterion("update_time >", value, "update_time");
            return (Criteria) this;
        }

        public Criteria andUpdate_timeGreaterThanOrEqualTo(Date value) {
            addCriterion("update_time >=", value, "update_time");
            return (Criteria) this;
        }

        public Criteria andUpdate_timeLessThan(Date value) {
            addCriterion("update_time <", value, "update_time");
            return (Criteria) this;
        }

        public Criteria andUpdate_timeLessThanOrEqualTo(Date value) {
            addCriterion("update_time <=", value, "update_time");
            return (Criteria) this;
        }

        public Criteria andUpdate_timeIn(List<Date> values) {
            addCriterion("update_time in", values, "update_time");
            return (Criteria) this;
        }

        public Criteria andUpdate_timeNotIn(List<Date> values) {
            addCriterion("update_time not in", values, "update_time");
            return (Criteria) this;
        }

        public Criteria andUpdate_timeBetween(Date value1, Date value2) {
            addCriterion("update_time between", value1, value2, "update_time");
            return (Criteria) this;
        }

        public Criteria andUpdate_timeNotBetween(Date value1, Date value2) {
            addCriterion("update_time not between", value1, value2, "update_time");
            return (Criteria) this;
        }

        public Criteria andItem_flagIsNull() {
            addCriterion("item_flag is null");
            return (Criteria) this;
        }

        public Criteria andItem_flagIsNotNull() {
            addCriterion("item_flag is not null");
            return (Criteria) this;
        }

        public Criteria andItem_flagEqualTo(Boolean value) {
            addCriterion("item_flag =", value, "item_flag");
            return (Criteria) this;
        }

        public Criteria andItem_flagNotEqualTo(Boolean value) {
            addCriterion("item_flag <>", value, "item_flag");
            return (Criteria) this;
        }

        public Criteria andItem_flagGreaterThan(Boolean value) {
            addCriterion("item_flag >", value, "item_flag");
            return (Criteria) this;
        }

        public Criteria andItem_flagGreaterThanOrEqualTo(Boolean value) {
            addCriterion("item_flag >=", value, "item_flag");
            return (Criteria) this;
        }

        public Criteria andItem_flagLessThan(Boolean value) {
            addCriterion("item_flag <", value, "item_flag");
            return (Criteria) this;
        }

        public Criteria andItem_flagLessThanOrEqualTo(Boolean value) {
            addCriterion("item_flag <=", value, "item_flag");
            return (Criteria) this;
        }

        public Criteria andItem_flagIn(List<Boolean> values) {
            addCriterion("item_flag in", values, "item_flag");
            return (Criteria) this;
        }

        public Criteria andItem_flagNotIn(List<Boolean> values) {
            addCriterion("item_flag not in", values, "item_flag");
            return (Criteria) this;
        }

        public Criteria andItem_flagBetween(Boolean value1, Boolean value2) {
            addCriterion("item_flag between", value1, value2, "item_flag");
            return (Criteria) this;
        }

        public Criteria andItem_flagNotBetween(Boolean value1, Boolean value2) {
            addCriterion("item_flag not between", value1, value2, "item_flag");
            return (Criteria) this;
        }

        public Criteria andBuy_moneyIsNull() {
            addCriterion("buy_money is null");
            return (Criteria) this;
        }

        public Criteria andBuy_moneyIsNotNull() {
            addCriterion("buy_money is not null");
            return (Criteria) this;
        }

        public Criteria andBuy_moneyEqualTo(BigDecimal value) {
            addCriterion("buy_money =", value, "buy_money");
            return (Criteria) this;
        }

        public Criteria andBuy_moneyNotEqualTo(BigDecimal value) {
            addCriterion("buy_money <>", value, "buy_money");
            return (Criteria) this;
        }

        public Criteria andBuy_moneyGreaterThan(BigDecimal value) {
            addCriterion("buy_money >", value, "buy_money");
            return (Criteria) this;
        }

        public Criteria andBuy_moneyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("buy_money >=", value, "buy_money");
            return (Criteria) this;
        }

        public Criteria andBuy_moneyLessThan(BigDecimal value) {
            addCriterion("buy_money <", value, "buy_money");
            return (Criteria) this;
        }

        public Criteria andBuy_moneyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("buy_money <=", value, "buy_money");
            return (Criteria) this;
        }

        public Criteria andBuy_moneyIn(List<BigDecimal> values) {
            addCriterion("buy_money in", values, "buy_money");
            return (Criteria) this;
        }

        public Criteria andBuy_moneyNotIn(List<BigDecimal> values) {
            addCriterion("buy_money not in", values, "buy_money");
            return (Criteria) this;
        }

        public Criteria andBuy_moneyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("buy_money between", value1, value2, "buy_money");
            return (Criteria) this;
        }

        public Criteria andBuy_moneyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("buy_money not between", value1, value2, "buy_money");
            return (Criteria) this;
        }

        public Criteria andTicket_idIsNull() {
            addCriterion("ticket_id is null");
            return (Criteria) this;
        }

        public Criteria andTicket_idIsNotNull() {
            addCriterion("ticket_id is not null");
            return (Criteria) this;
        }

        public Criteria andTicket_idEqualTo(Integer value) {
            addCriterion("ticket_id =", value, "ticket_id");
            return (Criteria) this;
        }

        public Criteria andTicket_idNotEqualTo(Integer value) {
            addCriterion("ticket_id <>", value, "ticket_id");
            return (Criteria) this;
        }

        public Criteria andTicket_idGreaterThan(Integer value) {
            addCriterion("ticket_id >", value, "ticket_id");
            return (Criteria) this;
        }

        public Criteria andTicket_idGreaterThanOrEqualTo(Integer value) {
            addCriterion("ticket_id >=", value, "ticket_id");
            return (Criteria) this;
        }

        public Criteria andTicket_idLessThan(Integer value) {
            addCriterion("ticket_id <", value, "ticket_id");
            return (Criteria) this;
        }

        public Criteria andTicket_idLessThanOrEqualTo(Integer value) {
            addCriterion("ticket_id <=", value, "ticket_id");
            return (Criteria) this;
        }

        public Criteria andTicket_idIn(List<Integer> values) {
            addCriterion("ticket_id in", values, "ticket_id");
            return (Criteria) this;
        }

        public Criteria andTicket_idNotIn(List<Integer> values) {
            addCriterion("ticket_id not in", values, "ticket_id");
            return (Criteria) this;
        }

        public Criteria andTicket_idBetween(Integer value1, Integer value2) {
            addCriterion("ticket_id between", value1, value2, "ticket_id");
            return (Criteria) this;
        }

        public Criteria andTicket_idNotBetween(Integer value1, Integer value2) {
            addCriterion("ticket_id not between", value1, value2, "ticket_id");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table buy_item
     *
     * @mbg.generated do_not_delete_during_merge Sun Sep 30 16:04:29 CST 2018
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table buy_item
     *
     * @mbg.generated Sun Sep 30 16:04:29 CST 2018
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