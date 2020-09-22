package com.dbsy.student.service.iml;

import com.dbsy.student.excel.ExcelSave;
import com.dbsy.student.mapper.*;
import com.dbsy.student.pojo.Student;
import com.dbsy.student.pojo.Transfer;
import com.dbsy.student.service.StudentService;
import com.dbsy.student.service.TransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("transferServiceImp")
@CacheConfig(cacheNames = "transfer")
public class TransferServiceImp implements TransferService, ExcelSave {

    @Autowired
    TransferMapper transferMapper;
    @Autowired
    DepartmentMapper departmentMapper;
    @Autowired
    MajorMapper majorMapper;
    @Autowired
    ClazzMapper clazzMapper;
    @Autowired
    StudentMapper studentMapper;

    @Autowired
    StudentService studentService;

//    @Autowired
//    RedisTemplate redisTemplate;

    @Override
    @Transactional
    public int insert(Transfer record) {
        return transferMapper.insert(record);
    }

    @Override
    @Transactional
    public int insert(Map map) {
        String number = map.get("number") + "";
        Student student = studentService.selectByNumber(number);
        Transfer transfer = new Transfer();
        transfer.setOldOutDate(new Date());
        transfer.setStudentId(student.getId());
        transfer.setOldDepartmentId(student.getDepartmentId());
        transfer.setOldMajorId(student.getMajorId());
        transfer.setOldClazzId(student.getClazzId());
        transfer.setNewDepartmentId(Integer.parseInt(map.get("departmentId") + ""));
        transfer.setNewMajorId(Integer.parseInt(map.get("majorId") + ""));
        return transferMapper.insert(transfer);
    }

    @Override
    @Transactional
    public int insertSelective(Transfer record) {
        return transferMapper.insertSelective(record);
    }

    @Override
    public int batchInsert(List list) {
        return transferMapper.batchInsert(list);
    }

    @Override
    public int excelBatchInsert(List list) {
        return transferMapper.batchInsert(list);
    }

    @Override
    public int listCount(Map map) {
        String state = (String) map.get("state");
        if ("已审核".equals(state)) {
            map.put("isPass", "0,1");
            if (map.get("department") != null && !"".equals(map.get("department")))
                map.put("newDepartmentId", Integer.parseInt(map.get("department") + ""));
        } else if ("我的申请".equals(state)) {
            if (map.get("department") != null && !"".equals(map.get("department")))
                map.put("oldDepartmentId", Integer.parseInt(map.get("department") + ""));
            map.put("isPass", null);
        } else if ("待审核".equals(state)) {
            if (map.get("department") != null && !"".equals(map.get("department")))
                map.put("newDepartmentId", Integer.parseInt(map.get("department") + ""));
            map.put("isPass", "null");
        }

        return transferMapper.listCount(map);
    }

    @Override
    public List<Map> list(Map map) {
        int page = Integer.parseInt(map.get("page") + "");
        int pageSize = Integer.parseInt(map.get("pageSize") + "");
        map.put("start", (page - 1) * pageSize);
        map.put("pageSize", pageSize);

        String state = (String) map.get("state");
        if ("已审核".equals(state)) {
            map.put("isPass", "0,1");
            if (map.get("department") != null && !"".equals(map.get("department")))
                map.put("newDepartmentId", Integer.parseInt(map.get("department") + ""));
        } else if ("我的申请".equals(state)) {
            if (map.get("department") != null && !"".equals(map.get("department")))
                map.put("oldDepartmentId", Integer.parseInt(map.get("department") + ""));
            map.put("isPass", null);
        } else if ("待审核".equals(state)) {
            if (map.get("department") != null && !"".equals(map.get("department")))
                map.put("newDepartmentId", Integer.parseInt(map.get("department") + ""));
            map.put("isPass", "null");
        }

        return this.transferMapper.list(map);
    }

    @Override
    @Cacheable(key = "#id", unless = "#result == null")
    public Transfer get(int id) {
        return transferMapper.get(id);
    }

    @Override
    public Map getOpposite(int id) {
        Transfer transfer = this.get(id);
        Map map = new HashMap();
        map.put("newDepartmentId", departmentMapper.get(transfer.getNewDepartmentId()).getName());
        map.put("newMajorId", majorMapper.get(transfer.getNewMajorId()).getName());
        map.put("oldClazzId", clazzMapper.get(transfer.getOldClazzId()).getName());
        map.put("oldDepartmentId", departmentMapper.get(transfer.getOldDepartmentId()).getName());
        map.put("oldMajorId", majorMapper.get(transfer.getOldMajorId()).getName());
        map.put("id", transfer.getId());
        map.put("studentId", studentMapper.get(transfer.getStudentId()).getName());

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        if (transfer.getOldOutDate() != null)
            map.put("oldOutDate", simpleDateFormat.format(transfer.getOldOutDate()));
        if (transfer.getNewInDate() != null)
            map.put("newInDate", simpleDateFormat.format(transfer.getNewInDate()));

        Map map2 = new HashMap();
        map2.put("departmentId", transfer.getNewDepartmentId());
        map2.put("majorId", transfer.getNewMajorId());
        map.put("newClazzId", transfer.getNewClazzId());

        return map;
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

    @Override
    public int updateSelective(Transfer transfer) {
        return transferMapper.updateSelective(transfer);
    }


}
