package com.dbsy.student.service;

import com.dbsy.student.excel.ExcelSave;
import com.dbsy.student.pojo.Employment;
import com.dbsy.student.pojo.Student;

import java.util.List;
import java.util.Map;


public interface EmploymentService {
    int insert(Employment record);

    int insertSelective(Employment record);

    int batchInsert(List<Student> list);

    Employment get(int id);

    Employment getByStudentId(int studentId);

    int listCount(Map map);

    List<Employment> list(Map map);

    int delete(int id);

    int batchRemove(int[] ids);

    int update(Employment employment);


}
