package org.bird.breeze.edu.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.bird.breeze.edu.model.EduWechatUser;
import org.bird.breeze.edu.model.EduWechatUserExample;

@Mapper
public interface EduWechatUserMapper {
    long countByExample(EduWechatUserExample example);

    int deleteByExample(EduWechatUserExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(EduWechatUser record);

    int insertSelective(EduWechatUser record);

    List<EduWechatUser> selectByExample(EduWechatUserExample example);

    EduWechatUser selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") EduWechatUser record, @Param("example") EduWechatUserExample example);

    int updateByExample(@Param("record") EduWechatUser record, @Param("example") EduWechatUserExample example);

    int updateByPrimaryKeySelective(EduWechatUser record);

    int updateByPrimaryKey(EduWechatUser record);
}