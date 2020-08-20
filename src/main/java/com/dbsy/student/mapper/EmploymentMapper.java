package com.dbsy.student.mapper;

import com.dbsy.student.pojo.Employment;

public interface EmploymentMapper {
    int insert(Employment record);

    int insertSelective(Employment record);
}