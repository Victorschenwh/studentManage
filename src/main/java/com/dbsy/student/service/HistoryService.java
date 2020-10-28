package com.dbsy.student.service;

import com.dbsy.student.pojo.History;

public interface HistoryService {
    int insert(History history);

    int update(History history);

    int delete(Integer id);

    History select(Integer id);
}
