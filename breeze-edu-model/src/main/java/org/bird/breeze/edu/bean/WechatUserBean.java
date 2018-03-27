package org.bird.breeze.edu.bean;

import java.io.Serializable;

/**
 * @author pompey
 */
public class WechatUserBean implements Serializable {
    private static final long serialVersionUID = -5752646454681186155L;

    private String studentId;
    private String classId;
    private String realname;

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
}
