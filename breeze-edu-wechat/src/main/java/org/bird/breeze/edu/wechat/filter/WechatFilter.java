package org.bird.breeze.edu.wechat.filter;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.bird.breeze.edu.bean.common.BreezeResult;
import org.bird.breeze.edu.constants.WechatConstants;
import org.bird.breeze.edu.model.EduWechatUser;
import org.bird.breeze.edu.utils.*;
import org.bird.breeze.edu.wechat.service.IWechatUserSvc;
import org.bird.breeze.edu.wechat.service.impl.WechatUserSvcImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.regex.Pattern;

public class WechatFilter extends OncePerRequestFilter {
    private final static Logger logger = LoggerFactory.getLogger(WechatFilter.class);

    private String exceptUrlRegex;
    private Pattern exceptUrlPattern;

    private PatternUtils patternUtils;
    private RedisUtils redisUtils;
    private WechatUtils wechatUtils;
    private IWechatUserSvc wechatUserSvc;

    public void setExceptUrlRegex(String exceptUrlRegex) {
        this.exceptUrlRegex = exceptUrlRegex;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws ServletException, IOException {
        if(null == exceptUrlPattern){
            this.redisUtils = SpringContext.getBean(RedisUtils.class);
            this.patternUtils = SpringContext.getBean(PatternUtils.class);
            this.wechatUtils = SpringContext.getBean(WechatUtils.class);
            this.wechatUserSvc = SpringContext.getBean(IWechatUserSvc.class);
            if(StringUtils.isNotEmpty(exceptUrlRegex)){
                exceptUrlPattern = patternUtils.build(exceptUrlRegex);
            }
        }

        String servletPath = request.getServletPath();
        if (exceptUrlPattern.matcher(servletPath).matches()) {
            chain.doFilter(request, response);
            return;
        }

        HttpSession session = request.getSession(true);
        // 从session获取openid
        String openId = (String) session.getAttribute(WechatConstants.OPEN_ID);
//        openId = "oZHp109P9dI8xjVpAZHKzxtoAolU";
//        session.setAttribute(WechatConstants.OPEN_ID,openId);
//        openId ="cccccccccccc";
//        session.setAttribute(WechatConstants.OPEN_ID,openId);
        if(StringUtils.isEmpty(openId)){
//            logger.info("====================session openid not have=====================");
            // session中没有，检查是否在redis里
            String openIdKey = request.getParameter(WechatConstants.OPEN_ID_KEY);
            if(null != openIdKey){
//                logger.info("====================session key have=====================");
                openId = redisUtils.get(openIdKey);
            }
            if(StringUtils.isEmpty(openId)){
                // redis中没有openid，重新认证
//                logger.info("====================session key openid not have=====================");
                dispatchToOauth("/oauth", request, response);
                return;
            }
            else{
                // 有的话，保存入session
//                logger.info("====================session key openid have=====================");
                redisUtils.delete(openIdKey);
                session.setAttribute(WechatConstants.OPEN_ID,openId);
            }
        }
        // 根据openid获取用户信息（redis）
//        logger.info("====================get userinfo by opneid=====================");
        String userInfo = wechatUtils.getCachedInfoByOpenId(openId);
        EduWechatUser user = null;
        if(StringUtils.isEmpty(userInfo)){
//            logger.info("====================get userinfo fail=====================");
            // redis中没有用户信息，查询数据库
            BreezeResult<EduWechatUser> userResult = wechatUserSvc.queryWechatUserByOpenId(openId);
            if(!userResult.getSuccess()){
                dispatchToOauth("/errors",request, response);
                return;
            }
            user = userResult.getData();
            if(null == user){
//                logger.info("====================get db userinfo fail=====================");
                // 数据库中也没有，重新认证
                dispatchToOauth("/oauth",request, response);
                return;
            }
            else {
                // 数据库中有，加入缓存
                wechatUtils.cacheInfoByOpenId(openId, JSONObject.toJSONString(user), 7200);
            }
        }
        else{
            // redis中有用户信息
//            logger.info("====================redis has info=====================");
            user = JSONObject.parseObject(userInfo, EduWechatUser.class);
        }

        if(StringUtils.isEmpty(user.getStudentId())){
            // 用户没有绑定信息，进行绑定
//            logger.info("====================not bind ,goto bind=====================");
            dispatchToOauth("/bind",request, response);
            return;
        }
        //用户进行过绑定，一些正常
        chain.doFilter(request, response);
    }

    private void dispatchToOauth(String url,HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        StringBuffer reqUrl = request.getRequestURL();
        String currentUrl = reqUrl.toString();
        String redirectUrl = currentUrl;
        Integer position = currentUrl.indexOf(";");
        if(position != -1){
            redirectUrl = currentUrl.substring(0, position);
        }
        String oauthUrl = url + "?targetUrl=" + URLEncoder.encode(redirectUrl,"UTF-8");
//        logger.info("====================oauthUrl:"+oauthUrl+"=====================");
        request.getRequestDispatcher(oauthUrl).forward(request, response);
//        response.sendRedirect(oauthUrl);
    }
}
