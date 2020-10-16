package com.dbsy.student.service;

import com.dbsy.student.pojo.Suspension;


import java.util.List;
import java.util.Map;

public interface SuspensionService {
    int insert(Suspension record);

    int insertSelective(Suspension record);

    int batchInsert(List list);

    int listCount(Map map);

    List<Map> list(Map map);

    List<Map> getByText(String text);

    Suspension get(int id);

    Map getSelf(int id);

    List<Map> listClName(int stuId);

    int delete(int id);

//    int reback(int id);
    int reback(Map map);

    int update(Suspension suspension);

    int  updateLogic(Suspension suspension);

    int batchRemove(int[] ids);

    List<Suspension> getAll();

    List<Suspension> getSuspensionByStudentId(int studentId);
}
