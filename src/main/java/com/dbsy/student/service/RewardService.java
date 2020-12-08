package com.dbsy.student.service;

import com.dbsy.student.excel.vo.RewardEo;
import com.dbsy.student.pojo.Reward;

import java.util.List;
import java.util.Map;

public interface RewardService {
    int insert(Reward record);

    int insertSelective(Reward record);

    int listCount(Map map);


    List<Map> list(Map map);

    int batchInsert(List list);

    Reward get(int id);

    int delete(int id);


    int addSingle(Map map);

    int update(Reward reward);

    int batchRemove(int[] ids);

    List<Reward> getAll();

    List<Reward> getRewardByStudentId(int studentId);

    List<Reward> getRewardsByStudentIdAndStudyTerm(int studentId, int studyTerm);

    List<RewardEo> listExport(Map map);

}
