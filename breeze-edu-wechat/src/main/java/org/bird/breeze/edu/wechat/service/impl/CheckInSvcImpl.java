package org.bird.breeze.edu.wechat.service.impl;

import com.alibaba.fastjson.JSONObject;
import org.bird.breeze.edu.bean.WechatUserBean;
import org.bird.breeze.edu.bean.common.BreezeResult;
import org.bird.breeze.edu.dao.EduCheckInMapper;
import org.bird.breeze.edu.dao.EduLessonMapper;
import org.bird.breeze.edu.dao.EduUserMapper;
import org.bird.breeze.edu.dao.EduWechatUserMapper;
import org.bird.breeze.edu.model.*;
import org.bird.breeze.edu.utils.BreezeDateUtils;
import org.bird.breeze.edu.utils.RedisUtils;
import org.bird.breeze.edu.utils.WechatUtils;
import org.bird.breeze.edu.wechat.service.ICheckInSvc;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author pompey
 */
@Service
public class CheckInSvcImpl extends BaseSvcImpl implements ICheckInSvc {

    private static Logger logger = LoggerFactory.getLogger(CheckInSvcImpl.class);
    private static final double EARTH_RADIUS = 6378.137d;

    @Autowired
    private EduLessonMapper eduLessonMapper;
    @Autowired
    private EduWechatUserMapper wechatUserMapper;
    @Autowired
    private EduUserMapper eduUserMapper;
    @Autowired
    private EduCheckInMapper checkInMapper;
    @Autowired
    private WechatUtils wechatUtils;

    @Override
    public BreezeResult<List<EduLesson>> queryLessons(String openId){
        BreezeResult<List<EduLesson>> result = null;
        try {
            String userInfo = wechatUtils.getCachedInfoByOpenId(openId);
            if(StringUtils.isEmpty(userInfo)){
                result = new BreezeResult<List<EduLesson>>("查询课程失败");
                return result;
            }
            EduWechatUser wechatUser = JSONObject.parseObject(userInfo, EduWechatUser.class);
            EduUser user = getUserByAppId(wechatUser.getWechatAppId());
            List<Integer> lessonIds = getCheckInLessons(wechatUser.getId());
            if(user != null){
                Date date = new Date();
                EduLessonExample example = new EduLessonExample();
                EduLessonExample.Criteria criteria = example.createCriteria();
                criteria.andUserIdEqualTo(user.getId())
                        .andDataStateEqualTo(1)
                        .andNeedCheckEqualTo(1)
                        .andCheckStartTimeLessThanOrEqualTo(date)
                        .andCheckEndTimeGreaterThanOrEqualTo(date);
//                        .andIdNotIn(lessonIds);
                if(null != lessonIds && lessonIds.size() > 0){
                    criteria.andIdNotIn(lessonIds);
                }
                List<EduLesson> lessons = eduLessonMapper.selectByExample(example);
                result = new BreezeResult<List<EduLesson>>();
                result.setData(lessons);
            }
            else{
                result = new BreezeResult<List<EduLesson>>("查询课程失败");
            }
        } catch (Exception e){
            logger.error("查询课程失败",e);
            result = new BreezeResult<List<EduLesson>>("查询课程失败");
        }

        return result;
    }

    private EduUser getUserByAppId(String appId){
        EduUserExample eduUserExample = new EduUserExample();
        eduUserExample.createCriteria().andWechatAppIdEqualTo(appId)
                .andDataStateEqualTo(1);
        List<EduUser> users = eduUserMapper.selectByExample(eduUserExample);
        if(null != users && users.size() > 0){
            return users.get(0);
        }
        return null;
    }

    private List<Integer> getCheckInLessons(Integer wechatUserId){
        List<Integer> lessonsIds = new ArrayList<Integer>();
        EduCheckInExample example = new EduCheckInExample();
        example.createCriteria().andWechatUserIdEqualTo(wechatUserId)
                .andDataStateEqualTo(1);
        List<EduCheckIn> list = checkInMapper.selectByExample(example);
        if(null != list){
            for(EduCheckIn checkIn : list){
                lessonsIds.add(checkIn.getLessonId());
            }
        }
        return lessonsIds;
    }

    @Override
    public BreezeResult<Integer> checkIn(Integer lessonId,WechatUserBean wechatUserBean){
        BreezeResult<Integer> result = null;
        try {
            Date dateTime = BreezeDateUtils.getDate();
            EduCheckIn eduCheckIn = new EduCheckIn();
            eduCheckIn.setLessonId(lessonId);
            eduCheckIn.setWechatUserId(-1);
            eduCheckIn.setCheckInAddr(JSONObject.toJSONString(wechatUserBean));
            eduCheckIn.setCheckInTime(dateTime);
            eduCheckIn.setCreateTime(dateTime);
            eduCheckIn.setModifyTime(dateTime);
            eduCheckIn.setDataState(1);
            Integer id = checkInMapper.insert(eduCheckIn);
            result = new BreezeResult<Integer>();
            result.setData(id);
        } catch (Exception e){
            result = new BreezeResult<Integer>("签到失败");
        }
        return result;
    }

