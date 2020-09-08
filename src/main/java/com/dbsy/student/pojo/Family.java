package com.dbsy.student.pojo;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import com.dbsy.student.excel.StringToBooleanConverter;
import com.dbsy.student.excel.StudentNumberToIdConverter;

public class Family {
    @ExcelIgnore
    private Integer id;

    @ExcelProperty("家庭成员姓名")
    private String name;

    @ExcelProperty("工作单位")
    private String work;

    @ExcelProperty("与本人关系")
    private String relationship;

    @ExcelProperty("年龄")
    private Integer age;

    @ExcelProperty(value = "性别(1:男,0:女)", converter = StringToBooleanConverter.class)
    private Boolean gender;

    @ExcelProperty("身份证号")
    private String idCard;

    @ExcelProperty("手机号")
    private String phoneNumber;

    @ExcelProperty(value = "学生学号", converter = StudentNumberToIdConverter.class)
    private Integer studentId;

    public Family(Integer id, String name, String work, String relationship, Integer age, Boolean gender, String idCard, String phoneNumber, Integer studentId) {
        this.id = id;
        this.name = name;
        this.work = work;
        this.relationship = relationship;
        this.age = age;
        this.gender = gender;
        this.idCard = idCard;
        this.phoneNumber = phoneNumber;
        this.studentId = studentId;
    }

    public Family() {
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

    public String getWork() {
        return work;
    }

    public void setWork(String work) {
        this.work = work == null ? null : work.trim();
    }

    public String getRelationship() {
        return relationship;
    }

    public void setRelationship(String relationship) {
        this.relationship = relationship == null ? null : relationship.trim();
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Boolean getGender() {
        return gender;
    }

    public void setGender(Boolean gender) {
        this.gender = gender;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard == null ? null : idCard.trim();
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber == null ? null : phoneNumber.trim();
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    @Override
    public String toString() {
        return "Family{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", work='" + work + '\'' +
                ", relationship='" + relationship + '\'' +
                ", age=" + age +
                ", gender=" + gender +
                ", idCard='" + idCard + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", studentId=" + studentId +
                '}';
    }
}