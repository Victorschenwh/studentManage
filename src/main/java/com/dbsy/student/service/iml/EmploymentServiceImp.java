package com.dbsy.student.service.iml;

import com.dbsy.student.excel.ExcelSave;
import com.dbsy.student.mapper.EmploymentMapper;
import com.dbsy.student.pojo.Employment;
import com.dbsy.student.pojo.Student;
import com.dbsy.student.service.EmploymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("employmentServiceImp")
public class EmploymentServiceImp implements EmploymentService, ExcelSave {
    @Autowired
    EmploymentMapper employmentMapper;

    @Override
    public int insert(Employment record) {
        return employmentMapper.insert(record);
    }

    @Override
    public int insertSelective(Employment record) {
        return employmentMapper.insertSelective(record);
    }

    @Override
    public int batchInsert(List<Student> list) {
        return employmentMapper.batchInsert(list);
    }

    @Override
    public Employment get(int id) {
        return employmentMapper.get(id);
    }

    @Override
    public Employment getByStudentId(int studentId) {
        return employmentMapper.getByStudentId(studentId);
    }

    @Override
    public int listCount(Map map) {
        return employmentMapper.listCount(map);
    }

    @Override
    public List<Employment> list(Map map) {
        int page = Integer.parseInt(map.get("page") + "");
        int pageSize = Integer.parseInt(map.get("pageSize") + "");
        map.put("start", (page - 1) * pageSize);
        map.put("end", pageSize);
        return employmentMapper.list(map);
    }

    @Override
    public int delete(int id) {
        return employmentMapper.delete(id);
    }

    @Override
    public int batchRemove(int[] ids) {
        return employmentMapper.batchRemove(ids);
    }

    @Override
    public int excelBatchInsert(List list) {
        return employmentMapper.batchInsert(list);
    }
}
