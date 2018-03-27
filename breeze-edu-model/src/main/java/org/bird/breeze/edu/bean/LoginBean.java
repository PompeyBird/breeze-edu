package org.bird.breeze.edu.bean;

import java.io.Serializable;

/**
 * @author pompey
 */
public class LoginBean implements Serializable {
    private static final long serialVersionUID = 7734082603632933176L;
    private String userName;
    private String password;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
