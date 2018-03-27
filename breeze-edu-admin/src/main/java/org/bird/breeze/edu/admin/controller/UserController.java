package org.bird.breeze.edu.admin.controller;

import org.bird.breeze.edu.admin.service.IUserFuncSvc;
import org.bird.breeze.edu.bean.UserFuncBean;
import org.bird.breeze.edu.bean.common.PageBean;
import org.bird.breeze.edu.model.EduFunc;
import org.bird.breeze.edu.model.EduUserExample;
import org.bird.breeze.edu.dao.EduUserMapper;
import org.bird.breeze.edu.model.EduUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

@RequestMapping(value = "/users")
@RestController
public class UserController {

    @Autowired
    private IUserFuncSvc iUserFuncSvc;

//    @RequestMapping(value = "/", method = RequestMethod.GET)
//    public List<EduUser> getCountryList(){
//        EduUserExample example = new EduUserExample();
//        return eduUserMapper.selectByExample(example);
//    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public UserFuncBean getCountry(@PathVariable Integer id){
        return iUserFuncSvc.queryUserFuncs(id);
    }

    @RequestMapping(value = "/funcs", method = RequestMethod.GET)
    public PageBean<EduFunc> queryFuncs(Integer pageStart, Integer pageSize, HttpServletRequest request)
    {
        return iUserFuncSvc.queryFuncs(pageStart,pageSize);
    }
}
