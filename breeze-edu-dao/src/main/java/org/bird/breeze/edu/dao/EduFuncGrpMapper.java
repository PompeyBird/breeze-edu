package org.bird.breeze.edu.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.bird.breeze.edu.model.EduFuncGrp;
import org.bird.breeze.edu.model.EduFuncGrpExample;

@Mapper
public interface EduFuncGrpMapper {
    long countByExample(EduFuncGrpExample example);

    int deleteByExample(EduFuncGrpExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(EduFuncGrp record);

    int insertSelective(EduFuncGrp record);

    List<EduFuncGrp> selectByExample(EduFuncGrpExample example);

    EduFuncGrp selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") EduFuncGrp record, @Param("example") EduFuncGrpExample example);

    int updateByExample(@Param("record") EduFuncGrp record, @Param("example") EduFuncGrpExample example);

    int updateByPrimaryKeySelective(EduFuncGrp record);

    int updateByPrimaryKey(EduFuncGrp record);
}