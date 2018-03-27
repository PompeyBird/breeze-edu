package org.bird.breeze.edu.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.bird.breeze.edu.model.EduLesson;
import org.bird.breeze.edu.model.EduLessonExample;

public interface EduLessonMapper {
    long countByExample(EduLessonExample example);

    int deleteByExample(EduLessonExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(EduLesson record);

    int insertSelective(EduLesson record);

    List<EduLesson> selectByExample(EduLessonExample example);

    EduLesson selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") EduLesson record, @Param("example") EduLessonExample example);

    int updateByExample(@Param("record") EduLesson record, @Param("example") EduLessonExample example);

    int updateByPrimaryKeySelective(EduLesson record);

    int updateByPrimaryKey(EduLesson record);
}