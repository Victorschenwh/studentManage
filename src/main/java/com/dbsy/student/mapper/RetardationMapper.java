package com.dbsy.student.mapper;

import com.dbsy.student.pojo.Retardation;

public interface RetardationMapper {
    int insert(Retardation record);

    int insertSelective(Retardation record);
}