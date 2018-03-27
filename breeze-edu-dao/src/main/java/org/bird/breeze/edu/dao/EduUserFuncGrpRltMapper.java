package org.bird.breeze.edu.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.bird.breeze.edu.model.EduUserFuncGrpRlt;
import org.bird.breeze.edu.model.EduUserFuncGrpRltExample;

@Mapper
public interface EduUserFuncGrpRltMapper {
    long countByExample(EduUserFuncGrpRltExample example);

    int deleteByExample(EduUserFuncGrpRltExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(EduUserFuncGrpRlt record);

    int insertSelective(EduUserFuncGrpRlt record);

    List<EduUserFuncGrpRlt> selectByExample(EduUserFuncGrpRltExample example);

    EduUserFuncGrpRlt selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") EduUserFuncGrpRlt record, @Param("example") EduUserFuncGrpRltExample example);

    int updateByExample(@Param("record") EduUserFuncGrpRlt record, @Param("example") EduUserFuncGrpRltExample example);

    int updateByPrimaryKeySelective(EduUserFuncGrpRlt record);

    int updateByPrimaryKey(EduUserFuncGrpRlt record);
}