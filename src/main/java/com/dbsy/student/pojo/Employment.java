package com.dbsy.student.pojo;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import com.dbsy.student.excel.StringToBooleanConverter;
import com.dbsy.student.excel.StudentNumberToIdConverter;

public class Employment {
    @ExcelIgnore
    private Integer id;

    @ExcelProperty(value = "学号", converter = StudentNumberToIdConverter.class)
    private Integer studentId;

    @ExcelProperty(value = "第三方(1:已签订,0:未签订)", converter = StringToBooleanConverter.class)
    private Boolean isSign;

    @ExcelProperty("单位名称")
    private String company;

    @ExcelProperty("公司或单位联系方式")
    private String phoneNumber;

    @ExcelProperty("公司或单位简介")
    private String remarks;

    public Employment(Integer id, Integer studentId, Boolean isSign, String company, String phoneNumber, String remarks) {
        this.id = id;
        this.studentId = studentId;
        this.isSign = isSign;
        this.company = company;
        this.phoneNumber = phoneNumber;
        this.remarks = remarks;
    }

    public Employment() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public Boolean getIsSign() {
        return isSign;
    }

    public void setIsSign(Boolean isSign) {
        this.isSign = isSign;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company == null ? null : company.trim();
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
    }

    @Override
    public String toString() {
        return "Employment{" +
                "id=" + id +
                ", studentId=" + studentId +
                ", isSign=" + isSign +
                ", company='" + company + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", remarks='" + remarks + '\'' +
                '}';
    }
}