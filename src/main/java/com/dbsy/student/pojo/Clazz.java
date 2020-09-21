package com.dbsy.student.pojo;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import com.dbsy.student.excel.DepartmentNameToIdConverter;
import com.dbsy.student.excel.MajorNameToIdConverter;

public class Clazz {
    @ExcelIgnore
    private Integer id;
    @ExcelProperty("班级名称")
    private String name;
    @ExcelProperty("班级介绍")
    private String introduce;
    @ExcelProperty(value = "所属专业名称", converter = MajorNameToIdConverter.class)
    private Integer majorId;
    @ExcelIgnore
    private Integer teacherId;
    @ExcelProperty("年级(1:大一,2:大二,3:大三,4:大四)")
    private Integer grade;
    @ExcelProperty(value = "所属院系名称", converter = DepartmentNameToIdConverter.class)
    private Integer departmentId;

    public Clazz(Integer id, String name, String introduce, Integer majorId, Integer teacherId, Integer grade, Integer departmentId) {
        this.id = id;
        this.name = name;
        this.introduce = introduce;
        this.majorId = majorId;
        this.teacherId = teacherId;
        this.grade = grade;
        this.departmentId = departmentId;
    }

    public Clazz() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce == null ? null : introduce.trim();
    }

    public Integer getMajorId() {
        return majorId;
    }

    public void setMajorId(Integer majorId) {
        this.majorId = majorId;
    }

    public Integer getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Integer teacherId) {
        this.teacherId = teacherId;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

}