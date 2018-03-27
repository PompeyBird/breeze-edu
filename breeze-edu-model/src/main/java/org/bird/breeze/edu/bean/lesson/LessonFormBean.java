package org.bird.breeze.edu.bean.lesson;

public class LessonFormBean {
    private int id;
    private String lessonName;
    private String lessonDate;
    private String startTime;
    private String endTime;
    private Integer needCheck;
    private Integer checkPeriod;
    private String checkAddr;
    private String concreteAddr;
    private String coordinate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLessonName() {
        return lessonName;
    }

    public void setLessonName(String lessonName) {
        this.lessonName = lessonName;
    }

    public String getLessonDate() {
        return lessonDate;
    }

    public void setLessonDate(String lessonDate) {
        this.lessonDate = lessonDate;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
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

    public String getCheckAddr() {
        return checkAddr;
    }

    public void setCheckAddr(String checkAddr) {
        this.checkAddr = checkAddr;
    }

    public String getConcreteAddr() {
        return concreteAddr;
    }

    public void setConcreteAddr(String concreteAddr) {
        this.concreteAddr = concreteAddr;
    }

    public String getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(String coordinate) {
        this.coordinate = coordinate;
    }
}
