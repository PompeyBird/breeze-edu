package org.bird.breeze.edu.admin.service;

import org.bird.breeze.edu.bean.common.BreezeResult;
import org.bird.breeze.edu.bean.UserFuncBean;
import org.bird.breeze.edu.bean.common.PageBean;
import org.bird.breeze.edu.model.EduFunc;

import java.util.List;
import java.util.Map;

public interface IUserFuncSvc {
    UserFuncBean queryUserFuncs(Integer userId);

    BreezeResult<String> userLogin(String name, String password);

    int updateUserLoginTime(Integer userId);

    PageBean<EduFunc> queryFuncs(Integer pageStart, Integer pageSize);
}
