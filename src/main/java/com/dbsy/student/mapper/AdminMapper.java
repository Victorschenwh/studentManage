package com.dbsy.student.mapper;

import com.dbsy.student.pojo.Admin;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;
import java.util.Map;

@Mapper
public interface AdminMapper {
    @Select("select * from admin where id = #{id}")
    Admin select(Integer id);

    @Select("select * from admin where role= #{role} and foreign_id = #{foreignId}")
    Admin findByRoleAndForeignId(Integer role, Integer foreignId);

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

    int findDepartLeaderCount(Map map);

    List<Map> findDepartLeader(Map map);


    int findSchoolLeaderCount(Map map);

    List<Map> findSchoolLeader(Map map);

    @Delete("delete from admin where id = #{id}")
    int delete(Integer id);
}