    public BreezeResult<Boolean> checkInDistance(String lat1, String lng1, Integer lessonId){
        BreezeResult<Boolean> result = null;
        try {
            result = new BreezeResult<Boolean>();
            result.setData(checkDistance(lat1, lng1, lessonId));
        } catch (Exception e){
            logger.error("检查距离出错", e);
            result = new BreezeResult<Boolean>("检查距离失败");
        }
        return result;

    }

    private boolean checkDistance(String lat1, String lng1, Integer lessonId) throws Exception{
        EduLesson lesson = eduLessonMapper.selectByPrimaryKey(lessonId);
        if(null == lesson){
            throw new Exception("查询课程信息失败！");
        }
        String lat2 = lesson.getCoordinateX();
        String lng2 = lesson.getCoordinateY();
        double dis = getDistance(Double.parseDouble(lat1), Double.parseDouble(lng1),
                Double.parseDouble(lat2), Double.parseDouble(lng2));
        if(dis > 0.1){
            return false;
        }
        return true;
    }

    private double rad(double d)
    {
        return d * Math.PI / 180.0;
    }
    public double getDistance(double lat1, double lng1, double lat2, double lng2)
    {
//        logger.info("====================lat1: "+String.valueOf(lat1)+"====================");
//        logger.info("====================lng1: "+String.valueOf(lng1)+"====================");
//        logger.info("====================lat2: "+String.valueOf(lat2)+"====================");
//        logger.info("====================lng2: "+String.valueOf(lng2)+"====================");
        double radLat1 = rad(lat1);
        double radLat2 = rad(lat2);
        double a = radLat1 - radLat2;
        double b = rad(lng1) - rad(lng2);
        double s = 2 * Math.asin(Math.sqrt(Math.pow(Math.sin(a/2),2) +
                Math.cos(radLat1)*Math.cos(radLat2)*Math.pow(Math.sin(b/2),2)));
        s = s * EARTH_RADIUS;
        s = Math.round(s * 10000) / 10000;
//        logger.info("====================distance: "+String.valueOf(s)+"====================");
        return s;
    }

    @Override
    public BreezeResult<Integer> sign(String lat, String lng, Integer lessonId, String openId){
        BreezeResult<Integer> result = null;
        try {
//            logger.info("====================into sign====================");
            boolean inDistance = checkDistance(lat, lng, lessonId);
            if(inDistance){
//                logger.info("====================in distance====================");
                String userInfo = wechatUtils.getCachedInfoByOpenId(openId);
                JSONObject json = JSONObject.parseObject(userInfo);
                Integer userId = json.getInteger("id");
                boolean canSign = checkSinged(lessonId, userId);
                if(canSign){
//                    logger.info("====================can sign====================");
                    EduCheckIn eduCheckIn = buildCheckIn(lessonId, userId);
                    Integer id = checkInMapper.insert(eduCheckIn);
//                    logger.info("====================insert sign info====================");
                    result = new BreezeResult<Integer>();
                    result.setData(id);
                }
                else {
//                    logger.info("====================already sign====================");
                    result = new BreezeResult<Integer>("已签到过，无需签到");
                }
            }
            else {
//                logger.info("====================not in distance====================");
                result = new BreezeResult<Integer>("不在签到范围");
            }
        } catch (Exception e){
            logger.error("签到出错", e);
            result = new BreezeResult<Integer>("检查距离失败");
        }
        return result;
    }

    private EduCheckIn buildCheckIn(Integer lessonId, Integer userId){
        Date dateTime = BreezeDateUtils.getDate();

        EduCheckIn eduCheckIn = new EduCheckIn();
        eduCheckIn.setLessonId(lessonId);
        eduCheckIn.setWechatUserId(-1);
//        eduCheckIn.setCheckInAddr(JSONObject.toJSONString(wechatUserBean));
        eduCheckIn.setWechatUserId(userId);
        eduCheckIn.setCheckInTime(dateTime);
        eduCheckIn.setCreateTime(dateTime);
        eduCheckIn.setModifyTime(dateTime);
        eduCheckIn.setDataState(1);
        return eduCheckIn;
    }

    private boolean checkSinged(Integer lessonId, Integer userId){
        EduCheckInExample example = new EduCheckInExample();
        example.createCriteria().andLessonIdEqualTo(lessonId)
                .andWechatUserIdEqualTo(userId)
                .andDataStateEqualTo(1);
        List<EduCheckIn> list = checkInMapper.selectByExample(example);
        if(null != list && list.size() > 0){
            return false;
        }
        return true;
    }
}
