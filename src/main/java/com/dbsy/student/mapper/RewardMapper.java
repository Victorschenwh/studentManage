package com.dbsy.student.mapper;



import com.dbsy.student.pojo.Family;
import com.dbsy.student.pojo.Reward;
import com.dbsy.student.pojo.Score;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;
import java.util.Map;
@Mapper
public interface RewardMapper {
    int insert(Reward record);

    int insertSelective(Reward record);

    int listCount(Map map);

    List<Reward> list(Map map);

    @Select("select * from reward where id = #{id}")
    Reward get(int id);

    @Delete("delete from reward where id = #{id}")
    int delete(int id);

    @Update("update reward set student_id=#{studentId},synopsis=#{synopsis},type=#{type}  where id=#{id}")
    int update(Reward reward);

    int batchRemove(int[] ids);

    @Select("select * from reward")
    List<Reward> getAll();

    @Select("select * from score where student_id=#{studentId}")
    List<Reward> getRewardByStudentId(int studentId);
}