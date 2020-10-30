package com.dbsy.student.mapper;

import com.dbsy.student.pojo.Power;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface PowerMapper {
    @Insert("insert into power (null,#{role},#{menuId})")
    int insert(Power power);

    @Delete("delete from power where id=#{id}")
    int delete(Integer id);

    @Select("select * from power where role=#{role}")
    Power finds(String role);
}
