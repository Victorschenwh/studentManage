package com.dbsy.student.mapper;

import com.dbsy.student.pojo.Admin;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface AdminMapper {
    int insert(Admin record);

    int insertSelective(Admin record);

    @Select("select * from admin where username = #{username} and password = #{password}")
    Admin selectByUsernameAndPassword(String username, String password);

    @Select("select * from admin where email = #{email}")
    Admin selectByEmail(String email);

    @Update("update admin set password=#{password}  where username=#{username}")
    int changePWByUsername(Admin admin);

}