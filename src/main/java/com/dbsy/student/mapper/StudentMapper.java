package com.dbsy.student.mapper;

import com.dbsy.student.pojo.Student;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@Mapper
public interface StudentMapper {
    int insert(Student record);

    int insertSelective(Student record);

    int batchInsert(List<Student> list);

    @Select("select * from student where id = #{id}")
    Student get(int id);

    int listCount(Map map);

    List<Student> list(Map map);

    @Delete("delete from student where id = #{id}")
    int delete(int id);

    int batchRemove(int[] ids);

}