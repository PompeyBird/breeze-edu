package org.bird.breeze.edu.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EduFuncExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Integer offset;

    public EduFuncExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public Integer getOffset() {
        return offset;
    }

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

        public Criteria andIdIsNull() {
            addCriterion("ID is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("ID is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("ID =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("ID <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("ID >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("ID >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("ID <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("ID <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("ID in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("ID not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("ID between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("ID not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andFuncCodeIsNull() {
            addCriterion("FUNC_CODE is null");
            return (Criteria) this;
        }

        public Criteria andFuncCodeIsNotNull() {
            addCriterion("FUNC_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andFuncCodeEqualTo(String value) {
            addCriterion("FUNC_CODE =", value, "funcCode");
            return (Criteria) this;
        }

        public Criteria andFuncCodeNotEqualTo(String value) {
            addCriterion("FUNC_CODE <>", value, "funcCode");
            return (Criteria) this;
        }

        public Criteria andFuncCodeGreaterThan(String value) {
            addCriterion("FUNC_CODE >", value, "funcCode");
            return (Criteria) this;
        }

        public Criteria andFuncCodeGreaterThanOrEqualTo(String value) {
            addCriterion("FUNC_CODE >=", value, "funcCode");
            return (Criteria) this;
        }

        public Criteria andFuncCodeLessThan(String value) {
            addCriterion("FUNC_CODE <", value, "funcCode");
            return (Criteria) this;
        }

        public Criteria andFuncCodeLessThanOrEqualTo(String value) {
            addCriterion("FUNC_CODE <=", value, "funcCode");
            return (Criteria) this;
        }

        public Criteria andFuncCodeLike(String value) {
            addCriterion("FUNC_CODE like", value, "funcCode");
            return (Criteria) this;
        }

        public Criteria andFuncCodeNotLike(String value) {
            addCriterion("FUNC_CODE not like", value, "funcCode");
            return (Criteria) this;
        }

        public Criteria andFuncCodeIn(List<String> values) {
            addCriterion("FUNC_CODE in", values, "funcCode");
            return (Criteria) this;
        }

        public Criteria andFuncCodeNotIn(List<String> values) {
            addCriterion("FUNC_CODE not in", values, "funcCode");
            return (Criteria) this;
        }

        public Criteria andFuncCodeBetween(String value1, String value2) {
            addCriterion("FUNC_CODE between", value1, value2, "funcCode");
            return (Criteria) this;
        }

        public Criteria andFuncCodeNotBetween(String value1, String value2) {
            addCriterion("FUNC_CODE not between", value1, value2, "funcCode");
            return (Criteria) this;
        }

        public Criteria andFuncNameIsNull() {
            addCriterion("FUNC_NAME is null");
            return (Criteria) this;
        }

        public Criteria andFuncNameIsNotNull() {
            addCriterion("FUNC_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andFuncNameEqualTo(String value) {
            addCriterion("FUNC_NAME =", value, "funcName");
            return (Criteria) this;
        }

        public Criteria andFuncNameNotEqualTo(String value) {
            addCriterion("FUNC_NAME <>", value, "funcName");
            return (Criteria) this;
        }

        public Criteria andFuncNameGreaterThan(String value) {
            addCriterion("FUNC_NAME >", value, "funcName");
            return (Criteria) this;
        }

        public Criteria andFuncNameGreaterThanOrEqualTo(String value) {
            addCriterion("FUNC_NAME >=", value, "funcName");
            return (Criteria) this;
        }

        public Criteria andFuncNameLessThan(String value) {
            addCriterion("FUNC_NAME <", value, "funcName");
            return (Criteria) this;
        }

        public Criteria andFuncNameLessThanOrEqualTo(String value) {
            addCriterion("FUNC_NAME <=", value, "funcName");
            return (Criteria) this;
        }

        public Criteria andFuncNameLike(String value) {
            addCriterion("FUNC_NAME like", value, "funcName");
            return (Criteria) this;
        }

        public Criteria andFuncNameNotLike(String value) {
            addCriterion("FUNC_NAME not like", value, "funcName");
            return (Criteria) this;
        }

        public Criteria andFuncNameIn(List<String> values) {
            addCriterion("FUNC_NAME in", values, "funcName");
            return (Criteria) this;
        }

        public Criteria andFuncNameNotIn(List<String> values) {
            addCriterion("FUNC_NAME not in", values, "funcName");
            return (Criteria) this;
        }

        public Criteria andFuncNameBetween(String value1, String value2) {
            addCriterion("FUNC_NAME between", value1, value2, "funcName");
            return (Criteria) this;
        }

        public Criteria andFuncNameNotBetween(String value1, String value2) {
            addCriterion("FUNC_NAME not between", value1, value2, "funcName");
            return (Criteria) this;
        }

        public Criteria andFuncOrderIsNull() {
            addCriterion("FUNC_ORDER is null");
            return (Criteria) this;
        }

        public Criteria andFuncOrderIsNotNull() {
            addCriterion("FUNC_ORDER is not null");
            return (Criteria) this;
        }

        public Criteria andFuncOrderEqualTo(Integer value) {
            addCriterion("FUNC_ORDER =", value, "funcOrder");
            return (Criteria) this;
        }

        public Criteria andFuncOrderNotEqualTo(Integer value) {
            addCriterion("FUNC_ORDER <>", value, "funcOrder");
            return (Criteria) this;
        }

        public Criteria andFuncOrderGreaterThan(Integer value) {
            addCriterion("FUNC_ORDER >", value, "funcOrder");
            return (Criteria) this;
        }

        public Criteria andFuncOrderGreaterThanOrEqualTo(Integer value) {
            addCriterion("FUNC_ORDER >=", value, "funcOrder");
            return (Criteria) this;
        }

        public Criteria andFuncOrderLessThan(Integer value) {
            addCriterion("FUNC_ORDER <", value, "funcOrder");
            return (Criteria) this;
        }

        public Criteria andFuncOrderLessThanOrEqualTo(Integer value) {
            addCriterion("FUNC_ORDER <=", value, "funcOrder");
            return (Criteria) this;
        }

        public Criteria andFuncOrderIn(List<Integer> values) {
            addCriterion("FUNC_ORDER in", values, "funcOrder");
            return (Criteria) this;
        }

        public Criteria andFuncOrderNotIn(List<Integer> values) {
            addCriterion("FUNC_ORDER not in", values, "funcOrder");
            return (Criteria) this;
        }

        public Criteria andFuncOrderBetween(Integer value1, Integer value2) {
            addCriterion("FUNC_ORDER between", value1, value2, "funcOrder");
            return (Criteria) this;
        }

        public Criteria andFuncOrderNotBetween(Integer value1, Integer value2) {
            addCriterion("FUNC_ORDER not between", value1, value2, "funcOrder");
            return (Criteria) this;
        }

        public Criteria andSupFuncIdIsNull() {
            addCriterion("SUP_FUNC_ID is null");
            return (Criteria) this;
        }

        public Criteria andSupFuncIdIsNotNull() {
            addCriterion("SUP_FUNC_ID is not null");
            return (Criteria) this;
        }

        public Criteria andSupFuncIdEqualTo(Integer value) {
            addCriterion("SUP_FUNC_ID =", value, "supFuncId");
            return (Criteria) this;
        }

        public Criteria andSupFuncIdNotEqualTo(Integer value) {
            addCriterion("SUP_FUNC_ID <>", value, "supFuncId");
            return (Criteria) this;
        }

        public Criteria andSupFuncIdGreaterThan(Integer value) {
            addCriterion("SUP_FUNC_ID >", value, "supFuncId");
            return (Criteria) this;
        }

        public Criteria andSupFuncIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("SUP_FUNC_ID >=", value, "supFuncId");
            return (Criteria) this;
        }

        public Criteria andSupFuncIdLessThan(Integer value) {
            addCriterion("SUP_FUNC_ID <", value, "supFuncId");
            return (Criteria) this;
        }

        public Criteria andSupFuncIdLessThanOrEqualTo(Integer value) {
            addCriterion("SUP_FUNC_ID <=", value, "supFuncId");
            return (Criteria) this;
        }

        public Criteria andSupFuncIdIn(List<Integer> values) {
            addCriterion("SUP_FUNC_ID in", values, "supFuncId");
            return (Criteria) this;
        }

        public Criteria andSupFuncIdNotIn(List<Integer> values) {
            addCriterion("SUP_FUNC_ID not in", values, "supFuncId");
            return (Criteria) this;
        }

        public Criteria andSupFuncIdBetween(Integer value1, Integer value2) {
            addCriterion("SUP_FUNC_ID between", value1, value2, "supFuncId");
            return (Criteria) this;
        }

        public Criteria andSupFuncIdNotBetween(Integer value1, Integer value2) {
            addCriterion("SUP_FUNC_ID not between", value1, value2, "supFuncId");
            return (Criteria) this;
        }

        public Criteria andDataStateIsNull() {
            addCriterion("DATA_STATE is null");
            return (Criteria) this;
        }

        public Criteria andDataStateIsNotNull() {
            addCriterion("DATA_STATE is not null");
            return (Criteria) this;
        }

        public Criteria andDataStateEqualTo(Integer value) {
            addCriterion("DATA_STATE =", value, "dataState");
            return (Criteria) this;
        }

        public Criteria andDataStateNotEqualTo(Integer value) {
            addCriterion("DATA_STATE <>", value, "dataState");
            return (Criteria) this;
        }

        public Criteria andDataStateGreaterThan(Integer value) {
            addCriterion("DATA_STATE >", value, "dataState");
            return (Criteria) this;
        }

        public Criteria andDataStateGreaterThanOrEqualTo(Integer value) {
            addCriterion("DATA_STATE >=", value, "dataState");
            return (Criteria) this;
        }

        public Criteria andDataStateLessThan(Integer value) {
            addCriterion("DATA_STATE <", value, "dataState");
            return (Criteria) this;
        }

        public Criteria andDataStateLessThanOrEqualTo(Integer value) {
            addCriterion("DATA_STATE <=", value, "dataState");
            return (Criteria) this;
        }

        public Criteria andDataStateIn(List<Integer> values) {
            addCriterion("DATA_STATE in", values, "dataState");
            return (Criteria) this;
        }

        public Criteria andDataStateNotIn(List<Integer> values) {
            addCriterion("DATA_STATE not in", values, "dataState");
            return (Criteria) this;
        }

        public Criteria andDataStateBetween(Integer value1, Integer value2) {
            addCriterion("DATA_STATE between", value1, value2, "dataState");
            return (Criteria) this;
        }

        public Criteria andDataStateNotBetween(Integer value1, Integer value2) {
            addCriterion("DATA_STATE not between", value1, value2, "dataState");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("CREATE_TIME is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("CREATE_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("CREATE_TIME =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("CREATE_TIME <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("CREATE_TIME >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("CREATE_TIME >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("CREATE_TIME <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("CREATE_TIME <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("CREATE_TIME in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("CREATE_TIME not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("CREATE_TIME between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("CREATE_TIME not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeIsNull() {
            addCriterion("MODIFY_TIME is null");
            return (Criteria) this;
        }

        public Criteria andModifyTimeIsNotNull() {
            addCriterion("MODIFY_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andModifyTimeEqualTo(Date value) {
            addCriterion("MODIFY_TIME =", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeNotEqualTo(Date value) {
            addCriterion("MODIFY_TIME <>", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeGreaterThan(Date value) {
            addCriterion("MODIFY_TIME >", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("MODIFY_TIME >=", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeLessThan(Date value) {
            addCriterion("MODIFY_TIME <", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeLessThanOrEqualTo(Date value) {
            addCriterion("MODIFY_TIME <=", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeIn(List<Date> values) {
            addCriterion("MODIFY_TIME in", values, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeNotIn(List<Date> values) {
            addCriterion("MODIFY_TIME not in", values, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeBetween(Date value1, Date value2) {
            addCriterion("MODIFY_TIME between", value1, value2, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeNotBetween(Date value1, Date value2) {
            addCriterion("MODIFY_TIME not between", value1, value2, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andFuncUrlIsNull() {
            addCriterion("FUNC_URL is null");
            return (Criteria) this;
        }

        public Criteria andFuncUrlIsNotNull() {
            addCriterion("FUNC_URL is not null");
            return (Criteria) this;
        }

        public Criteria andFuncUrlEqualTo(String value) {
            addCriterion("FUNC_URL =", value, "funcUrl");
            return (Criteria) this;
        }

        public Criteria andFuncUrlNotEqualTo(String value) {
            addCriterion("FUNC_URL <>", value, "funcUrl");
            return (Criteria) this;
        }

        public Criteria andFuncUrlGreaterThan(String value) {
            addCriterion("FUNC_URL >", value, "funcUrl");
            return (Criteria) this;
        }

        public Criteria andFuncUrlGreaterThanOrEqualTo(String value) {
            addCriterion("FUNC_URL >=", value, "funcUrl");
            return (Criteria) this;
        }

        public Criteria andFuncUrlLessThan(String value) {
            addCriterion("FUNC_URL <", value, "funcUrl");
            return (Criteria) this;
        }

        public Criteria andFuncUrlLessThanOrEqualTo(String value) {
            addCriterion("FUNC_URL <=", value, "funcUrl");
            return (Criteria) this;
        }

        public Criteria andFuncUrlLike(String value) {
            addCriterion("FUNC_URL like", value, "funcUrl");
            return (Criteria) this;
        }

        public Criteria andFuncUrlNotLike(String value) {
            addCriterion("FUNC_URL not like", value, "funcUrl");
            return (Criteria) this;
        }

        public Criteria andFuncUrlIn(List<String> values) {
            addCriterion("FUNC_URL in", values, "funcUrl");
            return (Criteria) this;
        }

        public Criteria andFuncUrlNotIn(List<String> values) {
            addCriterion("FUNC_URL not in", values, "funcUrl");
            return (Criteria) this;
        }

        public Criteria andFuncUrlBetween(String value1, String value2) {
            addCriterion("FUNC_URL between", value1, value2, "funcUrl");
            return (Criteria) this;
        }

        public Criteria andFuncUrlNotBetween(String value1, String value2) {
            addCriterion("FUNC_URL not between", value1, value2, "funcUrl");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

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