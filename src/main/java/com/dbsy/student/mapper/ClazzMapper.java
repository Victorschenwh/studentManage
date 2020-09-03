package com.dbsy.student.mapper;

import com.dbsy.student.pojo.Clazz;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;
import java.util.Map;

@Mapper
public interface ClazzMapper {

    int insert(Clazz record);

    int insertSelective(Clazz record);

    int listCount(Map map);

    List<Clazz> list(Map map);

    @Select("select * from clazz where id = #{id}")
    Clazz get(int id);

    @Select("select * from clazz where name = #{name}")
    Integer getIdByName(String name);


    @Delete("delete from clazz where id = #{id}")
    int delete(int id);

    @Update("update clazz set name=#{name},introduce=#{introduce},major_id=#{majorId},department_id=#{departmentId} where id=#{id}")
    int update(Clazz clazz);

    int batchRemove(int[] ids);

    @Select("select * from clazz")
    List<Clazz> getAll();

    @Select("select * from clazz where major_id=#{majorId}")
    List<Clazz> getClazzByMajorId(int majorId);

    @Select("select * from clazz where name=#{majorName}")
    List<Clazz> getClazzByMajorName(String majorName);

    @Select("select * from clazz where major_id=#{majorId} and grade = #{grade}")
    List<Clazz> getClazzsByMajorIdAndGrade(Integer majorId, Integer grade);


}