package org.bird.breeze.edu.admin.controller;

import io.jsonwebtoken.Claims;
import org.apache.commons.text.RandomStringGenerator;
import org.bird.breeze.edu.admin.service.ILessonSvc;
import org.bird.breeze.edu.bean.common.BreezeResult;
import org.bird.breeze.edu.bean.common.PageBean;
import org.bird.breeze.edu.bean.lesson.LessonFormBean;
import org.bird.breeze.edu.bean.lesson.LessonSearchBean;
import org.bird.breeze.edu.constants.MemberConstants;
import org.bird.breeze.edu.model.EduLesson;
import org.bird.breeze.edu.utils.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RequestMapping(value = "/lessons")
@RestController
public class LessonController {

    @Autowired
    private ILessonSvc iLessonSvc;
    @Autowired
    private RedisUtils redisUtils;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public PageBean<EduLesson> queryLessons(LessonSearchBean searchBean, Integer pageStart,
                                            Integer pageSize, HttpServletRequest request){
        Claims claims = (Claims)request.getAttribute(MemberConstants.USER_CLAIMS);
        Integer userId = (Integer) claims.get("userId");
        return iLessonSvc.queryLessons(searchBean, userId, pageStart, pageSize);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public BreezeResult<Integer> addLesson(LessonFormBean lessonForm, HttpServletRequest request){
        Claims claims = (Claims)request.getAttribute(MemberConstants.USER_CLAIMS);
        Integer userId = (Integer) claims.get("userId");
        return iLessonSvc.addLesson(lessonForm, userId);
    }

    @RequestMapping(value = "/{lessonId}", method = RequestMethod.PUT)
    public BreezeResult<Integer> updateLesson(@PathVariable Integer lessonId, LessonFormBean lessonForm, HttpServletRequest request){
        lessonForm.setId(lessonId);
        Claims claims = (Claims)request.getAttribute(MemberConstants.USER_CLAIMS);
        Integer userId = (Integer) claims.get("userId");
        return iLessonSvc.updateLesson(lessonForm, userId);
    }

    @RequestMapping(value = "/{lessonId}", method = RequestMethod.GET)
    public BreezeResult<EduLesson> queryLessonById(@PathVariable Integer lessonId, HttpServletRequest request){
        Claims claims = (Claims)request.getAttribute(MemberConstants.USER_CLAIMS);
        Integer userId = (Integer) claims.get("userId");
        return iLessonSvc.queryLessonById(lessonId, userId);
    }

    @RequestMapping(value="/{lessonId}", method=RequestMethod.DELETE)
    public BreezeResult<Integer> deleteLessonById(@PathVariable Integer lessonId, HttpServletRequest request){
        Claims claims = (Claims)request.getAttribute(MemberConstants.USER_CLAIMS);
        Integer userId = (Integer) claims.get("userId");
        return iLessonSvc.deleteLessonById(lessonId, userId);
    }

    @RequestMapping(value="/code/{lessonId}", method=RequestMethod.GET)
    public Map<String,String> getCheckCode(@PathVariable Integer lessonId, HttpServletRequest request){
        RandomStringGenerator generator = new RandomStringGenerator
                .Builder().withinRange('0','9')
                .build();
        String checkCode = generator.generate(12);
        redisUtils.set("CHECK_CODE_"+lessonId, checkCode, 60);
        Map<String,String> map = new HashMap<String, String>(5);
        map.put("checkCode",checkCode);
        return map;
    }
}
