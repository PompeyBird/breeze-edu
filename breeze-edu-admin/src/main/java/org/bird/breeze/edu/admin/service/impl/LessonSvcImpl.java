package org.bird.breeze.edu.admin.service.impl;

import org.apache.commons.lang3.StringUtils;
import org.bird.breeze.edu.admin.service.ILessonSvc;
import org.bird.breeze.edu.bean.common.BreezeResult;
import org.bird.breeze.edu.bean.common.PageBean;
import org.bird.breeze.edu.bean.lesson.CheckInBean;
import org.bird.breeze.edu.bean.lesson.LessonFormBean;
import org.bird.breeze.edu.bean.lesson.LessonSearchBean;
import org.bird.breeze.edu.dao.EduLessonMapper;
import org.bird.breeze.edu.dao.LessonCheckInMapper;
import org.bird.breeze.edu.model.EduLesson;
import org.bird.breeze.edu.model.EduLessonExample;
import org.bird.breeze.edu.utils.BreezeDateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @author pompey
 */
@Service
public class LessonSvcImpl extends BaseSvcImpl implements ILessonSvc {

    @Autowired
    private EduLessonMapper eduLessonMapper;
    @Autowired
    private LessonCheckInMapper checkInMapper;

    /**
     *
     * @param searchBean 传课程
     * @return 添加结果
     */
    @Override
    public PageBean<EduLesson> queryLessons(LessonSearchBean searchBean, Integer userId,
                                            Integer pageStart, Integer pageSize){
        EduLessonExample eduLessonExample = buildLessonExample(searchBean, userId);
        eduLessonExample.setLimit(pageSize);
        eduLessonExample.setOffset(pageStart);

        List<EduLesson> lessons = eduLessonMapper.selectByExample(eduLessonExample);
        Long total = eduLessonMapper.countByExample(eduLessonExample);

        PageBean<EduLesson> result = new PageBean<EduLesson>();
        result.setPageIndex(pageStart/pageSize + 1);
        result.setTotal(total);
        result.setData(lessons);

        return result;
    }

    /**
     *
     * @param lessonForm 课程表单
     * @return 添加结果
     */
    @Override
    public BreezeResult<Integer> addLesson(LessonFormBean lessonForm, Integer userId){

        BreezeResult<Integer> result = null;
        try {

            EduLesson eduLesson = buildLesson(lessonForm, null, userId);

//            if(!checkDate(eduLesson, userId) ){
//                result = new BreezeResult<Integer>("当前签到时间段内已有其他课程");
//                return result;
//            }

            Integer lessonId = eduLessonMapper.insert(eduLesson);
            result = new BreezeResult<Integer>();
            result.setData(lessonId);
        } catch (Exception e){
            result = new BreezeResult<Integer>("创建课程失败");
        }

        return result;
    }

    @Override
    public BreezeResult<Integer> updateLesson(LessonFormBean lessonForm, Integer userId){
        BreezeResult<Integer> result = null;
        try {
            EduLesson eduLesson = selectLessonByUserId(lessonForm.getId(), userId);
            eduLesson = buildLesson(lessonForm, eduLesson, userId);

//            if(!checkDate(eduLesson, userId) ){
//                result = new BreezeResult<Integer>("当前签到时间段内已有其他课程");
//                return result;
//            }

            int count = eduLessonMapper.updateByPrimaryKey(eduLesson);

            result = new BreezeResult<Integer>();
            result.setData(count);
        } catch (Exception e){
            result = new BreezeResult<Integer>("保存课程失败");
        }

        return result;
    }

    @Override
    public BreezeResult<EduLesson> queryLessonById(Integer lessonId, Integer userId){
        BreezeResult<EduLesson> result = null;
        try {

            EduLesson eduLesson = selectLessonByUserId(lessonId, userId);
            result = new BreezeResult<EduLesson>();
            result.setData(eduLesson);
        } catch (Exception e){
            result = new BreezeResult<EduLesson>("查询课程失败");
        }

        return result;
    }

    @Override
    public BreezeResult<Integer> deleteLessonById(Integer lessonId, Integer userId){
        BreezeResult<Integer> result = null;
        try {

            EduLessonExample eduLessonExample = new EduLessonExample();
            eduLessonExample.createCriteria().andIdEqualTo(lessonId)
                    .andUserIdEqualTo(userId);
            EduLesson record = new EduLesson();
            record.setDataState(0);
            Integer count = eduLessonMapper.updateByExampleSelective(record,eduLessonExample);

            result = new BreezeResult<Integer>();
            result.setData(count);
        } catch (Exception e){
            result = new BreezeResult<Integer>("查询课程失败");
        }

        return result;
    }

//    private boolean checkDate(EduLesson eduLesson ,Integer userId){
//        EduLessonExample eduLessonExample = new EduLessonExample();
//        eduLessonExample.createCriteria().andUserIdEqualTo(userId)
//                .andCheckStartTimeGreaterThanOrEqualTo(eduLesson.getCheckStartTime())
//                .andCheckStartTimeLessThanOrEqualTo(eduLesson.getCheckEndTime())
//                .andNeedCheckEqualTo(eduLesson.getNeedCheck());
//        long count = eduLessonMapper.countByExample(eduLessonExample);
//        if(count > 0){
//            return false;
//        }
//        return true;
//    }

