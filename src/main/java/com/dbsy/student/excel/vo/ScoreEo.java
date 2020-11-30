package com.dbsy.student.excel.vo;

import com.alibaba.excel.annotation.ExcelProperty;
import com.dbsy.student.excel.converter.ClazzNameToIdConverter;
import com.dbsy.student.excel.converter.CourseNameToIdConverter;
import com.dbsy.student.excel.converter.DepartmentNameToIdConverter;
import com.dbsy.student.excel.converter.MajorNameToIdConverter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class ScoreEo {
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

    @ExcelProperty(value = "课程名", converter = CourseNameToIdConverter.class)
    private Integer courseId;

    @ExcelProperty("分数")
    private Double score;

    @ExcelProperty("学分")
    private Double credit;

    @ExcelProperty("学期")
    private Integer studyTerm;

    @ExcelProperty("总学时")
    private Integer totalHours;

    @ExcelProperty("理论学时")
    private Integer theoryHours;

    @ExcelProperty("实践学时")
    private Integer experimentHours;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH-mm-ss")
    @ExcelProperty("考试时间")
    private Date testTime;

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

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public Double getCredit() {
        return credit;
    }

    public void setCredit(Double credit) {
        this.credit = credit;
    }

    public Integer getStudyTerm() {
        return studyTerm;
    }

    public void setStudyTerm(Integer studyTerm) {
        this.studyTerm = studyTerm;
    }

    public Integer getTotalHours() {
        return totalHours;
    }

    public void setTotalHours(Integer totalHours) {
        this.totalHours = totalHours;
    }

    public Integer getTheoryHours() {
        return theoryHours;
    }

    public void setTheoryHours(Integer theoryHours) {
        this.theoryHours = theoryHours;
    }

    public Integer getExperimentHours() {
        return experimentHours;
    }

    public void setExperimentHours(Integer experimentHours) {
        this.experimentHours = experimentHours;
    }

    public Date getTestTime() {
        return testTime;
    }

    public void setTestTime(Date testTime) {
        this.testTime = testTime;
    }
}
