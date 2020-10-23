package com.dbsy.student.service.iml;

import com.dbsy.student.mapper.AdminMapper;
import com.dbsy.student.pojo.Admin;
import com.dbsy.student.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("adminServiceImp")
public class AdminServiceImp implements AdminService {
    @Autowired
    AdminMapper adminMapper;

    @Override
    public int insert(Admin record) {
        return adminMapper.insert(record);
    }

    @Override
    public int insertSelective(Admin record) {
        return adminMapper.insertSelective(record);
    }

    @Override
    public Admin selectByUsernameAndPassword(String username, String password) {
        return adminMapper.selectByUsernameAndPassword(username, password);
    }

    @Override
    public Admin selectByEmail(String email) {
        return adminMapper.selectByEmail(email);
    }

    @Override
    public int update(Admin admin) {
        return adminMapper.update(admin);
    }

    @Override
    public List<Map> findAdmin(Map map) {
        return adminMapper.findAdmin(map);
    }

    @Override
    public int findAdminCount(Map map) {
        return adminMapper.findAdminCount(map);
    }

}
