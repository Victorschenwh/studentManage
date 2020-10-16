package com.dbsy.student.service.iml;

import com.dbsy.student.excel.ExcelSave;
import com.dbsy.student.mapper.DepartmentMapper;
import com.dbsy.student.pojo.Department;
import com.dbsy.student.service.DepartmentService;
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

@Service("departmentServiceImp")
@CacheConfig(cacheNames = "department")
public class DepartmentServiceImp implements DepartmentService, ExcelSave {
    @Autowired
    DepartmentMapper departmentMapper;

    private static String table = "department";

    @Autowired
    RedisTemplate redisTemplate;

    @Override
    @Transactional
    public int insert(Department record) {
        departmentMapper.insert(record);
        return record.getId();
    }

    @Override
    @Transactional
    public int insertSelective(Department record) {
        departmentMapper.insertSelective(record);
        return record.getId();
    }

    @Override
    public int listCount(Map map) {
        return departmentMapper.listCount(map);
    }

    @Override
    public List<Department> list(Map map) {
        return departmentMapper.list(map);
    }

    @Override
    @Cacheable(key = "#id", unless = "#result == null")
    public Department get(int id) {
        return departmentMapper.get(id);
    }

    @Override
    @Transactional
    @CacheEvict(key = "#id")
    public int delete(int id) {
        return departmentMapper.delete(id);
    }

    @Override
    @Transactional
    @CachePut(key = "#department.id", unless = "#department == null")
    public int update(Department department) {
        return departmentMapper.update(department);
    }

    @Override
    @Transactional
    public int batchRemove(int[] ids) {
        //清除缓存
        if (ids.length > 0) {
            for (int id : ids) {
                if (redisTemplate.hasKey("department::" + id)) {
                    redisTemplate.delete("department::" + id);
                }
            }
        }
        return departmentMapper.batchRemove(ids);
    }

    @Override
    public List<Department> getAll() {
        return departmentMapper.getAll();
    }

    @Override
    public Department getByName(String name) {
        return departmentMapper.getByName(name);
    }

    @Override
    public int excelBatchInsert(List list) {
        return 0;
    }
}
