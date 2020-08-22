package com.dbsy.student.mapper;

import com.dbsy.student.pojo.Employment;
import com.dbsy.student.pojo.Student;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@Mapper
public interface EmploymentMapper {
    int insert(Employment record);

    int insertSelective(Employment record);

    int batchInsert(List<Student> list);

    @Select("select * from employment where id = #{id}")
    Student get(int id);

    int listCount(Map map);

    List<Employment> list(Map map);

    @Delete("delete from employment where id = #{id}")
    int delete(int id);

    int batchRemove(int[] ids);
}