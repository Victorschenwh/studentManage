package com.dbsy.student.service.iml;

import com.dbsy.student.excel.ExcelSave;
import com.dbsy.student.mapper.*;
import com.dbsy.student.pojo.Retardation;
import com.dbsy.student.pojo.Student;
import com.dbsy.student.pojo.Transfer;
import com.dbsy.student.service.RetardationService;
import com.dbsy.student.util.QueryUtil;
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

//        return this.retardationMapper.list(QueryUtil.query(map));
    }


    @Override
    public List<Student> listStu(Map map) {

        if (map.get("page") != null) {
            int page = Integer.parseInt(map.get("page") + "");
            int pageSize = Integer.parseInt(map.get("pageSize") + "");
            map.put("start", (page - 1) * pageSize);
            map.put("end", pageSize);
        }
        return this.retardationMapper.listStu(map);
    }

    @Override
    public int listCountStu(Map map) {
        return this.retardationMapper.listCountStu(map);
    }

    @Override
    public List<Map> listDropSchool(Map map) {
        return null;
    }

    @Override
    public int listCountDrop(Map map) {
        return 0;
    }

    @Override
//    @Cacheable(key = "#id", unless = "#result == null")
    public Map getSelf(int id) {
        return this.retardationMapper.getSelf(id);
    }

    @Override
    public List<Map> listClName(int stuId) {
        return this.retardationMapper.listClName(stuId);
    }

    @Override
    public List<Map> listGrade() {
        return this.retardationMapper.listGrade();
    }

    @Override
    public int updateLogic(Retardation retardation) {

        this.retardationMapper.updateLogic(retardation);

        return this.retardationMapper.updateLogicStu(retardation);

    }



    @Override
    public List<Map> list3(Map map) {

        if (map.get("page") != null) {
            int page = Integer.parseInt(map.get("page") + "");
            int pageSize = Integer.parseInt(map.get("pageSize") + "");
            map.put("start", (page - 1) * pageSize);
            map.put("end", pageSize);
        }

        return this.retardationMapper.list3(map);
    }

    @Override
    public int listCount3(Map map) {
        return this.retardationMapper.listCount3(map);
    }

    @Override
//    @Cacheable(key = "#id", unless = "#result == null")
    public Retardation get(int id) {
        return this.retardationMapper.get(id);
    }

    @Override
    public Map getOpposite(int id) {

        Retardation retardation = this.get(id);
        System.out.println("retardation = " + retardation);
        Map map = new HashMap();

        if(retardation.getNewClazzId() != null){
            map.put("newClazzId", clazzMapper.get(retardation.getNewClazzId()).getName());
        }

        map.put("newGrader", retardation.getNewGrader());
        map.put("oldClazzId", clazzMapper.get(retardation.getOldClazzId()).getName());
        map.put("oldDepartmentId", departmentMapper.get(retardation.getOldDepartmentId()).getName());
        map.put("oldMajorId", majorMapper.get(retardation.getOldMajorId()).getName());
        map.put("id", retardation.getId());
        map.put("studentId", retardation.getStudentId());
        map.put("name", studentMapper.get(retardation.getStudentId()).getName());
        map.put("oldGrader",studentMapper.get(retardation.getStudentId()).getGrade());
        map.put("saveDate",retardation.getSaveDate());
        map.put("remarks",retardation.getRemarks());


        return map;
    }

    @Override
    @Transactional
    @CacheEvict(key = "#id")
    public int delete(int id) {
        Integer studentId = retardationMapper.get(id).getStudentId();
        retardationMapper.updateLogicStu3(studentId);
        return this.retardationMapper.delete(id);
    }

    @Override
    @Transactional
    @CachePut(key = "#retardation.id", unless = "#retardation == null")
    public int update(Retardation retardation) {
        return this.retardationMapper.update(retardation);
    }

    @Override
    public int updateLast(Retardation retardation) {

        this.retardationMapper.updateLast(retardation);

        return this.retardationMapper.updateLast_stu_grade(retardation);
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
