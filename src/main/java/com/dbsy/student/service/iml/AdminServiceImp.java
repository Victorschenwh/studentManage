package com.dbsy.student.service.iml;

import com.dbsy.student.annotation.Authority;
import com.dbsy.student.mapper.AdminMapper;
import com.dbsy.student.pojo.Admin;
import com.dbsy.student.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("adminServiceImp")
@Authority({})
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
        return adminMapper.findAdminCount(map);
    }

    @Override
    public int findAssistantCount(Map map) {
        return adminMapper.findAssistantCount(map);
    }

    @Override
    public List<Map> findAssistant(Map map) {
        if (map.get("page") != null) {
            int page = Integer.parseInt(map.get("page") + "");
            int pageSize = Integer.parseInt(map.get("pageSize") + "");
            map.put("start", (page - 1) * pageSize);
            map.put("pageSize", pageSize);
        }
        return adminMapper.findAssistant(map);
    }

    @Override
    public int findDepartLeaderCount(Map map) {
        return adminMapper.findDepartLeaderCount(map);
    }

    @Override
    public List<Map> findDepartLeader(Map map) {
        if (map.get("page") != null) {
            int page = Integer.parseInt(map.get("page") + "");
            int pageSize = Integer.parseInt(map.get("pageSize") + "");
            map.put("start", (page - 1) * pageSize);
            map.put("pageSize", pageSize);
        }
        return adminMapper.findDepartLeader(map);
    }

    @Override
    public int findSchoolLeaderCount(Map map) {
        return adminMapper.findSchoolLeaderCount(map);
    }

    @Override
    public List<Map> findSchoolLeader(Map map) {
        if (map.get("page") != null) {
            int page = Integer.parseInt(map.get("page") + "");
            int pageSize = Integer.parseInt(map.get("pageSize") + "");
            map.put("start", (page - 1) * pageSize);
            map.put("pageSize", pageSize);
        }
        return adminMapper.findSchoolLeader(map);
    }

    @Override
    public int delete(Integer id) {
        return adminMapper.delete(id);
    }

}
