package org.bird.breeze.edu.admin.service.impl;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.bird.breeze.edu.admin.service.IUserFuncSvc;
import org.bird.breeze.edu.bean.common.BreezeResult;
import org.bird.breeze.edu.bean.UserFuncBean;
import org.bird.breeze.edu.bean.common.PageBean;
import org.bird.breeze.edu.dao.*;
import org.bird.breeze.edu.model.EduFunc;
import org.bird.breeze.edu.model.EduFuncExample;
import org.bird.breeze.edu.model.EduUser;
import org.bird.breeze.edu.model.EduUserExample;
import org.bird.breeze.edu.utils.JwtUtils;
import org.bird.breeze.edu.utils.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author pompey
 */
@Service
public class UserFuncSvcImpl extends BaseSvcImpl implements IUserFuncSvc {

    @Autowired
    private EduUserMapper eduUserMapper;
    @Autowired
    private UserFuncMapper userFuncMapper;
    @Autowired
    private EduFuncMapper eduFuncMapper;
    @Autowired
    private RedisUtils redisUtils;
    @Autowired
    private JwtUtils jwtUtils;

    private static String USER_KEY_PREFIX = "USER_KEY_";

    @Override
    public UserFuncBean queryUserFuncs(Integer userId) {

//        String userKey = USER_KEY_PREFIX + userId;
//        String userInfoStr = redisUtils.get(userKey);
//        if(StringUtils.isNotEmpty(userInfoStr)){
//            return (UserFuncBean)JSONObject.parseObject(userInfoStr,UserFuncBean.class);
//        }

        EduUser user = eduUserMapper.selectByPrimaryKey(userId);
        List<EduFunc> funcList = userFuncMapper.selectUserFunc(userId);

        UserFuncBean userFuncBean = new UserFuncBean();
        userFuncBean.setUser(user);
        userFuncBean.setFuncList(funcList);

//        userInfoStr = JSONObject.toJSONString(userFuncBean);
//        redisUtils.set(userKey, userInfoStr);

        return userFuncBean;
    }

    @Override
    public BreezeResult<String> userLogin(String username, String password){

        Integer userId = null;
        BreezeResult<String> result = null;

        if(StringUtils.isEmpty(username) || StringUtils.isEmpty(password)){
            result = new BreezeResult<String>("用户名密码不能为空！");
            return result;
        }

        EduUserExample eduUserExample = new EduUserExample();
        eduUserExample.createCriteria().andUserCodeEqualTo(username).andPasswordEqualTo(password);
        List<EduUser> users = eduUserMapper.selectByExample(eduUserExample);

        if(!CollectionUtils.isEmpty(users)){
            userId = users.get(0).getId();
        }

        if(userId != null){
            UserFuncBean userFuncBean = queryUserFuncs(userId);
            int count = updateUserLoginTime(userId);
            if(count > 0){
                result = new BreezeResult<String>();
//                List<EduFunc> funcList = userFuncMapper.selectUserFunc(userId);
                String jwtToken = jwtUtils.createJWT(userId,
                        userFuncBean.getUser(), userFuncBean.getFuncList());
                result.setData("Bearer|"+jwtToken);
                return result;
            }
            result = new BreezeResult<String>("登录失败，请稍后再试！");
            return result;
        }

        result = new BreezeResult<String>("用户名密码错误！");
        return result;
    }

    @Override
    public int updateUserLoginTime(Integer userId){
        EduUser record = new EduUser();
        record.setId(userId);
        record.setLastLoginTime(new Date());
        return eduUserMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public PageBean<EduFunc> queryFuncs(Integer pageStart, Integer pageSize){

        EduFuncExample eduFuncExample = new EduFuncExample();

        Long total = eduFuncMapper.countByExample(eduFuncExample);

        eduFuncExample.setLimit(pageSize);
        eduFuncExample.setOffset(pageStart);

        List<EduFunc> funcList = eduFuncMapper.selectByExample(eduFuncExample);

        PageBean<EduFunc> result = new PageBean<EduFunc>();
        result.setPageIndex(pageStart/pageSize + 1);
        result.setTotal(total);
        result.setData(funcList);

        return result;
    }
}
