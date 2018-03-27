package org.bird.breeze.edu.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.bird.breeze.edu.model.EduUser;
import org.bird.breeze.edu.model.EduUserExample;

@Mapper
public interface EduUserMapper {
    long countByExample(EduUserExample example);

    int deleteByExample(EduUserExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(EduUser record);

    int insertSelective(EduUser record);

    List<EduUser> selectByExample(EduUserExample example);

    EduUser selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") EduUser record, @Param("example") EduUserExample example);

    int updateByExample(@Param("record") EduUser record, @Param("example") EduUserExample example);

    int updateByPrimaryKeySelective(EduUser record);

    int updateByPrimaryKey(EduUser record);
}