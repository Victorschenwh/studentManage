package com.dbsy.student.vo;

import com.dbsy.student.mapper.EmploymentMapper;
import com.dbsy.student.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IndexVoService {
    @Autowired
    StudentMapper studentMapper;

    @Autowired
    EmploymentMapper employmentMapper;

    public IndexVo indexVo() {
        IndexVo indexVo = new IndexVo();
        indexVo.setPeopleNumber(studentMapper.selectAllStudentsCount());
        indexVo.setCet4(studentMapper.selectPassCET4CountGroupByDepartment());
        indexVo.setCet6(studentMapper.selectPassCET6CountGroupByDepartment());
        indexVo.setNation(studentMapper.selectGroupByNation());
        indexVo.setEmploy(employmentMapper.selectGroupByTo());
        return indexVo;
    }
}
