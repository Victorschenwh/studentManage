package com.dbsy.student.pojo;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import com.dbsy.student.excel.converter.DepartmentNameToIdConverter;

public class Course {
    @ExcelIgnore
    private Integer id;

    @ExcelProperty("课程编号")
    private String number;

    @ExcelProperty("课程名称")
    private String name;

    @ExcelProperty(value = "开课院系", converter = DepartmentNameToIdConverter.class)
    private Integer departmentId;

    public Course(Integer id, String number, String name, Integer departmentId) {
        this.id = id;
        this.number = number;
        this.name = name;
        this.departmentId = departmentId;
    }

    public Course() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number == null ? null : number.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }
}