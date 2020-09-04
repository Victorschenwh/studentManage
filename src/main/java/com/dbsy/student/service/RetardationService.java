package com.dbsy.student.service;

import com.dbsy.student.pojo.Retardation;

import java.util.List;
import java.util.Map;

public interface RetardationService {

    int insert(Retardation record);

    int insertSelective(Retardation record);

    int listCount(Map map);

    List<Map> list(Map map);

    Retardation get(int id);

    int delete(int id);

    int update(Retardation retardation);

    int batchRemove(int[] ids);

    List<Retardation> getAll();

    List<Retardation> getRetardationByStudentId(int studentId);

    List<Retardation> getRetardationByOldDepartmentId(int oldDepartmentId);

    List<Retardation> getRetardationByOldMajorId(int oldMajorId);

    List<Retardation> getRetardationByOldClazzId(int oldClazzId);

    List<Retardation> getRetardationByNewDepartmentId(int newDepartmentId);

    List<Retardation> getRetardationByNewMajorId(int newMajorId);

    List<Retardation> getRetardationByNewClazzId(int newClazzId);
}
