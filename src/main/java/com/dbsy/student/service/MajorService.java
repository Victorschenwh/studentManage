package com.dbsy.student.service;

import com.dbsy.student.pojo.Major;

import java.util.List;
import java.util.Map;

public interface MajorService {
    int insert(Major record);

    int insertSelective(Major record);

    int listCount(Map map);

    List<Major> list(Map map);

    Major get(int id);

    Integer getIdByName(String name);

    int delete(int id);

    int update(Major major);

    int batchRemove(int[] ids);

    List<Major> getAll();

    List<Major> getMajorsByDpartmentId(int departmentId);
}
