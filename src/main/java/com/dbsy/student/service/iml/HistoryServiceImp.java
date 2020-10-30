package com.dbsy.student.service.iml;

import com.dbsy.student.mapper.HistoryMapper;
import com.dbsy.student.pojo.History;
import com.dbsy.student.service.HistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class HistoryServiceImp implements HistoryService {
    @Autowired
    HistoryMapper historyMapper;

    @Override
    public int insert(History history) {
        return historyMapper.insert(history);
    }

    @Override
    public int update(History history) {
        return historyMapper.update(history);
    }

    @Override
    public int delete(Integer id) {
        return historyMapper.delete(id);
    }

    @Override
    public History select(Integer id) {
        return historyMapper.select(id);
    }

    @Override
    public List<History> list(Map map) {
        if (map.get("page") != null) {
            int page = Integer.parseInt(map.get("page") + "");
            int pageSize = Integer.parseInt(map.get("pageSize") + "");
            map.put("start", (page - 1) * pageSize);
            map.put("pageSize", Integer.parseInt(map.get("pageSize") + ""));
        }
        return historyMapper.list(map);
    }

    @Override
    public int count(Map map) {
        return historyMapper.count(map);
    }
}
