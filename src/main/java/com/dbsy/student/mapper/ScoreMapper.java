package com.dbsy.student.mapper;

import com.dbsy.student.pojo.Score;

public interface ScoreMapper {
    int insert(Score record);

    int insertSelective(Score record);
}