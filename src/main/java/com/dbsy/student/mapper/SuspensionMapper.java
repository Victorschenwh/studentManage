package com.dbsy.student.mapper;

import com.dbsy.student.pojo.Suspension;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;
import java.util.Map;

@Mapper
public interface SuspensionMapper {
    int insert(Suspension record);

    int insertSelective(Suspension record);

    int listCount(Map map);

    List<Map> list(Map map);

    @Select("select * from suspension where id = #{id}")
    Suspension get(int id);

    @Delete("delete from suspension where id = #{id}")
    int delete(int id);

    @Update("update suspension set student_id=#{studentId},suspension_date=#{suspensionDate},resumption_date=#{resumptionDate},duration=#{duration},reason=#{reason},remarks=#{remarks}  where id=#{id}")
    int update(Suspension suspension);

    int batchRemove(int[] ids);

    @Select("select * from suspension")
    List<Suspension> getAll();

    @Select("select * from suspension where student_id=#{studentId}")
    List<Suspension> getSuspensionByStudentId(int studentId);
}