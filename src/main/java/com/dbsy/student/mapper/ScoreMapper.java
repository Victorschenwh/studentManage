package com.dbsy.student.mapper;


import com.dbsy.student.excel.vo.AcademiScoreEo;
import com.dbsy.student.excel.vo.TotalScoreEo;
import com.dbsy.student.pojo.Score;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;
import java.util.Map;

@Mapper
public interface ScoreMapper {

    List<Map> slip(Map map);

    int insert(Score record);

    int insertSelective(Score record);

    @Select("select * from score where id = #{id}")
    Score get(int id);

    @Delete("delete from score where id = #{id}")
    int delete(int id);

    @Update("update score set student_id=#{studentId},course_id=#{courseId}," +
            "score=#{score},credit=#{credit},study_term=#{study_term},total_hours=#{total_hours},theory_hours=#{theory_hours}," +
            "experiment_hours=#{experiment_hours},test_time=#{test_time}  where id=#{id}")
    int update(Score score);

    @Update("update score set score=#{score} where student_id=#{id} and study_term=#{term} and course_id=#{course}" )
    int updateSelf(int id , int term, int course, double score);

    List<Map>getCourses(int id,int term);

    int batchInsert(List list);

    int batchRemove(int[] ids);

    @Select("select * from score")
    List<Score> getAll();

    @Select("select * from score where student_id=#{studentId}")
    List<Score> getScoreByStudentId(int studentId);

    @Select("select * from score where student_id = #{studentId} and course_id = #{courseId}")
    Score getByStudentIdAndCourseId(int studentId, int courseId);

    @Select("select * from score where student_id = #{studentId} and course_id = #{courseId} and study_term = #{studyTerm}")
    Score getByStudentIdCourseIdAndStudyTerm(int studentId, int courseId, int studyTerm);

    List<Map> listRank(Map map);

    List<Map> listTotal(Map map);

    int countTotal(Map map);

    int countRank(Map map);

    List<Map> studentScore(int id);

    List<Map> studentTotal(int id);

    //学生挂科数
    int fail(int id);

    List<Map> preWarming(Map map);

    int preWarmingCount(Map map);

    List<TotalScoreEo> listTotalExport(Map map);

    List<AcademiScoreEo> listAcademiExport(Map map);
}