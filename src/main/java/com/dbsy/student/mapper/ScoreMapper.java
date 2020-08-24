package com.dbsy.student.mapper;



import com.dbsy.student.pojo.Family;
import com.dbsy.student.pojo.Score;
import com.dbsy.student.pojo.Student;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.poi.ddf.EscherOptRecord;

import java.util.List;
import java.util.Map;
@Mapper
public interface ScoreMapper {
    int insert(Score record);

    int insertSelective(Score record);

    int listCount(Map map);

    List<Score> list(Map map);

    @Select("select * from score where id = #{id}")
    Score get(int id);

    @Delete("delete from score where id = #{id}")
    int delete(int id);

    @Update("update score set student_id=#{studentId},course_id=#{courseId},score=#{score},credit=#{credit},study_term=#{study_term},total_hours=#{total_hours},theory_hours=#{theory_hours},experiment_hours=#{experiment_hours},test_time=#{test_time}  where id=#{id}")
    int update(Score score);

    int batchInsert(List list);

    int batchRemove(int[] ids);

    @Select("select * from score")
    List<Score> getAll();

    @Select("select * from score where student_id=#{studentId}")
    List<Score> getScoreByStudentId(int studentId);
}