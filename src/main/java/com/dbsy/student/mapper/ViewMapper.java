package com.dbsy.student.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface ViewMapper {
    public List<Map> listScore(Map map);
}
