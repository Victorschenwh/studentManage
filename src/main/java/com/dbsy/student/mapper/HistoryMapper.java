package com.dbsy.student.mapper;

import com.dbsy.student.pojo.History;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface HistoryMapper {
    int insert(History history);

    int update(History history);

    int delete(Integer id);

    History select(Integer id);
}
