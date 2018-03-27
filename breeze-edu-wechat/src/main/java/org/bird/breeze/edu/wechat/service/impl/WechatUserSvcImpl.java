package org.bird.breeze.edu.wechat.service.impl;

import com.alibaba.fastjson.JSONObject;
import org.bird.breeze.edu.bean.WechatUserBean;
import org.bird.breeze.edu.bean.common.BreezeResult;
import org.bird.breeze.edu.dao.EduCheckInMapper;
import org.bird.breeze.edu.dao.EduWechatUserMapper;
import org.bird.breeze.edu.model.EduCheckIn;
import org.bird.breeze.edu.model.EduWechatUser;
import org.bird.breeze.edu.model.EduWechatUserExample;
import org.bird.breeze.edu.utils.BreezeDateUtils;
import org.bird.breeze.edu.utils.WechatUtils;
import org.bird.breeze.edu.wechat.service.IWechatUserSvc;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author pompey
 */
@Service
public class WechatUserSvcImpl extends BaseSvcImpl implements IWechatUserSvc  {

    private static Logger logger = LoggerFactory.getLogger(WechatUserSvcImpl.class);

    @Autowired
    private EduWechatUserMapper wechatUserMapper;
    @Autowired
    private WechatUtils wechatUtils;
//    @Autowired
//    private EduCheckInMapper checkInMapper;

    @Override
    public BreezeResult<EduWechatUser> queryWechatUserByOpenId(String openId){
        BreezeResult<EduWechatUser> result = null;
        try {
            EduWechatUser eduWechatUser = selectEduWechatUserByOpenId(openId);
            result = new BreezeResult<EduWechatUser>();
            result.setData(eduWechatUser);
        } catch (Exception e){
            result = new BreezeResult<EduWechatUser>("查询公众号用户信息失败");
        }

        return result;
    }

    @Override
    public BreezeResult<Integer> addWechatUserInfo(JSONObject userInfo){
        BreezeResult<Integer> result;
        try {
//            logger.info("====================add info to db=====================");
            EduWechatUser user = selectEduWechatUserByOpenId((String) userInfo.get("openid"));
            EduWechatUser eduWechatUser =  buildEduWechatUser(userInfo, user);
            Integer id;
            if(user == null){
                id = wechatUserMapper.insert(eduWechatUser);
            }
            else {
                id = wechatUserMapper.updateByPrimaryKey(user);
            }
            result = new BreezeResult<Integer>();
            result.setData(id);
//            logger.info("====================add info result "+id+"=====================");
        } catch (Exception e){
            logger.error("保存公众号用户信息失败", e);
            result = new BreezeResult<Integer>("保存公众号用户信息失败");
        }
        return result;
    }

    @Override
    public BreezeResult<Integer> bindWechatUser(String openId, WechatUserBean wechatUserBean) {
        BreezeResult<Integer> result = null;
        try {

            EduWechatUser eduWechatUser = selectEduWechatUserByOpenId(openId);
            if(null == eduWechatUser){
                result = new BreezeResult<Integer>("查询公众号用户信息失败");
                return result;
            }
            eduWechatUser.setStudentId(wechatUserBean.getStudentId());
            eduWechatUser.setClassId(wechatUserBean.getClassId());
            eduWechatUser.setRealname(wechatUserBean.getRealname());
            Integer id = wechatUserMapper.updateByPrimaryKey(eduWechatUser);
            if(id > 0){
                wechatUtils.cacheInfoByOpenId(openId, JSONObject.toJSONString(eduWechatUser), 7200);
            }
            result = new BreezeResult<Integer>();
            result.setData(id);
        } catch (Exception e){
            result = new BreezeResult<Integer>("保存公众号用户信息失败");
        }
        return result;
    }

    private EduWechatUser selectEduWechatUserByOpenId(String openId){
        EduWechatUserExample example = new EduWechatUserExample();
        example.createCriteria().andOpenIdEqualTo(openId)
                .andWechatAppIdEqualTo(wechatUtils.getAppid())
                .andDataStateEqualTo(1);

        List<EduWechatUser> wechatUsers = wechatUserMapper.selectByExample(example);
        if(null != wechatUsers && wechatUsers.size() > 0){
            return  wechatUsers.get(0);
        }
        return null;
    }

    private EduWechatUser buildEduWechatUser(JSONObject userInfo, EduWechatUser eduWechatUser){
        Date dateTime = BreezeDateUtils.getDate();
        if(null == eduWechatUser){
            eduWechatUser = new EduWechatUser();
        }
        if(null != userInfo.get("openid")){
            eduWechatUser.setOpenId((String) userInfo.get("openid"));
        }
        if(null != userInfo.get("nickname")){
            eduWechatUser.setNickname((String) userInfo.get("nickname"));
        }
        if(null != userInfo.get("sex")){
            eduWechatUser.setSex((Integer) userInfo.get("sex"));
        }
        if(null != userInfo.get("province")){
            eduWechatUser.setProvince((String) userInfo.get("province"));
        }
        if(null != userInfo.get("city")){
            eduWechatUser.setCity((String) userInfo.get("city"));
        }
        if(null != userInfo.get("country")){
            eduWechatUser.setCountry((String) userInfo.get("country"));
        }
        if(null != userInfo.get("headimgurl")){
            eduWechatUser.setHeadimgurl((String) userInfo.get("headimgurl"));
        }
        eduWechatUser.setWechatAppId(wechatUtils.getAppid());
        eduWechatUser.setDataState(1);
        eduWechatUser.setCreateTime(dateTime);
        eduWechatUser.setModifyTime(dateTime);
        return eduWechatUser;
    }

}
