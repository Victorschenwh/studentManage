package com.dbsy.student.pojo;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;

public class Major {
    @ExcelIgnore
    private Integer id;
    @ExcelProperty("专业名称")
    private String name;

    @ExcelProperty("专业介绍")
    private String introduce;

    @ExcelProperty("所属学院名称")
    private Integer departmentId;

    public Major(Integer id, String name, String introduce, Integer departmentId) {
        this.id = id;
        this.name = name;
        this.introduce = introduce;
        this.departmentId = departmentId;
    }

    public Major() {
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

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }
}