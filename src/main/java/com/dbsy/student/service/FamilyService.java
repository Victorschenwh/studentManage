package com.dbsy.student.service;
import com.dbsy.student.pojo.Family;
import com.dbsy.student.pojo.Student;

import java.util.List;
import java.util.Map;

public interface FamilyService {
    int insert(Family record);

    int insertSelective(Family record);

    int listCount(Map map);

    List<Family> list(Map map);

    Family get(int id);

    int delete(int id);

    int update(Family family);

    int batchRemove(int[] ids);

    List<Family> getAll();

    List<Family> getFamilyByStudentId(int studentId);

    int batchInsert(List list);
}
