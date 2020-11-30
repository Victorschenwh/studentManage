package com.dbsy.student.excel.vo;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import com.alibaba.excel.annotation.write.style.ContentRowHeight;
import com.alibaba.excel.annotation.write.style.HeadRowHeight;
import com.dbsy.student.excel.converter.ClazzNameToIdConverter;
import com.dbsy.student.excel.converter.DepartmentNameToIdConverter;
import com.dbsy.student.excel.converter.EmployStateConverter;
import com.dbsy.student.excel.converter.MajorNameToIdConverter;

@ContentRowHeight(10)
@HeadRowHeight(20)
@ColumnWidth(25)
public class EmploymentEo {
    @ExcelProperty("学号")
    private String number;

    @ExcelProperty("姓名")
    private String name;

    @ExcelProperty(value = "班级名", converter = ClazzNameToIdConverter.class)
    private Integer clazzId;

    @ExcelProperty(value = "专业名", converter = MajorNameToIdConverter.class)
    private Integer majorId;

    @ExcelProperty(value = "学院名", converter = DepartmentNameToIdConverter.class)
    private Integer departmentId;

    @ExcelProperty("年级")
    private Integer grade;

    @ExcelProperty("单位名称")
    private String company;

    @ExcelProperty("单位联系方式")
    private String phoneNumber;

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
    @ExcelProperty(value = "毕业去向", converter = EmployStateConverter.class)
    private Integer state;

    // 报到证签往单位名称
    @ExcelProperty("报到证签往单位名称")
    private String registrationTo;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getClazzId() {
        return clazzId;
    }

    public void setClazzId(Integer clazzId) {
        this.clazzId = clazzId;
    }

    public Integer getMajorId() {
        return majorId;
    }

    public void setMajorId(Integer majorId) {
        this.majorId = majorId;
    }

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
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
}
