package com.dbsy.student.service;

import com.dbsy.student.pojo.Clazz;

import java.util.List;
import java.util.Map;

public interface ClazzService {
    int insert(Clazz record);

    int insertSelective(Clazz record);

    int listCount(Map map);

    List<Clazz> list(Map map);

    Clazz get(int id);

    int delete(int id);

    int update(Clazz clazz);

    int batchRemove(int[] ids);

    List<Clazz> getAll();

    List<Clazz> getClazzByMajorId(int majorId);
}
