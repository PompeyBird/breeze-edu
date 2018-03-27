package org.bird.breeze.edu.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EduCheckInExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Integer offset;

    public EduCheckInExample() {
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

        public Criteria andLessonIdIsNull() {
            addCriterion("LESSON_ID is null");
            return (Criteria) this;
        }

        public Criteria andLessonIdIsNotNull() {
            addCriterion("LESSON_ID is not null");
            return (Criteria) this;
        }

        public Criteria andLessonIdEqualTo(Integer value) {
            addCriterion("LESSON_ID =", value, "lessonId");
            return (Criteria) this;
        }

        public Criteria andLessonIdNotEqualTo(Integer value) {
            addCriterion("LESSON_ID <>", value, "lessonId");
            return (Criteria) this;
        }

        public Criteria andLessonIdGreaterThan(Integer value) {
            addCriterion("LESSON_ID >", value, "lessonId");
            return (Criteria) this;
        }

        public Criteria andLessonIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("LESSON_ID >=", value, "lessonId");
            return (Criteria) this;
        }

        public Criteria andLessonIdLessThan(Integer value) {
            addCriterion("LESSON_ID <", value, "lessonId");
            return (Criteria) this;
        }

        public Criteria andLessonIdLessThanOrEqualTo(Integer value) {
            addCriterion("LESSON_ID <=", value, "lessonId");
            return (Criteria) this;
        }

        public Criteria andLessonIdIn(List<Integer> values) {
            addCriterion("LESSON_ID in", values, "lessonId");
            return (Criteria) this;
        }

        public Criteria andLessonIdNotIn(List<Integer> values) {
            addCriterion("LESSON_ID not in", values, "lessonId");
            return (Criteria) this;
        }

        public Criteria andLessonIdBetween(Integer value1, Integer value2) {
            addCriterion("LESSON_ID between", value1, value2, "lessonId");
            return (Criteria) this;
        }

        public Criteria andLessonIdNotBetween(Integer value1, Integer value2) {
            addCriterion("LESSON_ID not between", value1, value2, "lessonId");
            return (Criteria) this;
        }

        public Criteria andWechatUserIdIsNull() {
            addCriterion("WECHAT_USER_ID is null");
            return (Criteria) this;
        }

        public Criteria andWechatUserIdIsNotNull() {
            addCriterion("WECHAT_USER_ID is not null");
            return (Criteria) this;
        }

        public Criteria andWechatUserIdEqualTo(Integer value) {
            addCriterion("WECHAT_USER_ID =", value, "wechatUserId");
            return (Criteria) this;
        }

        public Criteria andWechatUserIdNotEqualTo(Integer value) {
            addCriterion("WECHAT_USER_ID <>", value, "wechatUserId");
            return (Criteria) this;
        }

        public Criteria andWechatUserIdGreaterThan(Integer value) {
            addCriterion("WECHAT_USER_ID >", value, "wechatUserId");
            return (Criteria) this;
        }

        public Criteria andWechatUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("WECHAT_USER_ID >=", value, "wechatUserId");
            return (Criteria) this;
        }

        public Criteria andWechatUserIdLessThan(Integer value) {
            addCriterion("WECHAT_USER_ID <", value, "wechatUserId");
            return (Criteria) this;
        }

        public Criteria andWechatUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("WECHAT_USER_ID <=", value, "wechatUserId");
            return (Criteria) this;
        }

        public Criteria andWechatUserIdIn(List<Integer> values) {
            addCriterion("WECHAT_USER_ID in", values, "wechatUserId");
            return (Criteria) this;
        }

        public Criteria andWechatUserIdNotIn(List<Integer> values) {
            addCriterion("WECHAT_USER_ID not in", values, "wechatUserId");
            return (Criteria) this;
        }

        public Criteria andWechatUserIdBetween(Integer value1, Integer value2) {
            addCriterion("WECHAT_USER_ID between", value1, value2, "wechatUserId");
            return (Criteria) this;
        }

        public Criteria andWechatUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("WECHAT_USER_ID not between", value1, value2, "wechatUserId");
            return (Criteria) this;
        }

        public Criteria andCheckInTimeIsNull() {
            addCriterion("CHECK_IN_TIME is null");
            return (Criteria) this;
        }

        public Criteria andCheckInTimeIsNotNull() {
            addCriterion("CHECK_IN_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andCheckInTimeEqualTo(Date value) {
            addCriterion("CHECK_IN_TIME =", value, "checkInTime");
            return (Criteria) this;
        }

        public Criteria andCheckInTimeNotEqualTo(Date value) {
            addCriterion("CHECK_IN_TIME <>", value, "checkInTime");
            return (Criteria) this;
        }

        public Criteria andCheckInTimeGreaterThan(Date value) {
            addCriterion("CHECK_IN_TIME >", value, "checkInTime");
            return (Criteria) this;
        }

        public Criteria andCheckInTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("CHECK_IN_TIME >=", value, "checkInTime");
            return (Criteria) this;
        }

        public Criteria andCheckInTimeLessThan(Date value) {
            addCriterion("CHECK_IN_TIME <", value, "checkInTime");
            return (Criteria) this;
        }

        public Criteria andCheckInTimeLessThanOrEqualTo(Date value) {
            addCriterion("CHECK_IN_TIME <=", value, "checkInTime");
            return (Criteria) this;
        }

        public Criteria andCheckInTimeIn(List<Date> values) {
            addCriterion("CHECK_IN_TIME in", values, "checkInTime");
            return (Criteria) this;
        }

        public Criteria andCheckInTimeNotIn(List<Date> values) {
            addCriterion("CHECK_IN_TIME not in", values, "checkInTime");
            return (Criteria) this;
        }

        public Criteria andCheckInTimeBetween(Date value1, Date value2) {
            addCriterion("CHECK_IN_TIME between", value1, value2, "checkInTime");
            return (Criteria) this;
        }

        public Criteria andCheckInTimeNotBetween(Date value1, Date value2) {
            addCriterion("CHECK_IN_TIME not between", value1, value2, "checkInTime");
            return (Criteria) this;
        }

        public Criteria andCheckInAddrIsNull() {
            addCriterion("CHECK_IN_ADDR is null");
            return (Criteria) this;
        }

        public Criteria andCheckInAddrIsNotNull() {
            addCriterion("CHECK_IN_ADDR is not null");
            return (Criteria) this;
        }

        public Criteria andCheckInAddrEqualTo(String value) {
            addCriterion("CHECK_IN_ADDR =", value, "checkInAddr");
            return (Criteria) this;
        }

        public Criteria andCheckInAddrNotEqualTo(String value) {
            addCriterion("CHECK_IN_ADDR <>", value, "checkInAddr");
            return (Criteria) this;
        }

        public Criteria andCheckInAddrGreaterThan(String value) {
            addCriterion("CHECK_IN_ADDR >", value, "checkInAddr");
            return (Criteria) this;
        }

        public Criteria andCheckInAddrGreaterThanOrEqualTo(String value) {
            addCriterion("CHECK_IN_ADDR >=", value, "checkInAddr");
            return (Criteria) this;
        }

        public Criteria andCheckInAddrLessThan(String value) {
            addCriterion("CHECK_IN_ADDR <", value, "checkInAddr");
            return (Criteria) this;
        }

        public Criteria andCheckInAddrLessThanOrEqualTo(String value) {
            addCriterion("CHECK_IN_ADDR <=", value, "checkInAddr");
            return (Criteria) this;
        }

        public Criteria andCheckInAddrLike(String value) {
            addCriterion("CHECK_IN_ADDR like", value, "checkInAddr");
            return (Criteria) this;
        }

        public Criteria andCheckInAddrNotLike(String value) {
            addCriterion("CHECK_IN_ADDR not like", value, "checkInAddr");
            return (Criteria) this;
        }

        public Criteria andCheckInAddrIn(List<String> values) {
            addCriterion("CHECK_IN_ADDR in", values, "checkInAddr");
            return (Criteria) this;
        }

        public Criteria andCheckInAddrNotIn(List<String> values) {
            addCriterion("CHECK_IN_ADDR not in", values, "checkInAddr");
            return (Criteria) this;
        }

        public Criteria andCheckInAddrBetween(String value1, String value2) {
            addCriterion("CHECK_IN_ADDR between", value1, value2, "checkInAddr");
            return (Criteria) this;
        }

        public Criteria andCheckInAddrNotBetween(String value1, String value2) {
            addCriterion("CHECK_IN_ADDR not between", value1, value2, "checkInAddr");
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