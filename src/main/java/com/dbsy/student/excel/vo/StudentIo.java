package com.dbsy.student.excel.vo;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import com.dbsy.student.excel.converter.*;

import java.util.Date;

public class StudentIo {
    @ExcelProperty("学院")
    private String department;

    @ExcelProperty("学院介绍")
    private String deSys;

    @ExcelProperty("专业")
    private String major;

    @ExcelProperty("专业介绍")
    private String mSys;

    @ExcelProperty("年级")
    private Integer grade;

    @ExcelProperty("班级")
    private String clazz;

    @ExcelProperty("学号")
    private String number;

    @ExcelProperty("姓名")
    private String name;

    @ExcelProperty(value = "性别", converter = GenderConverter.class)
    private Boolean gender;

    @ExcelProperty("民族")
    private String nation;

    @ExcelProperty("政治面貌（中共党员/中共预备党员/共青团员/群众）")
    private String status;

    @ExcelProperty(value = "年龄", converter = NumberFormatConverter.class)
    private Integer age;

    @ExcelProperty("身份证号")
    private String idCard;

    @ExcelProperty(value = "出生日期", converter = DateFormatConverter.class)
    // @JsonFormat(pattern = "yyyyMMdd", timezone = "GMT+8")
    // @DateTimeFormat(pattern = "yyyyMMdd")
    @ExcelIgnore
    private Date birthday;

    @ExcelProperty("籍贯（省市）")
    private String nativePlace;

    @ExcelProperty("家庭住址（详细到社区（村））")
    private String address;

    @ExcelProperty(value = "联系方式", converter = PhoneCheckConverter.class)
    private String phoneNumber;

    @ExcelProperty(value = "邮箱", converter = EmailCheckConverter.class)
    private String email;

    @ExcelProperty(value = "高考分数", converter = FloatFormatConverter.class)
    private Float score;

    @ExcelProperty(value = "入学日期", converter = DateFormatConverter.class)
    // @JsonFormat(pattern = "yyyyMMdd", timezone = "GMT+8")
    //  @DateTimeFormat(pattern = "yyyyMMdd")
    @ExcelIgnore
    private Date admissionDate;

    @ExcelProperty("寝室号")
    private String room;

    @ExcelProperty(value = "四级成绩", converter = NumberFormatConverter.class)
    private Integer cet4;

    @ExcelProperty(value = "六级成绩", converter = NumberFormatConverter.class)
    private Integer cet6;

    @ExcelIgnore
    private Integer isDel = 0;

    @ExcelIgnore
    private String photo;

    @ExcelProperty("家庭成员1")
    private String f1Name;

    @ExcelProperty("与本人关系1")
    private String f1Relationship;

    @ExcelProperty(value = "年龄1", converter = NumberFormatConverter.class)
    private Integer f1Age;

    @ExcelProperty("工作单位1")
    private String f1Work;

    @ExcelProperty("联系方式1")
    private String f1Phone;

    @ExcelProperty("家庭成员2")
    private String f2Name;

    @ExcelProperty("与本人关系2")
    private String f2Relationship;

    @ExcelProperty(value = "年龄2", converter = NumberFormatConverter.class)
    private Integer f2Age;

    @ExcelProperty("工作单位2")
    private String f2Work;

    @ExcelProperty("联系方式2")
    private String f2Phone;

    @ExcelProperty("家庭成员3")
    private String f3Name;

    @ExcelProperty("与本人关系3")
    private String f3Relationship;

    @ExcelProperty(value = "年龄3", converter = NumberFormatConverter.class)
    private Integer f3Age;

    @ExcelProperty("工作单位3")
    private String f3Work;

    @ExcelProperty("联系方式3")
    private String f3Phone;

    public Integer getCet4() {
        return cet4;
    }

    public Integer getIsDel() {
        return isDel;
    }

    public void setIsDel(Integer isDel) {
        this.isDel = isDel;
    }

    public void setCet4(Integer cet4) {
        this.cet4 = cet4;
    }

    public Integer getCet6() {
        return cet6;
    }

    public void setCet6(Integer cet6) {
        this.cet6 = cet6;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getDeSys() {
        return deSys;
    }

    public void setDeSys(String deSys) {
        this.deSys = deSys;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getmSys() {
        return mSys;
    }

    public void setmSys(String mSys) {
        this.mSys = mSys;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public String getClazz() {
        return clazz;
    }

    public void setClazz(String clazz) {
        this.clazz = clazz;
    }

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

    public Boolean getGender() {
        return gender;
    }

    public void setGender(Boolean gender) {
        this.gender = gender;
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

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getNativePlace() {
        return nativePlace;
    }

    public void setNativePlace(String nativePlace) {
        this.nativePlace = nativePlace;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public Date getAdmissionDate() {
        return admissionDate;
    }

    public void setAdmissionDate(Date admissionDate) {
        this.admissionDate = admissionDate;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Float getScore() {
        return score;
    }

    public void setScore(Float score) {
        this.score = score;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getNation() {
        return nation;
    }

    public String getF3Name() {
        return f3Name;
    }

    public void setF3Name(String f3Name) {
        this.f3Name = f3Name;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public String getF1Name() {
        return f1Name;
    }

    public void setF1Name(String f1Name) {
        this.f1Name = f1Name;
    }

    public String getF1Relationship() {
        return f1Relationship;
    }

    public void setF1Relationship(String f1Relationship) {
        this.f1Relationship = f1Relationship;
    }

    public Integer getF1Age() {
        return f1Age;
    }

    public void setF1Age(Integer f1Age) {
        this.f1Age = f1Age;
    }

    public String getF1Work() {
        return f1Work;
    }

    public void setF1Work(String f1Work) {
        this.f1Work = f1Work;
    }

    public String getF1Phone() {
        return f1Phone;
    }

    public void setF1Phone(String f1Phone) {
        this.f1Phone = f1Phone;
    }

    public String getF2Name() {
        return f2Name;
    }

    public void setF2Name(String f2Name) {
        this.f2Name = f2Name;
    }

    public String getF2Relationship() {
        return f2Relationship;
    }

    public void setF2Relationship(String f2Relationship) {
        this.f2Relationship = f2Relationship;
    }

    public Integer getF2Age() {
        return f2Age;
    }

    public void setF2Age(Integer f2Age) {
        this.f2Age = f2Age;
    }

    public String getF2Work() {
        return f2Work;
    }

    public void setF2Work(String f2Work) {
        this.f2Work = f2Work;
    }

    public String getF2Phone() {
        return f2Phone;
    }

    public void setF2Phone(String f2Phone) {
        this.f2Phone = f2Phone;
    }

    public String getF3Relationship() {
        return f3Relationship;
    }

    public void setF3Relationship(String f3Relationship) {
        this.f3Relationship = f3Relationship;
    }

    public Integer getF3Age() {
        return f3Age;
    }

    public void setF3Age(Integer f3Age) {
        this.f3Age = f3Age;
    }

    public String getF3Work() {
        return f3Work;
    }

    public void setF3Work(String f3Work) {
        this.f3Work = f3Work;
    }

    public String getF3Phone() {
        return f3Phone;
    }

    public void setF3Phone(String f3Phone) {
        this.f3Phone = f3Phone;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
