package com.dbsy.student.service;

import com.dbsy.student.pojo.Retardation;
import com.dbsy.student.pojo.Student;
import com.dbsy.student.pojo.Transfer;

import java.util.List;
import java.util.Map;

public interface RetardationService {

    int insert(Retardation record);

    int insertSelective(Retardation record);

    int listCount(Map map);

    List<Student> listStu(Map map);
    int listCountStu(Map map);


    List<Map> listDropSchool(Map map);
    int listCountDrop(Map map);

    Map getSelf(int id);


    List<Map> listClName(int stuId);

    List<Map> listGrade();

    int updateLogic(Retardation retardation);

    int batchInsert(List<Retardation> list);

    List<Map> list(Map map);

    List<Map>  list3(Map map);

    int listCount3(Map map);

    Retardation get(int id);

    Map getOpposite(int id);

    int delete(int id);

    int update(Retardation retardation);
    int updateLast(Retardation retardation);

    int batchRemove(int[] ids);

    List<Retardation> getAll();

    List<Retardation> getRetardationByStudentId(int studentId);

    List<Retardation> getRetardationByOldDepartmentId(int oldDepartmentId);

    List<Retardation> getRetardationByOldMajorId(int oldMajorId);

    List<Retardation> getRetardationByOldClazzId(int oldClazzId);

    List<Retardation> getRetardationByNewDepartmentId(int newDepartmentId);

    List<Retardation> getRetardationByNewMajorId(int newMajorId);

    List<Retardation> getRetardationByNewClazzId(int newClazzId);

    int updateSelective(Retardation retardation);
}
