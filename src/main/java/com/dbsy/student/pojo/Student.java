package com.dbsy.student.pojo;


import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import com.alibaba.excel.annotation.write.style.ContentRowHeight;
import com.alibaba.excel.annotation.write.style.HeadRowHeight;
import com.dbsy.student.excel.converter.ClazzNameToIdConverter;
import com.dbsy.student.excel.converter.DepartmentNameToIdConverter;
import com.dbsy.student.excel.converter.GenderConverter;
import com.dbsy.student.excel.converter.MajorNameToIdConverter;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@JsonIgnoreProperties(value = {"password"})
@ContentRowHeight(10)
@HeadRowHeight(20)
@ColumnWidth(25)
public class Student {
    @ExcelIgnore
    private Integer id;

    @ExcelProperty("学号")
    private String number;

    @ExcelProperty("姓名")
    private String name;

    @ExcelProperty(value = "性别", converter = GenderConverter.class)
    private Boolean gender;

    @ExcelProperty("手机号")
    private String phoneNumber;

    @ExcelProperty("邮箱")
    private String email;

    @ExcelProperty("身份证号")
    private String idCard;

    @ExcelProperty("籍贯")
    private String nativePlace;

    @ExcelIgnore
    private String photo;

    @ExcelProperty("入学日期")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date admissionDate;

    @ExcelProperty("出生日期")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthday;

    @ExcelIgnore
    private String password;

    @ExcelProperty("高考分数")
    private Float score;

    @ExcelProperty(value = "班级名", converter = ClazzNameToIdConverter.class)
    private Integer clazzId;

    @ExcelProperty(value = "专业名", converter = MajorNameToIdConverter.class)
    private Integer majorId;

    @ExcelProperty(value = "学院名", converter = DepartmentNameToIdConverter.class)
    private Integer departmentId;

    @ExcelProperty("年级")
    private Integer grade;

    @ExcelProperty("年龄")
    private Integer age;

    @ExcelProperty("民族")
    private String nation;

    @ExcelProperty("地址")
    private String address;

    @ExcelProperty("宿舍号")
    private String room;

    @ExcelProperty("政治面貌")
    private String status;

    private Integer isdel;

    private String abbrName;

    private Integer cet4;

    private Integer cet6;

    public Integer getIsdel() {
        return isdel;
    }

    public void setIsdel(Integer isdel) {
        this.isdel = isdel;
    }

    public String getAbbrName() {
        return abbrName;
    }

    public void setAbbrName(String abbrName) {
        this.abbrName = abbrName;
    }

    public Integer getCet4() {
        return cet4;
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

    public Student() {
        super();
    }

    public Student(Integer id, String number, String name, Boolean gender, String phoneNumber, String email, String idCard, String nativePlace,
                   String photo, Date admissionDate, Date birthday, String password, Float score, Integer clazzId, Integer majorId, Integer departmentId,
                   Integer grade, Integer age, String nation,
                   String address, String room, String status, Integer isdel, String abbrName, Integer cet4, Integer cet6) {
        this.id = id;
        this.number = number;
        this.name = name;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.idCard = idCard;
        this.nativePlace = nativePlace;
        this.photo = photo;
        this.admissionDate = admissionDate;
        this.birthday = birthday;
        this.password = password;
        this.score = score;
        this.clazzId = clazzId;
        this.majorId = majorId;
        this.departmentId = departmentId;
        this.grade = grade;
        this.age = age;
        this.nation = nation;
        this.address = address;
        this.room = room;
        this.status = status;
        this.isdel = isdel;
        this.abbrName = abbrName;
        this.cet4 = cet4;
        this.cet6 = cet6;
    }

    public Student(Integer id, String number, String name,
                   Boolean gender, String phoneNumber, String email,
                   String idCard, String nativePlace, String photo,
                   Date admissionDate, Date birthday, String password, Float score,
                   Integer clazzId, Integer majorId, Integer departmentId, Integer grade,
                   Integer age, String nation, String address, String room, String status) {
        this.id = id;
        this.number = number;
        this.name = name;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.idCard = idCard;
        this.nativePlace = nativePlace;
        this.photo = photo;
        this.admissionDate = admissionDate;
        this.birthday = birthday;
        this.password = password;
        this.score = score;
        this.clazzId = clazzId;
        this.majorId = majorId;
        this.departmentId = departmentId;
        this.grade = grade;
        this.age = age;
        this.nation = nation;
        this.address = address;
        this.room = room;
        this.status = status;
    }


    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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
        this.phoneNumber = phoneNumber == null ? null : phoneNumber.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard == null ? null : idCard.trim();
    }

    public String getNativePlace() {
        return nativePlace;
    }

    public void setNativePlace(String nativePlace) {
        this.nativePlace = nativePlace == null ? null : nativePlace.trim();
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo == null ? null : photo.trim();
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public Float getScore() {
        return score;
    }

    public void setScore(Float score) {
        this.score = score;
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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation == null ? null : nation.trim();
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", number='" + number + '\'' +
                ", name='" + name + '\'' +
                ", gender=" + gender +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", idCard='" + idCard + '\'' +
                ", nativePlace='" + nativePlace + '\'' +
                ", photo='" + photo + '\'' +
                ", admissionDate=" + admissionDate +
                ", birthday=" + birthday +
                ", password='" + password + '\'' +
                ", score=" + score +
                ", clazzId=" + clazzId +
                ", majorId=" + majorId +
                ", departmentId=" + departmentId +
                ", grade=" + grade +
                ", age=" + age +
                ", nation='" + nation + '\'' +
                ", address='" + address + '\'' +
                ", room ='" + room + '\'' +
                ",status ='" + status + '\'' +
                '}'
                ;
    }


}