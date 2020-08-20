package com.dbsy.student.mapper;

import com.dbsy.student.pojo.Student;

public interface StudentMapper {
    int insert(Student record);

    int insertSelective(Student record);
}