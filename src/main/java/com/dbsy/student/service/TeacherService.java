package com.dbsy.student.service;

import com.dbsy.student.pojo.Teacher;

import java.util.List;
import java.util.Map;

public interface TeacherService {
    int insert(Teacher record);

    int insertSelective(Teacher record);

    int listCount(Map map);

    List<Teacher> list(Map map);

    Teacher get(int id);

    int delete(int id);

    int update(Teacher teacher);

    int batchRemove(int[] ids);

    List<Teacher> getAll();

    Teacher selectByUsernameAndPassword(String username, String password);

    Teacher selectByEmail(String email);
    int changePWByUsername(Teacher teacher);
}
