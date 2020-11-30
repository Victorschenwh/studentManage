package com.dbsy.student.service.iml;

import com.dbsy.student.excel.ExcelSave;
import com.dbsy.student.mapper.StudentMapper;
import com.dbsy.student.pojo.Student;
import com.dbsy.student.service.StudentService;
import com.dbsy.student.util.QueryUtil;
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
        studentMapper.insert(record);
        return record.getId();
    }

    @Override
    public int insertSelective(Student record) {
        Student student = studentMapper.selectByNumber(record.getNumber());
        if (student == null)
            return studentMapper.insertSelective(record);
        else
            record.setId(student.getId());
        return 0;
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
    public Map getSelf(int id) {
        return this.studentMapper.getSelf(id);
    }

    @Override
    public int listCount(Map map) {
        return studentMapper.listCount(QueryUtil.query(map));
    }

    @Override
    public List<Student> list(Map map) {
        return studentMapper.list(QueryUtil.query(map));
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
    public Student selectByNumber(String number) {
        return studentMapper.selectByNumber(number);
    }

    @Override
    public int update(Student student) {
        return studentMapper.update(student);
    }

    @Override
    public int getMajorCountByMajorId(int majorId) {
        return this.studentMapper.getMajorCountByMajorId(majorId);
    }

    @Override
    public int excelBatchInsert(List list) {
        return studentMapper.batchInsert(list);
    }
}
