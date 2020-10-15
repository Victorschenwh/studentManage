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

    int batchInsert(List list);

    int listCount(Map map);

    List<Map> list(Map map);

    @Select("select * from suspension where id = #{id}")
    Suspension get(int id);

    Map getSelf(int id);

    List<Map> getByText(String text);

    @Delete("delete from suspension where id = #{id}")
    int delete(int id);

    @Update("UPDATE  student stu  LEFT JOIN suspension s ON stu.id=s.student_id  set stu.isDel=0 WHERE stu.isDel=1 AND s.id=#{id}")
    int reback(int id);


    @Update("update suspension set suspension_date=#{suspensionDate},resumption_date=#{resumptionDate},duration=#{duration},reason=#{reason},remarks=#{remarks}  where id=#{id}")
    int update(Suspension suspension);


//    1==休学 ；0==正常
    @Update("update student set isDel= 1 where id=#{studentId}")
    int updateLogicStu(Suspension suspension);

    @Update("insert into  suspension set suspension_date=#{suspensionDate},resumption_date=#{resumptionDate},duration=#{duration},reason=#{reason},remarks=#{remarks} ,student_id=#{studentId}")
    int updateLogicSuspen(Suspension suspension);


    int batchRemove(int[] ids);

    @Select("select * from suspension")
    List<Suspension> getAll();

    @Select("select * from suspension where student_id=#{studentId}")
    List<Suspension> getSuspensionByStudentId(int studentId);
}