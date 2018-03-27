package org.bird.breeze.edu.bean;

import org.bird.breeze.edu.model.EduFunc;
import org.bird.breeze.edu.model.EduUser;

import java.io.Serializable;
import java.util.List;

/**
 * @author pompey
 */
public class UserFuncBean implements Serializable {

    private static final long serialVersionUID = -4518565363750010829L;

    private EduUser user;
    private List<EduFunc> funcList;

    public EduUser getUser() {
        return user;
    }

    public void setUser(EduUser user) {
        this.user = user;
    }

    public List<EduFunc> getFuncList() {
        return funcList;
    }

    public void setFuncList(List<EduFunc> funcList) {
        this.funcList = funcList;
    }
}
