package com.dbsy.student.service;

import com.dbsy.student.pojo.Student;

import java.util.List;
import java.util.Map;

public interface StudentService {
    int insert(Student record);

    int insertSelective(Student record);

    int batchInsert(List<Student> list);

    Student get(int id);

    Map getSelf(int id);

    int listCount(Map map);

    List<Student> list(Map map);

    int delete(int id);

    int batchRemove(int[] ids);

    Student selectByNumber(String number);

    int update (Student student);

    int getMajorCountByMajorId(int majorId);
}
