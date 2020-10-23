package com.dbsy.student.mapper;

import com.dbsy.student.pojo.Admin;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;
import java.util.Map;

@Mapper
public interface AdminMapper {
    int insert(Admin record);

    int insertSelective(Admin record);

    @Select("select * from admin where username = #{username} and password = #{password}")
    Admin selectByUsernameAndPassword(String username, String password);

    @Select("select * from admin where email = #{email}")
    Admin selectByEmail(String email);

    int update(Admin admin);

    int findAdminCount(Map map);

    List<Map> findAdmin(Map map);


    int findAssistantCount(Map map);

    List<Map> findAssistant(Map map);

}