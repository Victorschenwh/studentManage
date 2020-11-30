package com.dbsy.student.service.iml;

import com.dbsy.student.excel.ExcelSave;
import com.dbsy.student.mapper.AdminMapper;
import com.dbsy.student.mapper.TeacherMapper;
import com.dbsy.student.pojo.Admin;
import com.dbsy.student.pojo.Teacher;
import com.dbsy.student.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service("teacherServiceImp")
@CacheConfig(cacheNames = "teacher")
public class TeacherServiceImp implements TeacherService, ExcelSave {
    @Autowired
    TeacherMapper teacherMapper;

    @Autowired
    AdminMapper adminMapper;

    @Autowired
    RedisTemplate redisTemplate;


    @Override
    public Teacher selectByUsername(String username) {
        return teacherMapper.selectByUsername(username);
    }

    @Override
    @Transactional
    public int insert(Teacher record) {
        return teacherMapper.insert(record);
    }

    @Override
    @Transactional
    public int insertSelective(Teacher record) {
        return teacherMapper.insertSelective(record);
    }

    @Override
    public int listCount(Map map) {
        return teacherMapper.listCount(map);
    }

    @Override
    public List<Teacher> list(Map map) {
        return teacherMapper.list(map);
    }

    @Override
    @Cacheable(key = "#id", unless = "#result == null")
    public Teacher get(int id) {
        return teacherMapper.get(id);
    }

    @Override
    @Transactional
    @CacheEvict(key = "#id")
    public int delete(int id) {
        return teacherMapper.delete(id);
    }

    @Override
    @Transactional
    @CachePut(key = "#teacher.id", unless = "#teacher == null")
    public int update(Teacher teacher) {
        return teacherMapper.update(teacher);
    }

    @Override
    @Transactional
    public int batchRemove(int[] ids) {
        if (ids.length > 0) {
            for (int id : ids) {
                if (redisTemplate.hasKey("teacher::" + id)) {
                    redisTemplate.delete("teacher::" + id);
                }
            }
        }
        return teacherMapper.batchRemove(ids);
    }

    @Override
    public List<Teacher> getAll() {
        return teacherMapper.getAll();
    }

    @Override
    public Teacher selectByUsernameAndPassword(String username, String password) {
        return teacherMapper.selectByUsernameAndPassword(username, password);
    }

    @Override
    public Teacher selectByEmail(String email) {
        return teacherMapper.selectByEmail(email);
    }

    @Override
    public int changePWByUsername(Teacher teacher) {
        return this.teacherMapper.changePWByUsername(teacher);
    }

    @Override
    public int excelBatchInsert(List list) {
        if (list != null && list.size() > 0)
            for (Object obj : list) {
                Teacher teacher = (Teacher) obj;
                if (teacherMapper.selectByUsername(teacher.getUsername()) == null) {
                    teacherMapper.insert(teacher);
                    adminMapper.insert(Admin.teacher(teacher));
                }

            }
        return list.size();
    }
}
