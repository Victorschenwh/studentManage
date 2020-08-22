package com.dbsy.student.service;
import com.dbsy.student.pojo.Reward;

import java.util.List;
import java.util.Map;

public interface RewardService {
    int insert(Reward record);

    int insertSelective(Reward record);

    int listCount(Map map);

    List<Reward> list(Map map);

    Reward get(int id);

    int delete(int id);

    int update(Reward reward);

    int batchRemove(int[] ids);

    List<Reward> getAll();

    List<Reward> getRewardByStudentId(int studentId);
}
