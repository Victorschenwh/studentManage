package com.dbsy.student.service.iml;

import com.dbsy.student.excel.ExcelSave;
import com.dbsy.student.mapper.StudentMapper;
import com.dbsy.student.pojo.Student;
import com.dbsy.student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("studentServiceImp")
public class StudentServiceImp implements StudentService, ExcelSave {
    @Autowired
    StudentMapper studentMapper;

    @Override
    public int insert(Student record) {
        return studentMapper.insert(record);
    }

    @Override
    public int insertSelective(Student record) {
        return studentMapper.insertSelective(record);
    }

    @Override
    public int batchInsert(List<Student> list) {
        return studentMapper.batchInsert(list);
    }

    @Override
    public Student get(int id) {
        return studentMapper.get(id);
    }

    @Override
    public int listCount(Map map) {
        return studentMapper.listCount(map);
    }

    @Override
    public List<Student> list(Map map) {
        int page = Integer.parseInt(map.get("page") + "");
        int pageSize = Integer.parseInt(map.get("pageSize") + "");
        map.put("start", (page - 1) * pageSize);
        map.put("end", pageSize);
        return studentMapper.list(map);
    }

    @Override
    public int delete(int id) {
        return studentMapper.delete(id);
    }

    @Override
    public int batchRemove(int[] ids) {
        return studentMapper.batchRemove(ids);
    }

    @Override
    public int excelBatchInsert(List list) {
        return studentMapper.batchInsert(list);
    }
}
