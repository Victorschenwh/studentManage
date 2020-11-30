package com.dbsy.student.excel.vo;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import com.alibaba.excel.annotation.write.style.ContentRowHeight;
import com.alibaba.excel.annotation.write.style.HeadRowHeight;
import com.dbsy.student.excel.converter.ClazzNameToIdConverter;
import com.dbsy.student.excel.converter.DepartmentNameToIdConverter;
import com.dbsy.student.excel.converter.MajorNameToIdConverter;

@ContentRowHeight(10)
@HeadRowHeight(20)
@ColumnWidth(25)
public class AcademiScoreEo {
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


    @ExcelProperty("学期")
    private Integer studyTerm;

    @ExcelProperty("智育成绩")
    private Double avgAcademiRecoreds;

    @ExcelProperty("排名")
    private Integer majorRank;

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

    public Integer getStudyTerm() {
        return studyTerm;
    }

    public void setStudyTerm(Integer studyTerm) {
        this.studyTerm = studyTerm;
    }

    public Double getAvgAcademiRecoreds() {
        return avgAcademiRecoreds;
    }

    public void setAvgAcademiRecoreds(Double avgAcademiRecoreds) {
        this.avgAcademiRecoreds = avgAcademiRecoreds;
    }

    public Integer getMajorRank() {
        return majorRank;
    }

    public void setMajorRank(Integer majorRank) {
        this.majorRank = majorRank;
    }


}
