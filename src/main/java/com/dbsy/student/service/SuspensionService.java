package com.dbsy.student.service;

import com.dbsy.student.pojo.Suspension;


import java.util.List;
import java.util.Map;

public interface SuspensionService {
    int insert(Suspension record);

    int insertSelective(Suspension record);

    int listCount(Map map);

    List<Map> list(Map map);

    Suspension get(int id);

    int delete(int id);

    int update(Suspension suspension);

    int batchRemove(int[] ids);

    List<Suspension> getAll();

    List<Suspension> getSuspensionByStudentId(int studentId);
}
