package com.dbsy.student.service.iml;

import com.dbsy.student.excel.ExcelSave;
import com.dbsy.student.mapper.FamilyMapper;
import com.dbsy.student.pojo.Family;
import com.dbsy.student.service.FamilyService;
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

@Service("familyServiceImp")
//@CacheConfig(cacheNames = "family")
public class FamilyServiceImp implements FamilyService, ExcelSave {

    @Autowired
    FamilyMapper familyMapper;

//    @Autowired
//    RedisTemplate redisTemplate;

    @Override
    @Transactional
    public int insert(Family record) {
        return familyMapper.insert(record);
    }

    @Override
    @Transactional
    public int insertSelective(Family record) {
        return familyMapper.insertSelective(record);
    }

    @Override
    public int listCount(Map map) {
        return familyMapper.listCount(map);
    }

    @Override
    public List<Family> list(Map map) {
        return familyMapper.list(map);
    }

    @Override
//    @Cacheable(key = "#id", unless = "#result == null")
    public Family get(int id) {
        return familyMapper.get(id);
    }

    @Override
    @Transactional
//    @CacheEvict(key = "#id")
    public int delete(int id) {
        return familyMapper.delete(id);
    }

    @Override
    @Transactional
//    @CachePut(key = "#family.id", unless = "#family == null")
    public int update(Family family) {
        return familyMapper.update(family);
    }

    @Override
    public int batchRemove(int[] ids) {

        return familyMapper.batchRemove(ids);
    }


    @Override
    public List<Family> getAll() {
        return familyMapper.getAll();
    }

    @Override
    public List<Family> getFamilyByStudentId(int studentId) {
        return familyMapper.getFamilyByStudentId(studentId);
    }

    @Override
    public int batchInsert(List list) {
        return familyMapper.batchInsert(list);
    }

    @Override
    public int excelBatchInsert(List list) {
        return familyMapper.batchInsert(list);
    }
}
