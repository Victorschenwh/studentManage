package com.dbsy.student.service.iml;

import com.dbsy.student.mapper.TitleMapper;
import com.dbsy.student.pojo.Title;
import com.dbsy.student.service.TitleService;
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

@Service("titleServiceImp")
@CacheConfig(cacheNames = "title")
public class TitleServiceImp implements TitleService {
    @Autowired
    TitleMapper titleMapper;

    @Autowired
    RedisTemplate redisTemplate;

    @Override
    @Transactional
    public int insert(Title record) {
        return titleMapper.insert(record);
    }

    @Override
    @Transactional
    public int insertSelective(Title record) {
        return titleMapper.insertSelective(record);
    }

    @Override
    public int listCount(Map map) {
        return titleMapper.listCount(map);
    }

    @Override
    public List<Title> list(Map map) {
        return titleMapper.list(map);
    }

    @Override
    @Cacheable(key = "#id", unless = "#result == null")
    public Title get(int id) {
        return titleMapper.get(id);
    }

    @Override
    @Transactional
    @CacheEvict(key = "#id")
    public int delete(int id) {
        return titleMapper.delete(id);
    }

    @Override
    @Transactional
    @CachePut(key = "#title.id", unless = "#title == null")
    public int update(Title title) {
        return titleMapper.update(title);
    }

    @Override
    @Transactional
    public int batchRemove(int[] ids) {
        if (ids.length > 0) {
            for (int id : ids) {
                if (redisTemplate.hasKey("title::" + id)) {
                    redisTemplate.delete("title::" + id);
                }
            }
        }
        return titleMapper.batchRemove(ids);
    }

    @Override
    public List<Title> getAll() {
        return titleMapper.getAll();
    }
}
