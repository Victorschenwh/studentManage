package com.dbsy.student.service.iml;

import com.dbsy.student.mapper.TransferMapper;
import com.dbsy.student.pojo.Transfer;
import com.dbsy.student.service.TransferService;
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

@Service("transferServiceImp")
@CacheConfig(cacheNames = "transfer")
public class TransferServiceImp implements TransferService {

    @Autowired
    TransferMapper transferMapper;

//    @Autowired
//    RedisTemplate redisTemplate;

    @Override
    @Transactional
    public int insert(Transfer record) {
        return transferMapper.insert(record);
    }

    @Override
    @Transactional
    public int insertSelective(Transfer record) {
        return transferMapper.insertSelective(record);
    }

    @Override
    public int listCount(Map map) {
        return transferMapper.listCount(map);
    }

    @Override
    public List<Transfer> list(Map map) {
        return transferMapper.list(map);
    }

    @Override
    @Cacheable(key = "#id", unless = "#result == null")
    public Transfer get(int id) {
        return transferMapper.get(id);
    }

    @Override
    @Transactional
    @CacheEvict(key = "#id")
    public int delete(int id) {
        return transferMapper.delete(id);
    }

    @Override
    @Transactional
    @CachePut(key = "#transfer.id", unless = "#transfer == null")
    public int update(Transfer transfer) {
        return transferMapper.update(transfer);
    }

    @Override
    public int batchRemove(int[] ids) {
//        //清除缓存
//        if (ids.length > 0) {
//            for (int id : ids) {
//                if (redisTemplate.hasKey("transfer::" + id)) {
//                    redisTemplate.delete("transfer::" + id);
//                }
//            }
//        }
        return transferMapper.batchRemove(ids);
    }


    @Override
    public List<Transfer> getAll() {
        return transferMapper.getAll();
    }

    @Override
    public List<Transfer> getTransferByStudentId(int studentId) {
        return transferMapper.getTransferByStudentId(studentId);
    }

    @Override
    public List<Transfer> getTransferByOldDepartmentId(int oldDepartmentId) {
        return transferMapper.getTransferByOldDepartmentId(oldDepartmentId);
    }

    @Override
    public List<Transfer> getTransferByOldMajorId(int oldMajorId) {
        return transferMapper.getTransferByOldMajorId(oldMajorId);
    }

    @Override
    public List<Transfer> getTransferByOldClazzId(int oldClazzId) {
        return transferMapper.getTransferByOldClazzId(oldClazzId);
    }

    @Override
    public List<Transfer> getTransferByNewDepartmentId(int newDepartmentId) {
        return transferMapper.getTransferByNewDepartmentId(newDepartmentId);
    }

    @Override
    public List<Transfer> getTransferByNewMajorId(int newMajorId) {
        return transferMapper.getTransferByNewMajorId(newMajorId);
    }

    @Override
    public List<Transfer> getTransferByNewClazzId(int newClazzId) {
        return transferMapper.getTransferByNewClazzId(newClazzId);
    }
}
