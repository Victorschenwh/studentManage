package com.dbsy.student.pojo;

import java.util.Date;

public class Retardation {
    private Integer id;

    private Integer studentId;

    private Integer oldDepartmentId;

    private Integer oldMajorId;

    private Integer oldClazzId;

    private Integer newDepartmentId;

    private Integer newMajorId;

    private Integer newClazzId;

    private Date saveDate;

    private Boolean isPass;

    private Boolean result;

    private String remarks;

    public Retardation(Integer id, Integer studentId, Integer oldDepartmentId, Integer oldMajorId, Integer oldClazzId, Integer newDepartmentId, Integer newMajorId, Integer newClazzId, Date saveDate, Boolean isPass, Boolean result, String remarks) {
        this.id = id;
        this.studentId = studentId;
        this.oldDepartmentId = oldDepartmentId;
        this.oldMajorId = oldMajorId;
        this.oldClazzId = oldClazzId;
        this.newDepartmentId = newDepartmentId;
        this.newMajorId = newMajorId;
        this.newClazzId = newClazzId;
        this.saveDate = saveDate;
        this.isPass = isPass;
        this.result = result;
        this.remarks = remarks;
    }

    public Retardation() {
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

    public Date getSaveDate() {
        return saveDate;
    }

    public void setSaveDate(Date saveDate) {
        this.saveDate = saveDate;
    }

    public Boolean getIsPass() {
        return isPass;
    }

    public void setIsPass(Boolean isPass) {
        this.isPass = isPass;
    }

    public Boolean getResult() {
        return result;
    }

    public void setResult(Boolean result) {
        this.result = result;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
    }
}