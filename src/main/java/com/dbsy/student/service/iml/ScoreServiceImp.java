package com.dbsy.student.service.iml;

import com.dbsy.student.excel.ExcelSave;
import com.dbsy.student.mapper.FamilyMapper;
import com.dbsy.student.mapper.ScoreMapper;
import com.dbsy.student.pojo.Family;
import com.dbsy.student.pojo.Score;
import com.dbsy.student.pojo.Student;
import com.dbsy.student.service.FamilyService;
import com.dbsy.student.service.ScoreService;
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

@Service("scoreServiceImp")
@CacheConfig(cacheNames = "score")
public class ScoreServiceImp implements ScoreService, ExcelSave {

    @Autowired
    ScoreMapper scoreMapper;

    @Autowired
    RedisTemplate redisTemplate;

    @Override
    @Transactional
    public int insert(Score record) {
        return this.scoreMapper.insert(record);
    }

    @Override
    public int batchInsert(List<Score> list) {
        return scoreMapper.batchInsert(list);
    }

    @Override
    @Transactional
    public int insertSelective(Score record) {
        return this.scoreMapper.insertSelective(record);
    }

    @Override
    public int listCount(Map map) {
        return this.scoreMapper.listCount(map);
    }

    @Override
    public List<Score> list(Map map) {
        return this.scoreMapper.list(map);
    }

    @Override
    @Cacheable(key = "#id", unless = "#result == null")
    public Score get(int id) {
        return this.scoreMapper.get(id);
    }

    @Override
    public int excelBatchInsert(List list) {
        return scoreMapper.batchInsert(list);
    }

    @Override
    @Transactional
    @CacheEvict(key = "#id")
    public int delete(int id) {
        return this.scoreMapper.delete(id);
    }

    @Override
    @Transactional
    @CachePut(key = "#score.id", unless = "#score == null")
    public int update(Score score) {
        return this.scoreMapper.update(score);
    }

    @Override
    public int batchRemove(int[] ids) {
        //清除缓存
        if (ids.length > 0) {
            for (int id : ids) {
                if (redisTemplate.hasKey("score::" + id)) {
                    redisTemplate.delete("score::" + id);
                }
            }
        }
        return this.scoreMapper.batchRemove(ids);
    }


    @Override
    public List<Score> getAll() {
        return this.scoreMapper.getAll();
    }

    @Override
    public List<Score> getScoreByStudentId(int studentId) {

        return this.scoreMapper.getScoreByStudentId(studentId);
    }
}
