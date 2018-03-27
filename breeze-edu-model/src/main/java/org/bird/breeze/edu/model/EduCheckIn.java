package org.bird.breeze.edu.model;

import java.util.Date;

public class EduCheckIn {
    private Integer id;

    private Integer lessonId;

    private Integer wechatUserId;

    private Date checkInTime;

    private String checkInAddr;

    private Integer dataState;

    private Date createTime;

    private Date modifyTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getLessonId() {
        return lessonId;
    }

    public void setLessonId(Integer lessonId) {
        this.lessonId = lessonId;
    }

    public Integer getWechatUserId() {
        return wechatUserId;
    }

    public void setWechatUserId(Integer wechatUserId) {
        this.wechatUserId = wechatUserId;
    }

    public Date getCheckInTime() {
        return checkInTime;
    }

    public void setCheckInTime(Date checkInTime) {
        this.checkInTime = checkInTime;
    }

    public String getCheckInAddr() {
        return checkInAddr;
    }

    public void setCheckInAddr(String checkInAddr) {
        this.checkInAddr = checkInAddr == null ? null : checkInAddr.trim();
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