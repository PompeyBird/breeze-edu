package org.bird.breeze.edu.dao;

import org.apache.ibatis.annotations.Mapper;
import org.bird.breeze.edu.model.EduFunc;

import java.util.List;

@Mapper
public interface UserFuncMapper {
    List<EduFunc> selectUserFunc(Integer userId);
}
