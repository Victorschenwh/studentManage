package com.dbsy.student.service;

import com.dbsy.student.pojo.Admin;

import java.util.List;
import java.util.Map;

public interface AdminService {

    int insert(Admin record);

    int insertSelective(Admin record);

    Admin selectByUsernameAndPassword(String username, String password);

    Admin selectByEmail(String email);

    int update(Admin admin);

    List<Map> findAdmin(Map map);

    int findAdminCount(Map map);

}
