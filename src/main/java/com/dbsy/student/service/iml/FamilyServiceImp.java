package com.dbsy.student.service.iml;

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
@CacheConfig(cacheNames = "family")
public class FamilyServiceImp implements FamilyService {

    @Autowired
    FamilyMapper familyMapper;

    @Autowired
    RedisTemplate redisTemplate;

    @Override
    @Transactional
    public int insert(Family record) {
        return this.familyMapper.insert(record);
    }

    @Override
    @Transactional
    public int insertSelective(Family record) {
        return this.familyMapper.insertSelective(record);
    }

    @Override
    public int listCount(Map map) {
        return this.familyMapper.listCount(map);
    }

    @Override
    public List<Family> list(Map map) {
        return this.familyMapper.list(map);
    }

    @Override
    @Cacheable(key = "#id", unless = "#result == null")
    public Family get(int id) {
        return this.familyMapper.get(id);
    }

    @Override
    @Transactional
    @CacheEvict(key = "#id")
    public int delete(int id) {
        return this.familyMapper.delete(id);
    }

    @Override
    @Transactional
    @CachePut(key = "#family.id", unless = "#family == null")
    public int update(Family family) {
        return this.familyMapper.update(family);
    }

    @Override
    public int batchRemove(int[] ids) {
        //清除缓存
        if (ids.length > 0) {
            for (int id : ids) {
                if (redisTemplate.hasKey("family::" + id)) {
                    redisTemplate.delete("family::" + id);
                }
            }
        }
        return this.familyMapper.batchRemove(ids);
    }


    @Override
    public List<Family> getAll() {
        return this.familyMapper.getAll();
    }

    @Override
    public List<Family> getFamilyByStudentId(int studentId) {
        return this.familyMapper.getFamilyByStudentId(studentId);
    }
}
