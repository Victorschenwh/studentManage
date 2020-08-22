package com.dbsy.student.service.iml;

import com.dbsy.student.mapper.RetardationMapper;
import com.dbsy.student.pojo.Retardation;
import com.dbsy.student.service.RetardationService;
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

@Service("retardationServiceImp")
@CacheConfig(cacheNames = "retardation")
public class RetardationServiceImp implements RetardationService {

    @Autowired
    RetardationMapper retardationMapper;

    @Autowired
    RedisTemplate redisTemplate;

    @Override
    @Transactional
    public int insert(Retardation record) {
        return this.retardationMapper.insert(record);
    }

    @Override
    @Transactional
    public int insertSelective(Retardation record) {
        return this.retardationMapper.insertSelective(record);
    }

    @Override
    public int listCount(Map map) {
        return this.retardationMapper.listCount(map);
    }

    @Override
    public List<Retardation> list(Map map) {
        return this.retardationMapper.list(map);
    }

    @Override
    @Cacheable(key = "#id", unless = "#result == null")
    public Retardation get(int id) {
        return this.retardationMapper.get(id);
    }

    @Override
    @Transactional
    @CacheEvict(key = "#id")
    public int delete(int id) {
        return this.retardationMapper.delete(id);
    }

    @Override
    @Transactional
    @CachePut(key = "#retardation.id", unless = "#retardation == null")
    public int update(Retardation retardation) {
        return this.retardationMapper.update(retardation);
    }

    @Override
    public int batchRemove(int[] ids) {
        //清除缓存
        if (ids.length > 0) {
            for (int id : ids) {
                if (redisTemplate.hasKey("retardation::" + id)) {
                    redisTemplate.delete("retardation::" + id);
                }
            }
        }
        return this.retardationMapper.batchRemove(ids);
    }


    @Override
    public List<Retardation> getAll() {
        return this.retardationMapper.getAll();
    }

    @Override
    public List<Retardation> getRetardationByStudentId(int studentId) {
        return this.retardationMapper.getRetardationByStudentId(studentId);
    }

    @Override
    public List<Retardation> getRetardationByOldDepartmentId(int oldDepartmentId) {
        return this.retardationMapper.getRetardationByOldDepartmentId(oldDepartmentId);
    }

    @Override
    public List<Retardation> getRetardationByOldMajorId(int oldMajorId) {
        return this.retardationMapper.getRetardationByOldMajorId(oldMajorId);
    }

    @Override
    public List<Retardation> getRetardationByOldClazzId(int oldClazzId) {
        return this.retardationMapper.getRetardationByOldClazzId(oldClazzId);
    }

    @Override
    public List<Retardation> getRetardationByNewDepartmentId(int newDepartmentId) {
        return this.retardationMapper.getRetardationByNewDepartmentId(newDepartmentId);
    }

    @Override
    public List<Retardation> getRetardationByNewMajorId(int newMajorId) {
        return this.retardationMapper.getRetardationByNewMajorId(newMajorId);
    }

    @Override
    public List<Retardation> getRetardationByNewClazzId(int newClazzId) {
        return this.retardationMapper.getRetardationByNewClazzId(newClazzId);
    }
}
