package org.bird.breeze.edu.bean.lesson;

import java.util.Date;

/**
 * @author pompey
 */
public class CheckInBean {
    private Integer checkInId;
    private String lessonName;
    private String concreteAddr;
    private String studentId;
    private String classId;
    private String realname;
    private Date checkInTime;

    public Integer getCheckInId() {
        return checkInId;
    }

    public void setCheckInId(Integer checkInId) {
        this.checkInId = checkInId;
    }

    public String getLessonName() {
        return lessonName;
    }

    public void setLessonName(String lessonName) {
        this.lessonName = lessonName;
    }

    public String getConcreteAddr() {
        return concreteAddr;
    }

    public void setConcreteAddr(String concreteAddr) {
        this.concreteAddr = concreteAddr;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getClassId() {
        return classId;
    }

    public void setClassId(String classId) {
        this.classId = classId;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public Date getCheckInTime() {
        return checkInTime;
    }

    public void setCheckInTime(Date checkInTime) {
        this.checkInTime = checkInTime;
    }
}
