package com.dbsy.student.pojo;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import com.dbsy.student.excel.ClazzNameToIdConverter;
import com.dbsy.student.excel.DepartmentNameToIdConverter;
import com.dbsy.student.excel.MajorNameToIdConverter;
import com.dbsy.student.excel.StudentNumberToIdConverter;

import java.util.Date;

public class Transfer {
    @ExcelIgnore
    private Integer id;

    @ExcelProperty(value = "学生学号", converter = StudentNumberToIdConverter.class)
    private Integer studentId;

    @ExcelProperty(value = "原学院名", converter = DepartmentNameToIdConverter.class)
    private Integer oldDepartmentId;

    @ExcelProperty(value = "原专业名", converter = MajorNameToIdConverter.class)
    private Integer oldMajorId;

    @ExcelProperty(value = "原班级名", converter = ClazzNameToIdConverter.class)
    private Integer oldClazzId;

    @ExcelProperty(value = "新学院名", converter = DepartmentNameToIdConverter.class)
    private Integer newDepartmentId;

    @ExcelProperty(value = "新专业名", converter = MajorNameToIdConverter.class)
    private Integer newMajorId;

    @ExcelProperty(value = "新班级名", converter = ClazzNameToIdConverter.class)
    private Integer newClazzId;

    @ExcelProperty("是否批准(0:否,1:是)")
    private Boolean isPass;

    @ExcelProperty("转出日期")
    private Date oldOutDate;

    @ExcelProperty("转入日期")
    private Date newInDate;

    public Transfer(Integer id, Integer studentId, Integer oldDepartmentId, Integer oldMajorId, Integer oldClazzId, Integer newDepartmentId, Integer newMajorId, Integer newClazzId, Boolean isPass, Date oldOutDate, Date newInDate) {
        this.id = id;
        this.studentId = studentId;
        this.oldDepartmentId = oldDepartmentId;
        this.oldMajorId = oldMajorId;
        this.oldClazzId = oldClazzId;
        this.newDepartmentId = newDepartmentId;
        this.newMajorId = newMajorId;
        this.newClazzId = newClazzId;
        this.isPass = isPass;
        this.oldOutDate = oldOutDate;
        this.newInDate = newInDate;
    }

    public Transfer() {
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

    public Integer getOldDepartmentId() {
        return oldDepartmentId;
    }

    public void setOldDepartmentId(Integer oldDepartmentId) {
        this.oldDepartmentId = oldDepartmentId;
    }

    public Integer getOldMajorId() {
        return oldMajorId;
    }

    public void setOldMajorId(Integer oldMajorId) {
        this.oldMajorId = oldMajorId;
    }

    public Integer getOldClazzId() {
        return oldClazzId;
    }

    public void setOldClazzId(Integer oldClazzId) {
        this.oldClazzId = oldClazzId;
    }

    public Integer getNewDepartmentId() {
        return newDepartmentId;
    }

    public void setNewDepartmentId(Integer newDepartmentId) {
        this.newDepartmentId = newDepartmentId;
    }

    public Integer getNewMajorId() {
        return newMajorId;
    }

    public void setNewMajorId(Integer newMajorId) {
        this.newMajorId = newMajorId;
    }

    public Integer getNewClazzId() {
        return newClazzId;
    }

    public void setNewClazzId(Integer newClazzId) {
        this.newClazzId = newClazzId;
    }

    public Boolean getIsPass() {
        return isPass;
    }

    public void setIsPass(Boolean isPass) {
        this.isPass = isPass;
    }

    public Date getOldOutDate() {
        return oldOutDate;
    }

    public void setOldOutDate(Date oldOutDate) {
        this.oldOutDate = oldOutDate;
    }

    public Date getNewInDate() {
        return newInDate;
    }

    public void setNewInDate(Date newInDate) {
        this.newInDate = newInDate;
    }

    @Override
    public String toString() {
        return "Transfer{" +
                "id=" + id +
                ", studentId=" + studentId +
                ", oldDepartmentId=" + oldDepartmentId +
                ", oldMajorId=" + oldMajorId +
                ", oldClazzId=" + oldClazzId +
                ", newDepartmentId=" + newDepartmentId +
                ", newMajorId=" + newMajorId +
                ", newClazzId=" + newClazzId +
                ", isPass=" + isPass +
                ", oldOutDate=" + oldOutDate +
                ", newInDate=" + newInDate +
                '}';
    }
}