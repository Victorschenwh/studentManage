package com.dbsy.student.mapper;

import com.dbsy.student.pojo.Family;

public interface FamilyMapper {
    int insert(Family record);

    int insertSelective(Family record);
}