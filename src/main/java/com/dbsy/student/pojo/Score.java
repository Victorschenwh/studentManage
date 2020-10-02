package com.dbsy.student.pojo;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import com.dbsy.student.excel.CourseNameToIdConverter;
import com.dbsy.student.excel.StudentNumberToIdConverter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Score {
    @ExcelIgnore
    private Integer id;

    @ExcelProperty(value = "学号", converter = StudentNumberToIdConverter.class)
    private Integer studentId;

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

    public Score(Integer id, Integer studentId, Integer courseId, Double score, Double credit, Integer studyTerm, Integer totalHours, Integer theoryHours, Integer experimentHours, Date testTime) {
        this.id = id;
        this.studentId = studentId;
        this.courseId = courseId;
        this.score = score;
        this.credit = credit;
        this.studyTerm = studyTerm;
        this.totalHours = totalHours;
        this.theoryHours = theoryHours;
        this.experimentHours = experimentHours;
        this.testTime = testTime;
    }

    public Score() {
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

    @Override
    public String toString() {
        return "Score{" +
                "id=" + id +
                ", studentId=" + studentId +
                ", courseId=" + courseId +
                ", score=" + score +
                ", credit=" + credit +
                ", studyTerm=" + studyTerm +
                ", totalHours=" + totalHours +
                ", theoryHours=" + theoryHours +
                ", experimentHours=" + experimentHours +
                ", testTime=" + testTime +
                '}';
    }
}