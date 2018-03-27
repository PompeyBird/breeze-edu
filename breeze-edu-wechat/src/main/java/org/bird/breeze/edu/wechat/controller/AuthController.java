package org.bird.breeze.edu.wechat.controller;

import com.alibaba.fastjson.JSONObject;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.text.RandomStringGenerator;
import org.bird.breeze.edu.bean.WechatUserBean;
import org.bird.breeze.edu.bean.common.BreezeResult;
import org.bird.breeze.edu.constants.WechatConstants;
import org.bird.breeze.edu.utils.RedisUtils;
import org.bird.breeze.edu.utils.WechatUtils;
import org.bird.breeze.edu.wechat.service.IWechatUserSvc;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.net.URLEncoder;

@Controller
public class AuthController {

    private static Logger logger = LoggerFactory.getLogger(AuthController.class);

    @Autowired
    private WechatUtils wechatUtils;
    @Autowired
    private RedisUtils redisUtils;
    @Autowired
    private IWechatUserSvc wechatUserSvc;

    @RequestMapping(value = "/token", method = RequestMethod.GET)
    public void checkToken(HttpServletRequest request, HttpServletResponse response){
        // 微信加密签名
        String signature = request.getParameter("signature");
        // 时间戳
        String timestamp = request.getParameter("timestamp");
        // 随机数
        String nonce = request.getParameter("nonce");
        // 随机字符串
        String echostr = request.getParameter("echostr");
        // 通过检验signature对请求进行校验，若校验成功则原样返回echostr，表示接入成功，否则接入失败
        if (signature != null && wechatUtils.checkSignature(signature, timestamp, nonce)) {
            try {
                PrintWriter print = response.getWriter();
                print.write(echostr);
                print.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @RequestMapping(value = "/oauth", method = RequestMethod.GET)
    public String oauth(HttpServletRequest request, Model model, @RequestParam String targetUrl){
        String redirectUrl = "";
        try{
            if (targetUrl != null) {
                String backUrl =wechatUtils.getHost() + request.getContextPath()
                        + "/callback?targetUrl="+targetUrl;
    //            //组装授权url
                redirectUrl = wechatUtils.getOAuthLoginUrl(URLEncoder.encode(backUrl,"utf-8"),
                        WechatUtils.SCOPE_INFO);
            }
        }
        catch (Exception e){
            return "error";
        }
        return "redirect:" + redirectUrl;
    }

    @RequestMapping(value = "/callback", method = RequestMethod.GET)
    public String callback(HttpServletRequest request, Model model){
//        logger.info("====================into callback 1=====================");
        String code = request.getParameter("code");
        String targetUrl = request.getParameter("targetUrl");
        if(StringUtils.isNotEmpty(code)){
            try{
                JSONObject user = wechatUtils.getOAuthUserInfo(code);
                if(user != null){
//                    logger.info("====================into callback 2=====================");
                    // 将微信用户信息保存到数据库
                    wechatUserSvc.addWechatUserInfo(user);
                    // 缓存openid，防止在URL中传输
                    RandomStringGenerator generator = new RandomStringGenerator
                            .Builder().withinRange('0','9')
                            .build();
                    String openIdKey = generator.generate(6);
                    redisUtils.set(openIdKey, (String) user.get("openid"), 120);
                    // 构造含openid key的目标地址
//                    String decodeTargetUrl = URLDecoder.decode(targetUrl,"utf-8");
                    String decodeTargetUrl = targetUrl;
                    if(StringUtils.contains(decodeTargetUrl,"?")){
                        decodeTargetUrl = decodeTargetUrl + "&"+ WechatConstants.OPEN_ID_KEY + "=" + openIdKey;
                    }
                    else {
                        decodeTargetUrl = decodeTargetUrl + "?"+ WechatConstants.OPEN_ID_KEY + "=" + openIdKey;
                    }
                    // 设置目标地址targetUrl，并自动重调
//                    modell.addAttribute("targetUrl", URLEncoder.encode(decodeTargetUrl,"utf-8"));
//                    logger.info("====================into callback 3=====================");
                    model.addAttribute("targetUrl", decodeTargetUrl);
                    return "rewrite";
                }
            }
            catch (Exception e){
                model.addAttribute("root", request.getContextPath());
                model.addAttribute("msg", e.getMessage());
                return "errors";
            }
        }
        model.addAttribute("root", request.getContextPath());
        model.addAttribute("msg", "抱歉：系统出了点小问题，请关闭公众号，并稍后重试");
        return "errors";
    }

    @RequestMapping(value = "/errors", method = RequestMethod.GET)
    public String error(HttpServletRequest request, Model model){
        model.addAttribute("root", request.getContextPath());
        return "errors";
    }


    @RequestMapping(value = "/bind", method = RequestMethod.GET)
    public String bind(HttpServletRequest request, Model model){
//        logger.info("====================into bind=====================");
        model.addAttribute("root", request.getContextPath());
        String directUrl = request.getParameter("targetUrl");
        if(StringUtils.isEmpty(directUrl)){
            directUrl = StringUtils.EMPTY;
        }
        model.addAttribute("directUrl", directUrl);
        return "bind";
    }

    @RequestMapping(value = "/bind", method = RequestMethod.POST)
    @ResponseBody
    public BreezeResult<Integer> addBind(WechatUserBean bean, HttpServletRequest request){
        String openId = (String)request.getSession().getAttribute(WechatConstants.OPEN_ID);
        BreezeResult<Integer> bindResult = wechatUserSvc.bindWechatUser(openId, bean);
        return bindResult;
    }
}
