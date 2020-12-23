package com.dbsy.student.service.iml;

import com.dbsy.student.excel.ExcelSave;
import com.dbsy.student.excel.vo.EmploymentEo;
import com.dbsy.student.mapper.EmploymentMapper;
import com.dbsy.student.pojo.Employment;
import com.dbsy.student.pojo.Student;
import com.dbsy.student.service.EmploymentService;
import com.dbsy.student.util.QueryUtil;
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
    public int batchInsert(List<Employment> list) {

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
        return employmentMapper.listCount(QueryUtil.query(map));
    }

    @Override
    public List<Employment> list(Map map) {
        return employmentMapper.list(QueryUtil.query(map));
    }

    @Override
    public int addSingle(Map map) {
        try {
            return this.employmentMapper.addSingle(map);
        } catch (Exception e) {

            e.printStackTrace();
        }
        return -1;
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
    public int update(Employment employment) {
        return employmentMapper.update(employment);
    }

    @Override
    public List<EmploymentEo> listExport(Map map) {
        return this.employmentMapper.listExport(QueryUtil.query(map));
    }

    @Override
    public int excelBatchInsert(List list) {
        System.out.println(list);
        return this.batchInsert(list);
    }
}
