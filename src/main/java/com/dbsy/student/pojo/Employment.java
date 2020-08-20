package com.dbsy.student.pojo;

public class Employment {
    private Integer id;

    private Integer studentId;

    private Boolean isSign;

    private String company;

    private Integer phoneNumber;

    private String remarks;

    public Employment(Integer id, Integer studentId, Boolean isSign, String company, Integer phoneNumber, String remarks) {
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

    public Integer getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Integer phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
    }
}