package com.dbsy.student.excel.vo;

import com.dbsy.student.excel.ExcelSave;
import com.dbsy.student.excel.vo.StudentIo;
import com.dbsy.student.pojo.*;
import com.dbsy.student.service.iml.*;
import com.dbsy.student.util.PinYinUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentIoService implements ExcelSave {
    @Autowired
    FamilyServiceImp familyServiceImp;

    @Autowired
    StudentServiceImp studentServiceImp;

    @Autowired
    DepartmentServiceImp departmentServiceImp;

    @Autowired
    MajorServiceImp majorServiceImp;

    @Autowired
    ClazzServiceImp clazzServiceImp;

    @Autowired
    AdminServiceImp adminServiceImp;

    @Override
    public int excelBatchInsert(List list) {
        if (list != null && list.size() > 0) {
            for (Object o : list) {
                StudentIo importStudentInfo = (StudentIo) o;
                Department department = departmentServiceImp.getByName(importStudentInfo.getDepartment());
                if (department == null) {
                    department = new Department();
                    department.setName(importStudentInfo.getDepartment());
                    department.setIntroduce(importStudentInfo.getDeSys());
                    departmentServiceImp.insert(department);
                }

                Major major = majorServiceImp.getByName(importStudentInfo.getMajor());
                if (major == null) {
                    major = new Major();
                    major.setName(importStudentInfo.getMajor());
                    major.setIntroduce(importStudentInfo.getmSys());
                    major.setDepartmentId(department.getId());
                    majorServiceImp.insert(major);
                }


                Clazz clazz = clazzServiceImp.getByName(importStudentInfo.getMajor());
                if (clazz == null) {
                    clazz = new Clazz();
                    clazz.setName(importStudentInfo.getClazz());
                    clazz.setDepartmentId(department.getId());
                    clazz.setMajorId(major.getId());
                    clazz.setGrade(importStudentInfo.getGrade());
                    clazzServiceImp.insert(clazz);
                }

                Student student = studentServiceImp.selectByNumber(importStudentInfo.getNumber());
                if (student == null) {
                    student = new Student(null, importStudentInfo.getNumber(), importStudentInfo.getName(), importStudentInfo.getGender(),
                            importStudentInfo.getPhoneNumber(), importStudentInfo.getEmail(), importStudentInfo.getIdCard(),
                            importStudentInfo.getNativePlace(), null, importStudentInfo.getAdmissionDate(), importStudentInfo.getBirthday(),
                            null, importStudentInfo.getScore(), clazz.getId(), major.getId(), department.getId(), clazz.getGrade(),
                            importStudentInfo.getAge(), importStudentInfo.getNation(), importStudentInfo.getAddress(), importStudentInfo.getRoom(),
                            importStudentInfo.getStatus());
                    student.setAbbrName(PinYinUtil.chineseToPinyin(student.getName().replaceAll("·", "").replaceAll("•", ""))
                            + PinYinUtil.toFirstChar(student.getName().replaceAll("·", "").replaceAll("•", "")));
                    student.setCet4(importStudentInfo.getCet4());
                    student.setCet6(importStudentInfo.getCet6());
                    student.setIsdel(importStudentInfo.getIsDel());
                    studentServiceImp.insert(student);
                    adminServiceImp.insert(Admin.student(student));
                }

                // List<Family> families = familyServiceImp.getFamilyByStudentId(student.getId());
                if (importStudentInfo.getF1Name() != null && !"".equals(importStudentInfo.getF1Name().trim())) {
                    Family family1 = new Family();
                    family1.setName(importStudentInfo.getF1Name().trim());
                    family1.setAge(importStudentInfo.getF1Age());
                    family1.setWork(importStudentInfo.getF1Work());
                    family1.setPhoneNumber(importStudentInfo.getF1Phone());
                    family1.setRelationship(importStudentInfo.getF1Relationship());
                    family1.setStudentId(student.getId());
                    familyServiceImp.insert(family1);
                }
                if (importStudentInfo.getF2Name() != null && !"".equals(importStudentInfo.getF2Name().trim())) {
                    Family family2 = new Family();
                    family2.setName(importStudentInfo.getF2Name().trim());
                    family2.setAge(importStudentInfo.getF2Age());
                    family2.setWork(importStudentInfo.getF2Work());
                    family2.setPhoneNumber(importStudentInfo.getF2Phone());
                    family2.setStudentId(student.getId());
                    family2.setRelationship(importStudentInfo.getF2Relationship());
                    familyServiceImp.insert(family2);
                }
                if (importStudentInfo.getF3Name() != null && !"".equals(importStudentInfo.getF3Name().trim())) {
                    Family family3 = new Family();
                    family3.setName(importStudentInfo.getF3Name());
                    family3.setAge(importStudentInfo.getF3Age());
                    family3.setWork(importStudentInfo.getF3Work());
                    family3.setStudentId(student.getId());
                    family3.setPhoneNumber(importStudentInfo.getF3Phone());
                    family3.setRelationship(importStudentInfo.getF3Relationship());
                    familyServiceImp.insert(family3);
                }
            }
        }
        return 0;
    }
}