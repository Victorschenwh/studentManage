package com.dbsy.student.service;

import com.dbsy.student.excel.vo.AcademiScoreEo;
import com.dbsy.student.excel.vo.TotalScoreEo;
import com.dbsy.student.pojo.Score;


import java.util.List;
import java.util.Map;

public interface ScoreService {
    int insert(Score record);

    int insertSelective(Score record);

    List<Map> listRank(Map map);

    int batchInsert(List list);

    Score get(int id);

    List<Map> getCourses(int id,int term);

    int delete(int id);

    int update(Score score);

    int updateSelf(Map map);

    int batchRemove(int[] ids);

    List<Score> getAll();

    List<Score> getScoreByStudentId(int studentId);

    int countRank(Map map);

    List<Map> listTotal(Map map);

    public int countTotal(Map map);

    List<Map> studentScore(int id);

    List<Map> studentTotal(int id);

    //学生挂科数
    int fail(int id);

    List<Map> preWarming(Map map);

    int preWarmingCount(Map map);

    List<Map> slip(Map map);

    List<TotalScoreEo> listTotalExport(Map map);

    List<AcademiScoreEo> listAcademiExport(Map map);

}
