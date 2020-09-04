package com.dbsy.student.mapper;



import com.dbsy.student.pojo.Family;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;
import java.util.Map;
@Mapper
public interface FamilyMapper {
    int insert(Family record);

    int insertSelective(Family record);

    int listCount(Map map);

    List<Map> list(Map map);

    @Select("select * from family where id = #{id}")
    Family get(int id);

    @Delete("delete from family where id = #{id}")
    int delete(int id);

    @Update("update family set name=#{name},work=#{work},relationship=#{relationship},age=#{age},gender=#{gender},id_card=#{idCard},phone_number=#{phoneNumber},student_id=#{studentId}  where id=#{id}")
    int update(Family family);

    int batchRemove(int[] ids);

    @Select("select * from family")
    List<Family> getAll();

    @Select("select * from family where student_id=#{studentId}")
    List<Family> getFamilyByStudentId(int studentId);

}