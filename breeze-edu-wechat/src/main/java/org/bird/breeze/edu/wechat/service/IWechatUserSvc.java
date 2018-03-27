package org.bird.breeze.edu.wechat.service;

import com.alibaba.fastjson.JSONObject;
import org.bird.breeze.edu.bean.WechatUserBean;
import org.bird.breeze.edu.bean.common.BreezeResult;
import org.bird.breeze.edu.model.EduWechatUser;

/**
 * @author pompey
 */
public interface IWechatUserSvc {

    BreezeResult<EduWechatUser> queryWechatUserByOpenId(String openId);

    BreezeResult<Integer> addWechatUserInfo(JSONObject userInfo);

    BreezeResult<Integer> bindWechatUser(String openId, WechatUserBean wechatUserBean);

}
