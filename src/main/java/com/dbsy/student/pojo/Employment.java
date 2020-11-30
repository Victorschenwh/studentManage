package com.dbsy.student.pojo;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import com.dbsy.student.excel.converter.StudentNumberToIdConverter;

public class Employment {
    @ExcelIgnore
    private Integer id;

    @ExcelProperty(value = "学号", converter = StudentNumberToIdConverter.class)
    private Integer studentId;

    // @ExcelProperty(value = "第三方(1:已签订,0:未签订)", converter = StringToBooleanConverter.class)
    @ExcelIgnore
    private Boolean isSign;

    @ExcelProperty("单位名称")
    private String company;

    @ExcelProperty("单位联系方式")
    private String phoneNumber;

    //@ExcelProperty("公司或单位简介")
    @ExcelIgnore
    private String remarks;

    /**
     * 毕业去向
     * 0：不就业拟升学；
     * 1：待就业、拟参加公招考试；
     * 2：待就业、签约中；
     * 3：待就业、求职中；
     * 4：其他暂不就业；
     * 5：签就业协议形式就业；
     * 6：签劳动合同形式就业；
     * 7：升学；
     */
    @ExcelProperty("毕业去向\n" +
            "0：不就业拟升学；\n" +
            "1：待就业、拟参加公招考试；\n" +
            "2：待就业、签约中；\n" +
            "3：待就业、求职中；\n" +
            "4：其他暂不就业；\n" +
            "5：签就业协议形式就业；\n" +
            "6：签劳动合同形式就业；\n" +
            "7：升学；")
    private Integer state;

    // 报到证签往单位名称
    @ExcelProperty("报到证签往单位名称")
    private String registrationTo;

    public Boolean getSign() {
        return isSign;
    }

    public void setSign(Boolean sign) {
        isSign = sign;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getRegistrationTo() {
        return registrationTo;
    }

    public void setRegistrationTo(String registrationTo) {
        this.registrationTo = registrationTo;
    }

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