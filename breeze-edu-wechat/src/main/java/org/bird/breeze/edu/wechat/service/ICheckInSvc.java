package org.bird.breeze.edu.wechat.service;

import org.bird.breeze.edu.bean.WechatUserBean;
import org.bird.breeze.edu.bean.common.BreezeResult;
import org.bird.breeze.edu.model.EduLesson;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ICheckInSvc {
    BreezeResult<List<EduLesson>> queryLessons(String openId);
    BreezeResult<Integer> checkIn(Integer lessonId,WechatUserBean wechatUserBean);
    BreezeResult<Boolean> checkInDistance(String lat1, String lng1, Integer lessonId);
    BreezeResult<Integer> sign(String lat, String lng, Integer lessonId, String openId);
}
