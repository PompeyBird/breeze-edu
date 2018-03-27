package org.bird.breeze.edu.wechat.controller;

import com.alibaba.fastjson.JSONObject;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.bird.breeze.edu.bean.WechatLessonBean;
import org.bird.breeze.edu.bean.WechatUserBean;
import org.bird.breeze.edu.bean.common.BreezeResult;
import org.bird.breeze.edu.constants.WechatConstants;
import org.bird.breeze.edu.model.EduLesson;
import org.bird.breeze.edu.utils.BreezeDateUtils;
import org.bird.breeze.edu.utils.RedisUtils;
import org.bird.breeze.edu.utils.WechatUtils;
import org.bird.breeze.edu.wechat.service.ICheckInSvc;
import org.bird.breeze.edu.wechat.service.impl.CheckInSvcImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author pompey
 */
@Controller
public class CheckInController {

    private static Logger logger = LoggerFactory.getLogger(CheckInController.class);

    private final static String TIME_NO_SECOND_FORMAT = "yyyy-MM-dd HH:mm";

    @Autowired
    private ICheckInSvc checkInSvc;
    @Autowired
    private RedisUtils redisUtils;
    @Autowired
    private WechatUtils wechatUtils;

    @RequestMapping(value = "/checkin", method = RequestMethod.GET)
    public String checkIn(HttpServletRequest request, Model model){
//        logger.info("====================into check in====================");
        String openId = (String)request.getSession().getAttribute(WechatConstants.OPEN_ID);
        model.addAttribute("root", request.getContextPath());
        BreezeResult<List<EduLesson>> result = checkInSvc.queryLessons(openId);
        if(!result.getSuccess() || null == result.getData()){
//            logger.info("====================lessons error====================");
            return "nolesson";
        }
        if(result.getData().size() == 0){
//            logger.info("====================no lessons====================");
            return "nolesson";
        }
        List<WechatLessonBean> lessons = convertToPickList(result.getData());
        model.addAttribute("lessons", JSONObject.toJSONString(lessons));
//        try{
//            logger.info("====================call wechat js api====================");
//            String jsApiTicket = wechatUtils.getJsApiTicket();
//            StringBuffer reqUrl = request.getRequestURL();
//            Map<String,String> signature = wechatUtils.getSignature(jsApiTicket, URLEncoder.encode(reqUrl.toString(), "UTF-8"));
//            logger.info("====================reqUrl : "+ reqUrl + "====================");
//            for(String key : signature.keySet()){
//                logger.info("===================="+key+" : "+ signature.get(key) + "====================");
//            }
//            model.addAttribute("appId",wechatUtils.getAppid());
//            model.addAttribute("timestamp", signature.get("timestamp"));
//            model.addAttribute("nonceStr", signature.get("nonceStr"));
//            model.addAttribute("signature", signature.get("signature"));
//        }catch (Exception e){
//            logger.error("进入签到页出错",  e);
//            return "errors";
//        }
        return "checkin";
    }

    @RequestMapping(value = "/signature", method = RequestMethod.GET)
    @ResponseBody
    public Map<String,String> getSingature(String url){
        Map<String,String> signature = new HashMap<String, String>();
        try {
//            logger.info("====================call wechat js api====================");
            String jsApiTicket = wechatUtils.getJsApiTicket();
//        StringBuffer reqUrl = request.getRequestURL();
            signature = wechatUtils.getSignature(jsApiTicket, url);
//            logger.info("====================reqUrl : " + url + "====================");
            for (String key : signature.keySet()) {
//                logger.info("====================" + key + " : " + signature.get(key) + "====================");
            }
            signature.remove("jsapi_ticket");
            signature.put("appId", wechatUtils.getAppid());
        }catch (Exception e){
            logger.error("进入签到页出错",  e);
        }
        return signature;
    }

    @RequestMapping(value = "/checkDis", method = RequestMethod.GET)
    @ResponseBody
    public BreezeResult<Boolean> checkDis(Integer lessonId, String lat, String lng){
        BreezeResult<Boolean> result = checkInSvc.checkInDistance(lat, lng, lessonId);
        return result;
    }

    @RequestMapping(value = "/signIn", method = RequestMethod.POST)
    @ResponseBody
    public BreezeResult<Integer> signIn(HttpServletRequest request, Integer lessonId,
                                        String lat, String lng){
//        logger.info("====================into sign in====================");
        String openId = (String)request.getSession().getAttribute(WechatConstants.OPEN_ID);
        return checkInSvc.sign(lat, lng, lessonId, openId);
    }

    private List<WechatLessonBean> convertToPickList(List<EduLesson> lessons){
        List<WechatLessonBean> list = new ArrayList<WechatLessonBean>(10);
        for(EduLesson lesson : lessons){
            WechatLessonBean bean = new WechatLessonBean();
            bean.setValue(lesson.getId().toString());
            bean.setTitle(lesson.getLessonName());
            SimpleDateFormat format = new SimpleDateFormat(TIME_NO_SECOND_FORMAT);
            String period = format.format(lesson.getCheckStartTime())
                    + "~" + format.format(lesson.getCheckEndTime());
            bean.setPeriod(period);
            list.add(bean);
        }
        return list;
    }

    @RequestMapping(value = "/check", method = RequestMethod.GET)
    public String check(HttpServletRequest request, Model model){
        model.addAttribute("root", request.getContextPath());
        String lessonId =  request.getParameter("lessonId");
        String code =  request.getParameter("code");
        String lessonCodeKey = "CHECK_CODE_"+lessonId;
        String cachedCode = redisUtils.get(lessonCodeKey);
        Integer checked = (Integer)request.getSession().getAttribute(lessonCodeKey);
        if(code == null || cachedCode == null
                || !code.equals(cachedCode) || checked != null){
            model.addAttribute("msg", "签到二维码失效，请重新扫码签到");
            return "errors";
        }
        model.addAttribute("lessonId", lessonId);
        model.addAttribute("code", code);
        return "check";
    }

    @RequestMapping(value = "/check", method = RequestMethod.POST)
    @ResponseBody
    public BreezeResult<Integer> checkSubmit(WechatUserBean bean, HttpServletRequest request){
        String lessonId =  request.getParameter("lessonId");
        String code =  request.getParameter("code");
        String lessonCodeKey = "CHECK_CODE_"+lessonId;
        String cachedCode = redisUtils.get(lessonCodeKey);
        Integer checked = (Integer)request.getSession().getAttribute(lessonCodeKey);
        if(code == null || cachedCode == null
                || !code.equals(cachedCode) || checked != null){
            return new BreezeResult<Integer>("签到二维码失效或已签到，请重新扫码签到");
        }
        BreezeResult<Integer> result = checkInSvc.checkIn(Integer.parseInt(lessonId),bean);
        if(result.getSuccess()){
            request.getSession().setAttribute(lessonCodeKey, result.getData());
        }
        return result;
    }

}
