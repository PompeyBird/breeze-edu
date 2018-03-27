package org.bird.breeze.edu.model;

import java.util.Date;

public class EduLesson {
    private Integer id;

    private Integer userId;

    private String lessonName;

    private Date lessonDate;

    private Date startTime;

    private Date endTime;

    private Integer needCheck;

    private Integer checkPeriod;

    private Date checkStartTime;

    private Date checkEndTime;

    private String checkAddr;

    private String concreteAddr;

    private String coordinateX;

    private String coordinateY;

    private Integer dataState;

    private Date createTime;

    private Date modifyTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getLessonName() {
        return lessonName;
    }

    public void setLessonName(String lessonName) {
        this.lessonName = lessonName == null ? null : lessonName.trim();
    }

    public Date getLessonDate() {
        return lessonDate;
    }

    public void setLessonDate(Date lessonDate) {
        this.lessonDate = lessonDate;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Integer getNeedCheck() {
        return needCheck;
    }

    public void setNeedCheck(Integer needCheck) {
        this.needCheck = needCheck;
    }

    public Integer getCheckPeriod() {
        return checkPeriod;
    }

    public void setCheckPeriod(Integer checkPeriod) {
        this.checkPeriod = checkPeriod;
    }

    public Date getCheckStartTime() {
        return checkStartTime;
    }

    public void setCheckStartTime(Date checkStartTime) {
        this.checkStartTime = checkStartTime;
    }

    public Date getCheckEndTime() {
        return checkEndTime;
    }

    public void setCheckEndTime(Date checkEndTime) {
        this.checkEndTime = checkEndTime;
    }

    public String getCheckAddr() {
        return checkAddr;
    }

    public void setCheckAddr(String checkAddr) {
        this.checkAddr = checkAddr == null ? null : checkAddr.trim();
    }

    public String getConcreteAddr() {
        return concreteAddr;
    }

    public void setConcreteAddr(String concreteAddr) {
        this.concreteAddr = concreteAddr == null ? null : concreteAddr.trim();
    }

    public String getCoordinateX() {
        return coordinateX;
    }

    public void setCoordinateX(String coordinateX) {
        this.coordinateX = coordinateX == null ? null : coordinateX.trim();
    }

    public String getCoordinateY() {
        return coordinateY;
    }

    public void setCoordinateY(String coordinateY) {
        this.coordinateY = coordinateY == null ? null : coordinateY.trim();
    }

    public Integer getDataState() {
        return dataState;
    }

    public void setDataState(Integer dataState) {
        this.dataState = dataState;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }
}