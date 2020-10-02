package com.dbsy.student.mapper;

import com.dbsy.student.pojo.Course;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

@Mapper
public interface CourseMapper {
    @Insert("insert into course values (#{id},#{number},#{name},#{departmentId})")
    int insert(Course record);

    int insertSelective(Course record);

    int listCount(Map map);

    List<Course> list(Map map);

    @Select("select * from course where id = #{id}")
    Course get(int id);

    @Delete("delete from course where id = #{id}")
    int delete(int id);

    @Update("update course set name=#{name},number=#{number},department_id=#{departmentId}  where id=#{id}")
    int update(Course course);

    int batchRemove(int[] ids);

    @Select("select * from course")
    List<Course> getAll();

    @Select("select * from course where department_id=#{departmentId}")
    List<Course> getCourseByDepartmentId(int departmentId);

    @Select("select * from course where name=#{name}")
    Course getCourseByName(String name);

    @Select("select * from course where name=#{name}")
    Course selectByName(String name);
}