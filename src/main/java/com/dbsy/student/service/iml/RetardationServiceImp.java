package com.dbsy.student.service.iml;

import com.dbsy.student.excel.ExcelSave;
import com.dbsy.student.mapper.*;
import com.dbsy.student.pojo.Retardation;
import com.dbsy.student.pojo.Transfer;
import com.dbsy.student.service.RetardationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("retardationServiceImp")
@CacheConfig(cacheNames = "retardation")
public class RetardationServiceImp implements RetardationService, ExcelSave {

    @Autowired
    RetardationMapper retardationMapper;
    @Autowired
    DepartmentMapper departmentMapper;
    @Autowired
    MajorMapper majorMapper;
    @Autowired
    ClazzMapper clazzMapper;
    @Autowired
    StudentMapper studentMapper;

    //@Autowired
    //RedisTemplate redisTemplate;

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
    public int batchInsert(List list) {
        return retardationMapper.batchInsert(list);
    }

    @Override
    public int excelBatchInsert(List list) {
        return retardationMapper.batchInsert(list);
    }

    @Override
    public int listCount(Map map) {
        return this.retardationMapper.listCount(map);
    }

    @Override
    public List<Map> list(Map map) {
        if (map.get("page") != null) {
            int page = Integer.parseInt(map.get("page") + "");
            int pageSize = Integer.parseInt(map.get("pageSize") + "");
            map.put("start", (page - 1) * pageSize);
            map.put("end", pageSize);
        }

        return this.retardationMapper.list(map);
    }

    @Override
    @Cacheable(key = "#id", unless = "#result == null")
    public Retardation get(int id) {
        return this.retardationMapper.get(id);
    }

    @Override
    public Map getOpposite(int id) {
        Retardation retardation = this.get(id);
        Map map = new HashMap();
        map.put("newDepartmentId", departmentMapper.get(retardation.getNewDepartmentId()).getName());
        map.put("newMajorId", majorMapper.get(retardation.getNewMajorId()).getName());
        map.put("oldClazzId", clazzMapper.get(retardation.getOldClazzId()).getName());
        map.put("oldDepartmentId", departmentMapper.get(retardation.getOldDepartmentId()).getName());
        map.put("oldMajorId", majorMapper.get(retardation.getOldMajorId()).getName());
        map.put("id", retardation.getId());
        map.put("studentId", studentMapper.get(retardation.getStudentId()).getName());

//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
//        if (retardation.getOldOutDate() != null)
//            map.put("oldOutDate", simpleDateFormat.format(retardation.getOldOutDate()));
//        if (retardation.getNewInDate() != null)
//            map.put("newInDate", simpleDateFormat.format(retardation.getNewInDate()));
//        Map map2 = new HashMap();
//        map2.put("departmentId", retardation.getNewDepartmentId());
//        map2.put("majorId", retardation.getNewMajorId());
//        map.put("newClazzId", clazzMapper.getByFOREIGN_KEY(map2));

        return map;
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
//        if (ids.length > 0) {
//            for (int id : ids) {
//                if (redisTemplate.hasKey("retardation::" + id)) {
//                    redisTemplate.delete("retardation::" + id);
//                }
//            }
//        }
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

    @Override
    public int updateSelective(Retardation retardation) {
        return retardationMapper.updateSelective(retardation);
    }

}
