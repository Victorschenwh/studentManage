package com.dbsy.student.service.iml;

import com.dbsy.student.annotation.Authority;
import com.dbsy.student.mapper.AdminMapper;
import com.dbsy.student.pojo.Admin;
import com.dbsy.student.service.AdminService;
import com.dbsy.student.util.QueryUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("adminServiceImp")
public class AdminServiceImp implements AdminService {
    @Autowired
    AdminMapper adminMapper;

    @Override
    public Admin select(Integer id) {
        return adminMapper.select(id);
    }

    @Override
    public Admin findByRoleAndForeignId(Integer role, Integer foreignId) {
        return adminMapper.findByRoleAndForeignId(role, foreignId);
    }

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
        return adminMapper.findAdminCount(QueryUtil.query(map));
    }

    @Override
    public int findAssistantCount(Map map) {
        return adminMapper.findAssistantCount(QueryUtil.query(map));
    }

    @Override
    public List<Map> findAssistant(Map map) {

        return adminMapper.findAssistant(QueryUtil.query(map));
    }

    @Override
    public int findDepartLeaderCount(Map map) {
        return adminMapper.findDepartLeaderCount(QueryUtil.query(map));
    }

    @Override
    public List<Map> findDepartLeader(Map map) {

        return adminMapper.findDepartLeader(QueryUtil.query(map));
    }

    @Override
    public int findSchoolLeaderCount(Map map) {
        return adminMapper.findSchoolLeaderCount(QueryUtil.query(map));
    }

    @Override
    public List<Map> findSchoolLeader(Map map) {
        return adminMapper.findSchoolLeader(QueryUtil.query(map));
    }

    @Override
    public int delete(Integer id) {
        return adminMapper.delete(id);
    }

}
