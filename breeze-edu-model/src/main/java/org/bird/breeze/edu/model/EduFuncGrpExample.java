package org.bird.breeze.edu.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EduFuncGrpExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Integer offset;

    public EduFuncGrpExample() {
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

        public Criteria andGrpCodeIsNull() {
            addCriterion("GRP_CODE is null");
            return (Criteria) this;
        }

        public Criteria andGrpCodeIsNotNull() {
            addCriterion("GRP_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andGrpCodeEqualTo(String value) {
            addCriterion("GRP_CODE =", value, "grpCode");
            return (Criteria) this;
        }

        public Criteria andGrpCodeNotEqualTo(String value) {
            addCriterion("GRP_CODE <>", value, "grpCode");
            return (Criteria) this;
        }

        public Criteria andGrpCodeGreaterThan(String value) {
            addCriterion("GRP_CODE >", value, "grpCode");
            return (Criteria) this;
        }

        public Criteria andGrpCodeGreaterThanOrEqualTo(String value) {
            addCriterion("GRP_CODE >=", value, "grpCode");
            return (Criteria) this;
        }

        public Criteria andGrpCodeLessThan(String value) {
            addCriterion("GRP_CODE <", value, "grpCode");
            return (Criteria) this;
        }

        public Criteria andGrpCodeLessThanOrEqualTo(String value) {
            addCriterion("GRP_CODE <=", value, "grpCode");
            return (Criteria) this;
        }

        public Criteria andGrpCodeLike(String value) {
            addCriterion("GRP_CODE like", value, "grpCode");
            return (Criteria) this;
        }

        public Criteria andGrpCodeNotLike(String value) {
            addCriterion("GRP_CODE not like", value, "grpCode");
            return (Criteria) this;
        }

        public Criteria andGrpCodeIn(List<String> values) {
            addCriterion("GRP_CODE in", values, "grpCode");
            return (Criteria) this;
        }

        public Criteria andGrpCodeNotIn(List<String> values) {
            addCriterion("GRP_CODE not in", values, "grpCode");
            return (Criteria) this;
        }

        public Criteria andGrpCodeBetween(String value1, String value2) {
            addCriterion("GRP_CODE between", value1, value2, "grpCode");
            return (Criteria) this;
        }

        public Criteria andGrpCodeNotBetween(String value1, String value2) {
            addCriterion("GRP_CODE not between", value1, value2, "grpCode");
            return (Criteria) this;
        }

        public Criteria andGrpNameIsNull() {
            addCriterion("GRP_NAME is null");
            return (Criteria) this;
        }

        public Criteria andGrpNameIsNotNull() {
            addCriterion("GRP_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andGrpNameEqualTo(String value) {
            addCriterion("GRP_NAME =", value, "grpName");
            return (Criteria) this;
        }

        public Criteria andGrpNameNotEqualTo(String value) {
            addCriterion("GRP_NAME <>", value, "grpName");
            return (Criteria) this;
        }

        public Criteria andGrpNameGreaterThan(String value) {
            addCriterion("GRP_NAME >", value, "grpName");
            return (Criteria) this;
        }

        public Criteria andGrpNameGreaterThanOrEqualTo(String value) {
            addCriterion("GRP_NAME >=", value, "grpName");
            return (Criteria) this;
        }

        public Criteria andGrpNameLessThan(String value) {
            addCriterion("GRP_NAME <", value, "grpName");
            return (Criteria) this;
        }

        public Criteria andGrpNameLessThanOrEqualTo(String value) {
            addCriterion("GRP_NAME <=", value, "grpName");
            return (Criteria) this;
        }

        public Criteria andGrpNameLike(String value) {
            addCriterion("GRP_NAME like", value, "grpName");
            return (Criteria) this;
        }

        public Criteria andGrpNameNotLike(String value) {
            addCriterion("GRP_NAME not like", value, "grpName");
            return (Criteria) this;
        }

        public Criteria andGrpNameIn(List<String> values) {
            addCriterion("GRP_NAME in", values, "grpName");
            return (Criteria) this;
        }

        public Criteria andGrpNameNotIn(List<String> values) {
            addCriterion("GRP_NAME not in", values, "grpName");
            return (Criteria) this;
        }

        public Criteria andGrpNameBetween(String value1, String value2) {
            addCriterion("GRP_NAME between", value1, value2, "grpName");
            return (Criteria) this;
        }

        public Criteria andGrpNameNotBetween(String value1, String value2) {
            addCriterion("GRP_NAME not between", value1, value2, "grpName");
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