package com.dbsy.student.service.iml;

import com.dbsy.student.excel.ExcelSave;
import com.dbsy.student.mapper.ScoreMapper;
import com.dbsy.student.pojo.Score;
import com.dbsy.student.service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service("scoreServiceImp")
//@CacheConfig(cacheNames = "score")
public class ScoreServiceImp implements ScoreService, ExcelSave {

    @Autowired
    ScoreMapper scoreMapper;

//    @Autowired
//    RedisTemplate redisTemplate;

    @Override
    @Transactional
    public int insert(Score record) {
        Score score = scoreMapper.getByStudentIdCourseIdAndStudyTerm(record.getStudentId(), record.getCourseId(), record.getStudyTerm());
        if (score == null)
            return scoreMapper.insert(record);
        return 0;
    }

    @Override
    public int batchInsert(List list) {
        return scoreMapper.batchInsert(list);
    }

    @Override
    @Transactional
    public int insertSelective(Score record) {
        return scoreMapper.insertSelective(record);
    }

    /**
     * score.html 服务器分页
     *
     * @param map
     * @return
     */
    @Override
    public List<Map> listRank(Map map) {
        if (map.get("page") != null) {
            int page = Integer.parseInt(map.get("page") + "");
            int pageSize = Integer.parseInt(map.get("pageSize") + "");
            map.put("start", (page - 1) * pageSize);
            map.put("pageSize", pageSize);
        }
        return scoreMapper.listRank(map);
    }

    /**
     * total.html客户端分页
     *
     * @param map
     * @return
     */
    @Override
    public List<Map> listTotal(Map map) {
        if (map.get("page") != null) {
            int page = Integer.parseInt(map.get("page") + "");
            int pageSize = Integer.parseInt(map.get("pageSize") + "");
            map.put("start", (page - 1) * pageSize);
            map.put("pageSize", pageSize);
        }
        return scoreMapper.listTotal(map);
    }

    @Override
//    @Cacheable(key = "#id", unless = "#result == null")
    public Score get(int id) {
        return scoreMapper.get(id);
    }

    @Override
    public int excelBatchInsert(List list) {
        return scoreMapper.batchInsert(list);
    }

    @Override
    @Transactional
    //   @CacheEvict(key = "#id")
    public int delete(int id) {
        return scoreMapper.delete(id);
    }

    @Override
    @Transactional
//    @CachePut(key = "#score.id", unless = "#score == null")
    public int update(Score score) {
        return scoreMapper.update(score);
    }

    @Override
    public int batchRemove(int[] ids) {

        return scoreMapper.batchRemove(ids);
    }


    @Override
    public List<Score> getAll() {
        return scoreMapper.getAll();
    }

    @Override
    public List<Score> getScoreByStudentId(int studentId) {

        return scoreMapper.getScoreByStudentId(studentId);
    }

    @Override
    public int countRank(Map map) {
        return this.scoreMapper.countRank(map);
    }

    @Override
    public int countTotal(Map map) {
        return this.scoreMapper.countTotal(map);
    }

    @Override
    public List<Map> studentScore(int id) {
        return scoreMapper.studentScore(id);
    }

    @Override
    public List<Map> studentTotal(int id) {
        return scoreMapper.studentTotal(id);
    }

    @Override
    public int fail(int id) {
        return scoreMapper.fail(id);
    }

    @Override
    public List<Map> preWarming(Map map) {
        if (map.get("page") != null) {
            int page = Integer.parseInt(map.get("page") + "");
            int pageSize = Integer.parseInt(map.get("pageSize") + "");
            map.put("start", (page - 1) * pageSize);
            map.put("pageSize", pageSize);
        }
        return scoreMapper.preWarming(map);
    }

    @Override
    public int preWarmingCount(Map map) {
        return scoreMapper.preWarmingCount(map);
    }


}
