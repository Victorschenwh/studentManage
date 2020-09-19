package com.dbsy.student.service;

import com.dbsy.student.pojo.Score;


import java.util.List;
import java.util.Map;

public interface ScoreService {
    int insert(Score record);

    int insertSelective(Score record);

    List<Map> listRank(Map map);

    int batchInsert(List list);

    Score get(int id);

    int delete(int id);

    int update(Score score);

    int batchRemove(int[] ids);

    List<Score> getAll();

    List<Score> getScoreByStudentId(int studentId);

    int countRank(Map map);

    List<Map> listTotal(Map map);

}
