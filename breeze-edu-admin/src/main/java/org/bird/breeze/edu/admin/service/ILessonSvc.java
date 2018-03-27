package org.bird.breeze.edu.admin.service;

import org.bird.breeze.edu.bean.common.BreezeResult;
import org.bird.breeze.edu.bean.common.PageBean;
import org.bird.breeze.edu.bean.lesson.CheckInBean;
import org.bird.breeze.edu.bean.lesson.LessonFormBean;
import org.bird.breeze.edu.bean.lesson.LessonSearchBean;
import org.bird.breeze.edu.model.EduLesson;

import java.util.List;

public interface ILessonSvc {

    PageBean<EduLesson> queryLessons(LessonSearchBean searchBean, Integer userId,
                                            Integer pageStart, Integer pageSize);

    BreezeResult<Integer> addLesson(LessonFormBean lessonForm, Integer userId);

    BreezeResult<Integer> updateLesson(LessonFormBean lessonForm, Integer userId);

    BreezeResult<EduLesson> queryLessonById(Integer lessonId, Integer userId);

    BreezeResult<Integer> deleteLessonById(Integer lessonId, Integer userId);

    BreezeResult<List<CheckInBean>> downLoadCheckIn(Integer lessonId);
}
