package com.dbsy.student.pojo;

import java.util.Date;

public class Transfer {
    private Integer id;

    private Integer studentId;

    private Integer oldDepartmentId;

    private Integer oldMajorId;

    private Integer oldClazzId;

    private Integer newDepartmentId;

    private Integer newMajorId;

    private Integer newClazzId;

    private Boolean isPass;

    private Date oldOutDate;

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
}