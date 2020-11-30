package com.dbsy.student.pojo;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import com.alibaba.excel.annotation.write.style.ContentRowHeight;
import com.alibaba.excel.annotation.write.style.HeadRowHeight;
import com.dbsy.student.excel.converter.StudentNumberToIdConverter;

@ContentRowHeight(10)
@HeadRowHeight(20)
@ColumnWidth(25)
public class Reward {
    @ExcelIgnore
    private Integer id;

    @ExcelProperty(value = "学号", converter = StudentNumberToIdConverter.class)
    private Integer studentId;

    @ExcelProperty("奖惩细则")
    private String synopsis;

    @ExcelProperty("分值（减分的话是负数）")
    private Integer score;

    @ExcelProperty("学期")
    private Integer studyTerm;

    public Integer getStudyTerm() {
        return studyTerm;
    }


    public void setStudyTerm(Integer studyTerm) {
        this.studyTerm = studyTerm;
    }

    public Reward(Integer id, Integer studentId, String synopsis, Integer score, Integer studyTerm) {
        this.id = id;
        this.studentId = studentId;
        this.synopsis = synopsis;
        this.score = score;
        this.studyTerm = studyTerm;
    }

    @Override
    public String toString() {
        return "Reward{" +
                "id=" + id +
                ", studentId=" + studentId +
                ", synopsis='" + synopsis + '\'' +
                ", score=" + score +
                '}';
    }

    public Reward() {
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

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis == null ? null : synopsis.trim();
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }
}