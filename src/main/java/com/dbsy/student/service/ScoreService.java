package com.dbsy.student.service;
import com.dbsy.student.pojo.Family;
import com.dbsy.student.pojo.Score;
import com.dbsy.student.pojo.Student;

import java.util.List;
import java.util.Map;

public interface ScoreService {
    int insert(Score record);

    int insertSelective(Score record);

    int listCount(Map map);

    List<Score> list(Map map);

    int batchInsert(List<Score> list);

    Score get(int id);

    int delete(int id);

    int update(Score score);

    int batchRemove(int[] ids);

    List<Score> getAll();

    List<Score> getScoreByStudentId(int studentId);
}
