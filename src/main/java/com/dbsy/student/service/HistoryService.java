package com.dbsy.student.service;

import com.dbsy.student.pojo.History;

import java.util.List;
import java.util.Map;

public interface HistoryService {
    int insert(History history);

    int update(History history);

    int delete(Integer id);

    History select(Integer id);

    List<History> list(Map map);

    int count(Map map);
}
