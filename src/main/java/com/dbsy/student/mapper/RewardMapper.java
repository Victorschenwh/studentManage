package com.dbsy.student.mapper;

import com.dbsy.student.pojo.Reward;

public interface RewardMapper {
    int insert(Reward record);

    int insertSelective(Reward record);
}