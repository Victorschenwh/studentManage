package com.dbsy.student.pojo;

import java.util.Date;

public class Score {
    private Integer id;

    private Integer studentId;

    private Integer courseId;

    private Float score;

    private Integer credit;

    private Integer studyTerm;

    private Integer totalHours;

    private Integer theoryHours;

    private Integer experimentHours;

    private Date testTime;

    public Score(Integer id, Integer studentId, Integer courseId, Float score, Integer credit, Integer studyTerm, Integer totalHours, Integer theoryHours, Integer experimentHours, Date testTime) {
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

    public Float getScore() {
        return score;
    }

    public void setScore(Float score) {
        this.score = score;
    }

    public Integer getCredit() {
        return credit;
    }

    public void setCredit(Integer credit) {
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