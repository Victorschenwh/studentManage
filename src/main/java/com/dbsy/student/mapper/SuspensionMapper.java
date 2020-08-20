package com.dbsy.student.mapper;

import com.dbsy.student.pojo.Suspension;

public interface SuspensionMapper {
    int insert(Suspension record);

    int insertSelective(Suspension record);
}