    private EduLesson selectLessonByUserId(Integer lessonId, Integer userId){
        EduLessonExample eduLessonExample = new EduLessonExample();
        eduLessonExample.createCriteria().andIdEqualTo(lessonId)
                .andUserIdEqualTo(userId);

        List<EduLesson> eduLessons = eduLessonMapper.selectByExample (eduLessonExample);

        if(eduLessons != null && eduLessons.size() > 0){
            return eduLessons.get(0);
        }
        return null;
    }

    private EduLesson buildLesson(LessonFormBean lessonForm, EduLesson eduLesson, Integer userId){
        Date dateTime = BreezeDateUtils.getDate();
        if(eduLesson == null){
            eduLesson = new EduLesson();
        }
        eduLesson.setLessonName(lessonForm.getLessonName());
        eduLesson.setLessonDate(BreezeDateUtils.paraDate(lessonForm.getLessonDate(),1));
        eduLesson.setStartTime(BreezeDateUtils.paraDateTime(lessonForm.getLessonDate(), lessonForm.getStartTime(),1));
        eduLesson.setEndTime(BreezeDateUtils.paraDateTime(lessonForm.getLessonDate(), lessonForm.getEndTime(), 1));
        eduLesson.setNeedCheck(lessonForm.getNeedCheck());
        eduLesson.setCheckAddr(lessonForm.getCheckAddr());
        eduLesson.setCheckPeriod(lessonForm.getCheckPeriod());
        eduLesson.setCheckStartTime(BreezeDateUtils.getOffestDate(eduLesson.getStartTime(),
                Calendar.MINUTE, eduLesson.getCheckPeriod()*-1));
        eduLesson.setCheckEndTime(BreezeDateUtils.getOffestDate(eduLesson.getStartTime(),
                Calendar.MINUTE, eduLesson.getCheckPeriod()));
        eduLesson.setConcreteAddr(lessonForm.getConcreteAddr());
        String[] coordinate = StringUtils.split(lessonForm.getCoordinate(),"|");
        eduLesson.setCoordinateX(coordinate[0]);
        eduLesson.setCoordinateY(coordinate[1]);

        if(eduLesson.getUserId() == null ){
            eduLesson.setUserId(userId);
        }
        if(eduLesson.getDataState() == null){
            eduLesson.setDataState(1);
        }
        eduLesson.setCreateTime(dateTime);
        eduLesson.setModifyTime(dateTime);

        return eduLesson;
    }

    private EduLessonExample buildLessonExample(LessonSearchBean searchBean, Integer userId){

        EduLessonExample eduLessonExample = new EduLessonExample();
        EduLessonExample.Criteria criteria = eduLessonExample.createCriteria();
        criteria.andUserIdEqualTo(userId).andDataStateEqualTo(1);
        if(StringUtils.isNotEmpty(searchBean.getLessonName())){
            criteria.andLessonNameLike(searchBean.getLessonName());
        }
        if(StringUtils.isNotEmpty(searchBean.getLessonDate())){
            Date lessonDate = BreezeDateUtils.paraDate(searchBean.getLessonDate(),1);
            criteria.andLessonDateEqualTo(lessonDate);
        }
        if(StringUtils.isNotEmpty(searchBean.getStartTime())){
            Date startTime = BreezeDateUtils.paraDateTime(searchBean.getLessonDate(), searchBean.getStartTime(),1);
            criteria.andStartTimeGreaterThan(startTime);
        }
        if(StringUtils.isNotEmpty(searchBean.getEndTime())){
            Date endTime = BreezeDateUtils.paraDateTime(searchBean.getLessonDate(), searchBean.getEndTime(),1);
            criteria.andEndTimeLessThanOrEqualTo(endTime);
        }

        return eduLessonExample;
    }

    @Override
    public BreezeResult<List<CheckInBean>> downLoadCheckIn(Integer lessonId){
        BreezeResult<List<CheckInBean>> result = null;
        try {
            List<CheckInBean> list = checkInMapper.selectLessonCheckIn(lessonId);
            result = new BreezeResult<List<CheckInBean>>();
            result.setData(list);
        } catch (Exception e){
            result = new BreezeResult<List<CheckInBean>>("查询签到信息失败");
        }
        return result;
    }
}
