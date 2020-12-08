package com.dbsy.student.service.iml;

import com.dbsy.student.excel.ExcelSave;
import com.dbsy.student.excel.vo.RewardEo;
import com.dbsy.student.mapper.RewardMapper;
import com.dbsy.student.mapper.SuspensionMapper;
import com.dbsy.student.pojo.Reward;
import com.dbsy.student.pojo.Student;
import com.dbsy.student.service.RewardService;
import com.dbsy.student.util.QueryUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service("rewardServiceImp")
//@CacheConfig(cacheNames = "reward")
public class RewardServiceImp implements RewardService, ExcelSave {

    @Autowired
    RewardMapper rewardMapper;



//    @Autowired
//    RedisTemplate redisTemplate;

    @Override
    @Transactional
    public int insert(Reward record) {
        return rewardMapper.insert(record);
    }

    @Override
    public int batchInsert(List list) {
        return rewardMapper.batchInsert(list);
    }

    @Override
    @Transactional
    public int insertSelective(Reward record) {
        return rewardMapper.insertSelective(record);
    }

    @Override
    public int listCount(Map map) {
        return rewardMapper.listCount(QueryUtil.query(map));
    }


    @Override
    public List<Map> list(Map map) {
        return rewardMapper.list(QueryUtil.query(map));
    }

    @Override
    //   @Cacheable(key = "#id", unless = "#result == null")
    public Reward get(int id) {
        return rewardMapper.get(id);
    }

    @Override
    public int excelBatchInsert(List list) {
        return rewardMapper.batchInsert(list);
    }

    @Override
    @Transactional
//    @CacheEvict(key = "#id")
    public int delete(int id) {
        return rewardMapper.delete(id);
    }

    @Override
    public int addSingle(Map map) {
        try{
            return this.rewardMapper.addSingle(map);
        }catch (Exception e){

            e.printStackTrace();
        }
        return -1;
    }

    @Override
    @Transactional
//    @CachePut(key = "#reward.id", unless = "#reward == null")
    public int update(Reward reward) {
        return rewardMapper.update(reward);
    }

    @Override
    public int batchRemove(int[] ids) {

        return rewardMapper.batchRemove(ids);
    }


    @Override
    public List<Reward> getAll() {
        return rewardMapper.getAll();
    }

    @Override
    public List<Reward> getRewardByStudentId(int studentId) {
        return rewardMapper.getRewardByStudentId(studentId);
    }

    @Override
    public List<Reward> getRewardsByStudentIdAndStudyTerm(int studentId, int studyTerm) {
        return rewardMapper.getRewardsByStudentIdAndStudyTerm(studentId, studyTerm);
    }

    @Override
    public List<RewardEo> listExport(Map map) {
        return rewardMapper.listExport(QueryUtil.query(map));
    }
}
