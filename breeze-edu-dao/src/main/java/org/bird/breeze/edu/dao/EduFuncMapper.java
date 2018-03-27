package org.bird.breeze.edu.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.bird.breeze.edu.model.EduFunc;
import org.bird.breeze.edu.model.EduFuncExample;

@Mapper
public interface EduFuncMapper {
    long countByExample(EduFuncExample example);

    int deleteByExample(EduFuncExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(EduFunc record);

    int insertSelective(EduFunc record);

    List<EduFunc> selectByExample(EduFuncExample example);

    EduFunc selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") EduFunc record, @Param("example") EduFuncExample example);

    int updateByExample(@Param("record") EduFunc record, @Param("example") EduFuncExample example);

    int updateByPrimaryKeySelective(EduFunc record);

    int updateByPrimaryKey(EduFunc record);
}