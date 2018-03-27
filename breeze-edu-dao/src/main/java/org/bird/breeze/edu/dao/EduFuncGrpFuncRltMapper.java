package org.bird.breeze.edu.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.bird.breeze.edu.model.EduFuncGrpFuncRlt;
import org.bird.breeze.edu.model.EduFuncGrpFuncRltExample;

@Mapper
public interface EduFuncGrpFuncRltMapper {
    long countByExample(EduFuncGrpFuncRltExample example);

    int deleteByExample(EduFuncGrpFuncRltExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(EduFuncGrpFuncRlt record);

    int insertSelective(EduFuncGrpFuncRlt record);

    List<EduFuncGrpFuncRlt> selectByExample(EduFuncGrpFuncRltExample example);

    EduFuncGrpFuncRlt selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") EduFuncGrpFuncRlt record, @Param("example") EduFuncGrpFuncRltExample example);

    int updateByExample(@Param("record") EduFuncGrpFuncRlt record, @Param("example") EduFuncGrpFuncRltExample example);

    int updateByPrimaryKeySelective(EduFuncGrpFuncRlt record);

    int updateByPrimaryKey(EduFuncGrpFuncRlt record);
}