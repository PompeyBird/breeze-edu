package org.bird.breeze.edu.admin.controller;

import org.bird.breeze.edu.admin.service.IUserFuncSvc;
import org.bird.breeze.edu.bean.LoginBean;
import org.bird.breeze.edu.bean.common.BreezeResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping(value = "/auth")
@RestController
public class MemberController {
    @Autowired
    private IUserFuncSvc iUserFuncSvc;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public BreezeResult<String> login(LoginBean loginBean){
        return iUserFuncSvc.userLogin(loginBean.getUserName(), loginBean.getPassword());
//        return loginResult;
    }
}
