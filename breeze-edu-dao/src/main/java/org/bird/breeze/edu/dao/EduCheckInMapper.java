package org.bird.breeze.edu.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.bird.breeze.edu.model.EduCheckIn;
import org.bird.breeze.edu.model.EduCheckInExample;

@Mapper
public interface EduCheckInMapper {
    long countByExample(EduCheckInExample example);

    int deleteByExample(EduCheckInExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(EduCheckIn record);

    int insertSelective(EduCheckIn record);

    List<EduCheckIn> selectByExample(EduCheckInExample example);

    EduCheckIn selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") EduCheckIn record, @Param("example") EduCheckInExample example);

    int updateByExample(@Param("record") EduCheckIn record, @Param("example") EduCheckInExample example);

    int updateByPrimaryKeySelective(EduCheckIn record);

    int updateByPrimaryKey(EduCheckIn record);
}