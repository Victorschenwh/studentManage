package com.dbsy.student.service;

import com.dbsy.student.pojo.Admin;

public interface AdminService {

    int insert(Admin record);

    int insertSelective(Admin record);

    Admin selectByUsernameAndPassword(String username, String password);

    Admin selectByEmail(String email);
    int changePWByUsername(Admin admin);
}
