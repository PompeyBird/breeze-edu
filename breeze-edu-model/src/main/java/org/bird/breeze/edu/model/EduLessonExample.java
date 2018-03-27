package org.bird.breeze.edu.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EduLessonExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Integer offset;

    public EduLessonExample() {
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

        public Criteria andUserIdIsNull() {
            addCriterion("USER_ID is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("USER_ID is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(Integer value) {
            addCriterion("USER_ID =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(Integer value) {
            addCriterion("USER_ID <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(Integer value) {
            addCriterion("USER_ID >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("USER_ID >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(Integer value) {
            addCriterion("USER_ID <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("USER_ID <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<Integer> values) {
            addCriterion("USER_ID in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<Integer> values) {
            addCriterion("USER_ID not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(Integer value1, Integer value2) {
            addCriterion("USER_ID between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("USER_ID not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andLessonNameIsNull() {
            addCriterion("LESSON_NAME is null");
            return (Criteria) this;
        }

        public Criteria andLessonNameIsNotNull() {
            addCriterion("LESSON_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andLessonNameEqualTo(String value) {
            addCriterion("LESSON_NAME =", value, "lessonName");
            return (Criteria) this;
        }

        public Criteria andLessonNameNotEqualTo(String value) {
            addCriterion("LESSON_NAME <>", value, "lessonName");
            return (Criteria) this;
        }

        public Criteria andLessonNameGreaterThan(String value) {
            addCriterion("LESSON_NAME >", value, "lessonName");
            return (Criteria) this;
        }

        public Criteria andLessonNameGreaterThanOrEqualTo(String value) {
            addCriterion("LESSON_NAME >=", value, "lessonName");
            return (Criteria) this;
        }

        public Criteria andLessonNameLessThan(String value) {
            addCriterion("LESSON_NAME <", value, "lessonName");
            return (Criteria) this;
        }

        public Criteria andLessonNameLessThanOrEqualTo(String value) {
            addCriterion("LESSON_NAME <=", value, "lessonName");
            return (Criteria) this;
        }

        public Criteria andLessonNameLike(String value) {
            addCriterion("LESSON_NAME like", value, "lessonName");
            return (Criteria) this;
        }

        public Criteria andLessonNameNotLike(String value) {
            addCriterion("LESSON_NAME not like", value, "lessonName");
            return (Criteria) this;
        }

        public Criteria andLessonNameIn(List<String> values) {
            addCriterion("LESSON_NAME in", values, "lessonName");
            return (Criteria) this;
        }

        public Criteria andLessonNameNotIn(List<String> values) {
            addCriterion("LESSON_NAME not in", values, "lessonName");
            return (Criteria) this;
        }

        public Criteria andLessonNameBetween(String value1, String value2) {
            addCriterion("LESSON_NAME between", value1, value2, "lessonName");
            return (Criteria) this;
        }

        public Criteria andLessonNameNotBetween(String value1, String value2) {
            addCriterion("LESSON_NAME not between", value1, value2, "lessonName");
            return (Criteria) this;
        }

        public Criteria andLessonDateIsNull() {
            addCriterion("LESSON_DATE is null");
            return (Criteria) this;
        }

        public Criteria andLessonDateIsNotNull() {
            addCriterion("LESSON_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andLessonDateEqualTo(Date value) {
            addCriterion("LESSON_DATE =", value, "lessonDate");
            return (Criteria) this;
        }

        public Criteria andLessonDateNotEqualTo(Date value) {
            addCriterion("LESSON_DATE <>", value, "lessonDate");
            return (Criteria) this;
        }

        public Criteria andLessonDateGreaterThan(Date value) {
            addCriterion("LESSON_DATE >", value, "lessonDate");
            return (Criteria) this;
        }

        public Criteria andLessonDateGreaterThanOrEqualTo(Date value) {
            addCriterion("LESSON_DATE >=", value, "lessonDate");
            return (Criteria) this;
        }

        public Criteria andLessonDateLessThan(Date value) {
            addCriterion("LESSON_DATE <", value, "lessonDate");
            return (Criteria) this;
        }

        public Criteria andLessonDateLessThanOrEqualTo(Date value) {
            addCriterion("LESSON_DATE <=", value, "lessonDate");
            return (Criteria) this;
        }

        public Criteria andLessonDateIn(List<Date> values) {
            addCriterion("LESSON_DATE in", values, "lessonDate");
            return (Criteria) this;
        }

        public Criteria andLessonDateNotIn(List<Date> values) {
            addCriterion("LESSON_DATE not in", values, "lessonDate");
            return (Criteria) this;
        }

        public Criteria andLessonDateBetween(Date value1, Date value2) {
            addCriterion("LESSON_DATE between", value1, value2, "lessonDate");
            return (Criteria) this;
        }

        public Criteria andLessonDateNotBetween(Date value1, Date value2) {
            addCriterion("LESSON_DATE not between", value1, value2, "lessonDate");
            return (Criteria) this;
        }

        public Criteria andStartTimeIsNull() {
            addCriterion("START_TIME is null");
            return (Criteria) this;
        }

        public Criteria andStartTimeIsNotNull() {
            addCriterion("START_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andStartTimeEqualTo(Date value) {
            addCriterion("START_TIME =", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotEqualTo(Date value) {
            addCriterion("START_TIME <>", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeGreaterThan(Date value) {
            addCriterion("START_TIME >", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("START_TIME >=", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeLessThan(Date value) {
            addCriterion("START_TIME <", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeLessThanOrEqualTo(Date value) {
            addCriterion("START_TIME <=", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeIn(List<Date> values) {
            addCriterion("START_TIME in", values, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotIn(List<Date> values) {
            addCriterion("START_TIME not in", values, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeBetween(Date value1, Date value2) {
            addCriterion("START_TIME between", value1, value2, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotBetween(Date value1, Date value2) {
            addCriterion("START_TIME not between", value1, value2, "startTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeIsNull() {
            addCriterion("END_TIME is null");
            return (Criteria) this;
        }

        public Criteria andEndTimeIsNotNull() {
            addCriterion("END_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andEndTimeEqualTo(Date value) {
            addCriterion("END_TIME =", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotEqualTo(Date value) {
            addCriterion("END_TIME <>", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeGreaterThan(Date value) {
            addCriterion("END_TIME >", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("END_TIME >=", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeLessThan(Date value) {
            addCriterion("END_TIME <", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeLessThanOrEqualTo(Date value) {
            addCriterion("END_TIME <=", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeIn(List<Date> values) {
            addCriterion("END_TIME in", values, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotIn(List<Date> values) {
            addCriterion("END_TIME not in", values, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeBetween(Date value1, Date value2) {
            addCriterion("END_TIME between", value1, value2, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotBetween(Date value1, Date value2) {
            addCriterion("END_TIME not between", value1, value2, "endTime");
            return (Criteria) this;
        }

        public Criteria andNeedCheckIsNull() {
            addCriterion("NEED_CHECK is null");
            return (Criteria) this;
        }

        public Criteria andNeedCheckIsNotNull() {
            addCriterion("NEED_CHECK is not null");
            return (Criteria) this;
        }

        public Criteria andNeedCheckEqualTo(Integer value) {
            addCriterion("NEED_CHECK =", value, "needCheck");
            return (Criteria) this;
        }

        public Criteria andNeedCheckNotEqualTo(Integer value) {
            addCriterion("NEED_CHECK <>", value, "needCheck");
            return (Criteria) this;
        }

        public Criteria andNeedCheckGreaterThan(Integer value) {
            addCriterion("NEED_CHECK >", value, "needCheck");
            return (Criteria) this;
        }

        public Criteria andNeedCheckGreaterThanOrEqualTo(Integer value) {
            addCriterion("NEED_CHECK >=", value, "needCheck");
            return (Criteria) this;
        }

        public Criteria andNeedCheckLessThan(Integer value) {
            addCriterion("NEED_CHECK <", value, "needCheck");
            return (Criteria) this;
        }

        public Criteria andNeedCheckLessThanOrEqualTo(Integer value) {
            addCriterion("NEED_CHECK <=", value, "needCheck");
            return (Criteria) this;
        }

        public Criteria andNeedCheckIn(List<Integer> values) {
            addCriterion("NEED_CHECK in", values, "needCheck");
            return (Criteria) this;
        }

        public Criteria andNeedCheckNotIn(List<Integer> values) {
            addCriterion("NEED_CHECK not in", values, "needCheck");
            return (Criteria) this;
        }

        public Criteria andNeedCheckBetween(Integer value1, Integer value2) {
            addCriterion("NEED_CHECK between", value1, value2, "needCheck");
            return (Criteria) this;
        }

        public Criteria andNeedCheckNotBetween(Integer value1, Integer value2) {
            addCriterion("NEED_CHECK not between", value1, value2, "needCheck");
            return (Criteria) this;
        }

        public Criteria andCheckPeriodIsNull() {
            addCriterion("CHECK_PERIOD is null");
            return (Criteria) this;
        }

        public Criteria andCheckPeriodIsNotNull() {
            addCriterion("CHECK_PERIOD is not null");
            return (Criteria) this;
        }

        public Criteria andCheckPeriodEqualTo(Integer value) {
            addCriterion("CHECK_PERIOD =", value, "checkPeriod");
            return (Criteria) this;
        }

        public Criteria andCheckPeriodNotEqualTo(Integer value) {
            addCriterion("CHECK_PERIOD <>", value, "checkPeriod");
            return (Criteria) this;
        }

        public Criteria andCheckPeriodGreaterThan(Integer value) {
            addCriterion("CHECK_PERIOD >", value, "checkPeriod");
            return (Criteria) this;
        }

        public Criteria andCheckPeriodGreaterThanOrEqualTo(Integer value) {
            addCriterion("CHECK_PERIOD >=", value, "checkPeriod");
            return (Criteria) this;
        }

        public Criteria andCheckPeriodLessThan(Integer value) {
            addCriterion("CHECK_PERIOD <", value, "checkPeriod");
            return (Criteria) this;
        }

        public Criteria andCheckPeriodLessThanOrEqualTo(Integer value) {
            addCriterion("CHECK_PERIOD <=", value, "checkPeriod");
            return (Criteria) this;
        }

        public Criteria andCheckPeriodIn(List<Integer> values) {
            addCriterion("CHECK_PERIOD in", values, "checkPeriod");
            return (Criteria) this;
        }

        public Criteria andCheckPeriodNotIn(List<Integer> values) {
            addCriterion("CHECK_PERIOD not in", values, "checkPeriod");
            return (Criteria) this;
        }

        public Criteria andCheckPeriodBetween(Integer value1, Integer value2) {
            addCriterion("CHECK_PERIOD between", value1, value2, "checkPeriod");
            return (Criteria) this;
        }

        public Criteria andCheckPeriodNotBetween(Integer value1, Integer value2) {
            addCriterion("CHECK_PERIOD not between", value1, value2, "checkPeriod");
            return (Criteria) this;
        }

        public Criteria andCheckStartTimeIsNull() {
            addCriterion("CHECK_START_TIME is null");
            return (Criteria) this;
        }

        public Criteria andCheckStartTimeIsNotNull() {
            addCriterion("CHECK_START_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andCheckStartTimeEqualTo(Date value) {
            addCriterion("CHECK_START_TIME =", value, "checkStartTime");
            return (Criteria) this;
        }

        public Criteria andCheckStartTimeNotEqualTo(Date value) {
            addCriterion("CHECK_START_TIME <>", value, "checkStartTime");
            return (Criteria) this;
        }

        public Criteria andCheckStartTimeGreaterThan(Date value) {
            addCriterion("CHECK_START_TIME >", value, "checkStartTime");
            return (Criteria) this;
        }

        public Criteria andCheckStartTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("CHECK_START_TIME >=", value, "checkStartTime");
            return (Criteria) this;
        }

        public Criteria andCheckStartTimeLessThan(Date value) {
            addCriterion("CHECK_START_TIME <", value, "checkStartTime");
            return (Criteria) this;
        }

        public Criteria andCheckStartTimeLessThanOrEqualTo(Date value) {
            addCriterion("CHECK_START_TIME <=", value, "checkStartTime");
            return (Criteria) this;
        }

        public Criteria andCheckStartTimeIn(List<Date> values) {
            addCriterion("CHECK_START_TIME in", values, "checkStartTime");
            return (Criteria) this;
        }

        public Criteria andCheckStartTimeNotIn(List<Date> values) {
            addCriterion("CHECK_START_TIME not in", values, "checkStartTime");
            return (Criteria) this;
        }

        public Criteria andCheckStartTimeBetween(Date value1, Date value2) {
            addCriterion("CHECK_START_TIME between", value1, value2, "checkStartTime");
            return (Criteria) this;
        }

        public Criteria andCheckStartTimeNotBetween(Date value1, Date value2) {
            addCriterion("CHECK_START_TIME not between", value1, value2, "checkStartTime");
            return (Criteria) this;
        }

        public Criteria andCheckEndTimeIsNull() {
            addCriterion("CHECK_END_TIME is null");
            return (Criteria) this;
        }

        public Criteria andCheckEndTimeIsNotNull() {
            addCriterion("CHECK_END_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andCheckEndTimeEqualTo(Date value) {
            addCriterion("CHECK_END_TIME =", value, "checkEndTime");
            return (Criteria) this;
        }

        public Criteria andCheckEndTimeNotEqualTo(Date value) {
            addCriterion("CHECK_END_TIME <>", value, "checkEndTime");
            return (Criteria) this;
        }

        public Criteria andCheckEndTimeGreaterThan(Date value) {
            addCriterion("CHECK_END_TIME >", value, "checkEndTime");
            return (Criteria) this;
        }

        public Criteria andCheckEndTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("CHECK_END_TIME >=", value, "checkEndTime");
            return (Criteria) this;
        }

        public Criteria andCheckEndTimeLessThan(Date value) {
            addCriterion("CHECK_END_TIME <", value, "checkEndTime");
            return (Criteria) this;
        }

        public Criteria andCheckEndTimeLessThanOrEqualTo(Date value) {
            addCriterion("CHECK_END_TIME <=", value, "checkEndTime");
            return (Criteria) this;
        }

        public Criteria andCheckEndTimeIn(List<Date> values) {
            addCriterion("CHECK_END_TIME in", values, "checkEndTime");
            return (Criteria) this;
        }

        public Criteria andCheckEndTimeNotIn(List<Date> values) {
            addCriterion("CHECK_END_TIME not in", values, "checkEndTime");
            return (Criteria) this;
        }

        public Criteria andCheckEndTimeBetween(Date value1, Date value2) {
            addCriterion("CHECK_END_TIME between", value1, value2, "checkEndTime");
            return (Criteria) this;
        }

        public Criteria andCheckEndTimeNotBetween(Date value1, Date value2) {
            addCriterion("CHECK_END_TIME not between", value1, value2, "checkEndTime");
            return (Criteria) this;
        }

        public Criteria andCheckAddrIsNull() {
            addCriterion("CHECK_ADDR is null");
            return (Criteria) this;
        }

        public Criteria andCheckAddrIsNotNull() {
            addCriterion("CHECK_ADDR is not null");
            return (Criteria) this;
        }

        public Criteria andCheckAddrEqualTo(String value) {
            addCriterion("CHECK_ADDR =", value, "checkAddr");
            return (Criteria) this;
        }

        public Criteria andCheckAddrNotEqualTo(String value) {
            addCriterion("CHECK_ADDR <>", value, "checkAddr");
            return (Criteria) this;
        }

        public Criteria andCheckAddrGreaterThan(String value) {
            addCriterion("CHECK_ADDR >", value, "checkAddr");
            return (Criteria) this;
        }

        public Criteria andCheckAddrGreaterThanOrEqualTo(String value) {
            addCriterion("CHECK_ADDR >=", value, "checkAddr");
            return (Criteria) this;
        }

        public Criteria andCheckAddrLessThan(String value) {
            addCriterion("CHECK_ADDR <", value, "checkAddr");
            return (Criteria) this;
        }

        public Criteria andCheckAddrLessThanOrEqualTo(String value) {
            addCriterion("CHECK_ADDR <=", value, "checkAddr");
            return (Criteria) this;
        }

        public Criteria andCheckAddrLike(String value) {
            addCriterion("CHECK_ADDR like", value, "checkAddr");
            return (Criteria) this;
        }

        public Criteria andCheckAddrNotLike(String value) {
            addCriterion("CHECK_ADDR not like", value, "checkAddr");
            return (Criteria) this;
        }

        public Criteria andCheckAddrIn(List<String> values) {
            addCriterion("CHECK_ADDR in", values, "checkAddr");
            return (Criteria) this;
        }

        public Criteria andCheckAddrNotIn(List<String> values) {
            addCriterion("CHECK_ADDR not in", values, "checkAddr");
            return (Criteria) this;
        }

        public Criteria andCheckAddrBetween(String value1, String value2) {
            addCriterion("CHECK_ADDR between", value1, value2, "checkAddr");
            return (Criteria) this;
        }

        public Criteria andCheckAddrNotBetween(String value1, String value2) {
            addCriterion("CHECK_ADDR not between", value1, value2, "checkAddr");
            return (Criteria) this;
        }

        public Criteria andConcreteAddrIsNull() {
            addCriterion("CONCRETE_ADDR is null");
            return (Criteria) this;
        }

        public Criteria andConcreteAddrIsNotNull() {
            addCriterion("CONCRETE_ADDR is not null");
            return (Criteria) this;
        }

        public Criteria andConcreteAddrEqualTo(String value) {
            addCriterion("CONCRETE_ADDR =", value, "concreteAddr");
            return (Criteria) this;
        }

        public Criteria andConcreteAddrNotEqualTo(String value) {
            addCriterion("CONCRETE_ADDR <>", value, "concreteAddr");
            return (Criteria) this;
        }

        public Criteria andConcreteAddrGreaterThan(String value) {
            addCriterion("CONCRETE_ADDR >", value, "concreteAddr");
            return (Criteria) this;
        }

        public Criteria andConcreteAddrGreaterThanOrEqualTo(String value) {
            addCriterion("CONCRETE_ADDR >=", value, "concreteAddr");
            return (Criteria) this;
        }

        public Criteria andConcreteAddrLessThan(String value) {
            addCriterion("CONCRETE_ADDR <", value, "concreteAddr");
            return (Criteria) this;
        }

        public Criteria andConcreteAddrLessThanOrEqualTo(String value) {
            addCriterion("CONCRETE_ADDR <=", value, "concreteAddr");
            return (Criteria) this;
        }

        public Criteria andConcreteAddrLike(String value) {
            addCriterion("CONCRETE_ADDR like", value, "concreteAddr");
            return (Criteria) this;
        }

        public Criteria andConcreteAddrNotLike(String value) {
            addCriterion("CONCRETE_ADDR not like", value, "concreteAddr");
            return (Criteria) this;
        }

        public Criteria andConcreteAddrIn(List<String> values) {
            addCriterion("CONCRETE_ADDR in", values, "concreteAddr");
            return (Criteria) this;
        }

        public Criteria andConcreteAddrNotIn(List<String> values) {
            addCriterion("CONCRETE_ADDR not in", values, "concreteAddr");
            return (Criteria) this;
        }

        public Criteria andConcreteAddrBetween(String value1, String value2) {
            addCriterion("CONCRETE_ADDR between", value1, value2, "concreteAddr");
            return (Criteria) this;
        }

        public Criteria andConcreteAddrNotBetween(String value1, String value2) {
            addCriterion("CONCRETE_ADDR not between", value1, value2, "concreteAddr");
            return (Criteria) this;
        }

        public Criteria andCoordinateXIsNull() {
            addCriterion("COORDINATE_X is null");
            return (Criteria) this;
        }

        public Criteria andCoordinateXIsNotNull() {
            addCriterion("COORDINATE_X is not null");
            return (Criteria) this;
        }

        public Criteria andCoordinateXEqualTo(String value) {
            addCriterion("COORDINATE_X =", value, "coordinateX");
            return (Criteria) this;
        }

        public Criteria andCoordinateXNotEqualTo(String value) {
            addCriterion("COORDINATE_X <>", value, "coordinateX");
            return (Criteria) this;
        }

        public Criteria andCoordinateXGreaterThan(String value) {
            addCriterion("COORDINATE_X >", value, "coordinateX");
            return (Criteria) this;
        }

        public Criteria andCoordinateXGreaterThanOrEqualTo(String value) {
            addCriterion("COORDINATE_X >=", value, "coordinateX");
            return (Criteria) this;
        }

        public Criteria andCoordinateXLessThan(String value) {
            addCriterion("COORDINATE_X <", value, "coordinateX");
            return (Criteria) this;
        }

        public Criteria andCoordinateXLessThanOrEqualTo(String value) {
            addCriterion("COORDINATE_X <=", value, "coordinateX");
            return (Criteria) this;
        }

        public Criteria andCoordinateXLike(String value) {
            addCriterion("COORDINATE_X like", value, "coordinateX");
            return (Criteria) this;
        }

        public Criteria andCoordinateXNotLike(String value) {
            addCriterion("COORDINATE_X not like", value, "coordinateX");
            return (Criteria) this;
        }

        public Criteria andCoordinateXIn(List<String> values) {
            addCriterion("COORDINATE_X in", values, "coordinateX");
            return (Criteria) this;
        }

        public Criteria andCoordinateXNotIn(List<String> values) {
            addCriterion("COORDINATE_X not in", values, "coordinateX");
            return (Criteria) this;
        }

        public Criteria andCoordinateXBetween(String value1, String value2) {
            addCriterion("COORDINATE_X between", value1, value2, "coordinateX");
            return (Criteria) this;
        }

        public Criteria andCoordinateXNotBetween(String value1, String value2) {
            addCriterion("COORDINATE_X not between", value1, value2, "coordinateX");
            return (Criteria) this;
        }

        public Criteria andCoordinateYIsNull() {
            addCriterion("COORDINATE_Y is null");
            return (Criteria) this;
        }

        public Criteria andCoordinateYIsNotNull() {
            addCriterion("COORDINATE_Y is not null");
            return (Criteria) this;
        }

        public Criteria andCoordinateYEqualTo(String value) {
            addCriterion("COORDINATE_Y =", value, "coordinateY");
            return (Criteria) this;
        }

        public Criteria andCoordinateYNotEqualTo(String value) {
            addCriterion("COORDINATE_Y <>", value, "coordinateY");
            return (Criteria) this;
        }

        public Criteria andCoordinateYGreaterThan(String value) {
            addCriterion("COORDINATE_Y >", value, "coordinateY");
            return (Criteria) this;
        }

        public Criteria andCoordinateYGreaterThanOrEqualTo(String value) {
            addCriterion("COORDINATE_Y >=", value, "coordinateY");
            return (Criteria) this;
        }

        public Criteria andCoordinateYLessThan(String value) {
            addCriterion("COORDINATE_Y <", value, "coordinateY");
            return (Criteria) this;
        }

        public Criteria andCoordinateYLessThanOrEqualTo(String value) {
            addCriterion("COORDINATE_Y <=", value, "coordinateY");
            return (Criteria) this;
        }

        public Criteria andCoordinateYLike(String value) {
            addCriterion("COORDINATE_Y like", value, "coordinateY");
            return (Criteria) this;
        }

        public Criteria andCoordinateYNotLike(String value) {
            addCriterion("COORDINATE_Y not like", value, "coordinateY");
            return (Criteria) this;
        }

        public Criteria andCoordinateYIn(List<String> values) {
            addCriterion("COORDINATE_Y in", values, "coordinateY");
            return (Criteria) this;
        }

        public Criteria andCoordinateYNotIn(List<String> values) {
            addCriterion("COORDINATE_Y not in", values, "coordinateY");
            return (Criteria) this;
        }

        public Criteria andCoordinateYBetween(String value1, String value2) {
            addCriterion("COORDINATE_Y between", value1, value2, "coordinateY");
            return (Criteria) this;
        }

        public Criteria andCoordinateYNotBetween(String value1, String value2) {
            addCriterion("COORDINATE_Y not between", value1, value2, "coordinateY");
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