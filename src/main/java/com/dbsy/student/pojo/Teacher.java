package com.dbsy.student.pojo;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import com.dbsy.student.excel.converter.DepartmentNameToIdConverter;
import com.dbsy.student.excel.converter.GenderConverter;
import com.dbsy.student.excel.converter.LevelConverter;

import java.util.Date;

public class Teacher {
    @ExcelIgnore
    private Integer id;

    @ExcelProperty("工号")
    private String username;

    @ExcelIgnore
    private String password;

    @ExcelProperty("姓名")
    private String name;

    @ExcelProperty(value = "性别", converter = GenderConverter.class)
    private Boolean gender;

    // @DateTimeFormat(pattern = "yyyy-MM-dd")// 前台字符串->后台Date()
    //@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")// 后台Date()->前台字符串
    @ExcelIgnore
    private Date birthday;
    @ExcelIgnore
    private Integer titleId;
    @ExcelProperty(value = "学院", converter = DepartmentNameToIdConverter.class)
    private Integer departmentId;
    @ExcelIgnore
    private String post;
    @ExcelProperty("电话号码")
    private String phoneNumber;
    @ExcelIgnore
    private String email;
    @ExcelIgnore
    private Boolean isLock;
    @ExcelProperty(value = "级别(院级,校级,2018级)", converter = LevelConverter.class)
    private Integer level;
    // role
    @ExcelProperty("备注")
    private String remarks;

    public Boolean getLock() {
        return isLock;
    }

    public void setLock(Boolean lock) {
        isLock = lock;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Teacher(Integer id, String username, String password, String name, Boolean gender, Date birthday, Integer titleId,
                   Integer departmentId, String post, String phoneNumber, String email, Boolean isLock, Integer level, String remarks) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.name = name;
        this.gender = gender;
        this.birthday = birthday;
        this.titleId = titleId;
        this.departmentId = departmentId;
        this.post = post;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.isLock = isLock;
        this.level = level;
        this.remarks = remarks;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Teacher(Integer id, String username, String password, String name,
                   Boolean gender, Date birthday, Integer titleId, Integer departmentId, String post,
                   String phoneNumber, String email, Boolean isLock) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.name = name;
        this.gender = gender;
        this.birthday = birthday;
        this.titleId = titleId;
        this.departmentId = departmentId;
        this.post = post;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.isLock = isLock;
    }

    public Teacher(Integer id, String username, String password, String name, Boolean gender, Date birthday,
                   Integer titleId, Integer departmentId, String post, String phoneNumber, String email, Boolean isLock, String remarks) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.name = name;
        this.gender = gender;
        this.birthday = birthday;
        this.titleId = titleId;
        this.departmentId = departmentId;
        this.post = post;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.isLock = isLock;
        this.remarks = remarks;
    }


    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Boolean getIsLock() {
        return isLock;
    }

    public void setIsLock(Boolean isLock) {
        this.isLock = isLock;
    }

    public Teacher() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Boolean getGender() {
        return gender;
    }

    public void setGender(Boolean gender) {
        this.gender = gender;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Integer getTitleId() {
        return titleId;
    }

    public void setTitleId(Integer titleId) {
        this.titleId = titleId;
    }

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post == null ? null : post.trim();
    }
}