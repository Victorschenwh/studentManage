package com.dbsy.student.service.iml;

import com.dbsy.student.pojo.History;
import com.dbsy.student.service.HistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HistoryServiceImp implements HistoryService {
    @Autowired
    HistoryService historyService;

    @Override
    public int insert(History history) {
        return historyService.insert(history);
    }

    @Override
    public int update(History history) {
        return historyService.update(history);
    }

    @Override
    public int delete(Integer id) {
        return historyService.delete(id);
    }

    @Override
    public History select(Integer id) {
        return historyService.select(id);
    }
}
