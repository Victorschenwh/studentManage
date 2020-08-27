package com.dbsy.student.service.iml;

import com.dbsy.student.excel.ExcelSave;
import com.dbsy.student.mapper.SuspensionMapper;
import com.dbsy.student.pojo.Suspension;
import com.dbsy.student.service.SuspensionService;
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

@Service("SuspensionServiceImp")
//@CacheConfig(cacheNames = "suspension")
public class SuspensionServiceImp implements SuspensionService, ExcelSave {
    @Autowired
    SuspensionMapper suspensionMapper;

//    @Autowired
//    RedisTemplate redisTemplate;

    @Override
    @Transactional
    public int insert(Suspension record) {
        return suspensionMapper.insert(record);
    }

    @Override
    @Transactional
    public int insertSelective(Suspension record) {
        return suspensionMapper.insertSelective(record);
    }

    @Override
    public int listCount(Map map) {
        return suspensionMapper.listCount(map);
    }

    @Override
    public List<Suspension> list(Map map) {
        return suspensionMapper.list(map);
    }

    @Override
//    @Cacheable(key = "#id", unless = "#result == null")
    public Suspension get(int id) {
        return suspensionMapper.get(id);
    }

    @Override
    @Transactional
//    @CacheEvict(key = "#id")
    public int delete(int id) {
        return suspensionMapper.delete(id);
    }

    @Override
    @Transactional
//    @CachePut(key = "#suspension.id", unless = "#suspension == null")
    public int update(Suspension suspension) {
        return suspensionMapper.update(suspension);
    }

    @Override
    public int batchRemove(int[] ids) {

        return suspensionMapper.batchRemove(ids);
    }


    @Override
    public List<Suspension> getAll() {
        return getAll();
    }

    @Override
    public List<Suspension> getSuspensionByStudentId(int studentId) {
        return suspensionMapper.getSuspensionByStudentId(studentId);
    }

    @Override
    public int batchInsert(List list) {
        return suspensionMapper.batchInsert(list);
    }


    @Override
    public int excelBatchInsert(List list) {
        return suspensionMapper.batchInsert(list);
    }
}
