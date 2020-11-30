package com.dbsy.student.vo;

import com.dbsy.student.service.ScoreService;
import com.dbsy.student.service.iml.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfileVoService {

    @Autowired
    StudentServiceImp studentServiceImp;
    @Autowired
    DepartmentServiceImp departmentServiceImp;
    @Autowired
    FamilyServiceImp familyServiceImp;
    @Autowired
    MajorServiceImp majorServiceImp;

    @Autowired
    ClazzServiceImp clazzServiceImp;

    @Autowired
    RewardServiceImp rewardServiceImp;

    @Autowired
    ScoreService scoreService;

    public ProfileVo get(int id) {
        ProfileVo exportStudentInfo = new ProfileVo();
        exportStudentInfo.student = studentServiceImp.get(id);
        exportStudentInfo.department = departmentServiceImp.get(exportStudentInfo.student.getDepartmentId());
        exportStudentInfo.major = majorServiceImp.get(exportStudentInfo.student.getMajorId());
        exportStudentInfo.clazz = clazzServiceImp.get(exportStudentInfo.student.getClazzId());
        exportStudentInfo.families = familyServiceImp.getFamilyByStudentId(id);
        exportStudentInfo.rewards = rewardServiceImp.getRewardByStudentId(id);
        exportStudentInfo.score = scoreService.studentScore(id);
        exportStudentInfo.total = scoreService.studentTotal(id);
        exportStudentInfo.fail = scoreService.fail(id);
        return exportStudentInfo;
    }
}
