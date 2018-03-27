package org.bird.breeze.edu.dao;

import org.apache.ibatis.annotations.Mapper;
import org.bird.breeze.edu.bean.lesson.CheckInBean;

import java.util.List;

@Mapper
public interface LessonCheckInMapper {
    List<CheckInBean> selectLessonCheckIn(Integer lessonId);
}
