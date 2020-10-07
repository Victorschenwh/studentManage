package com.dbsy.student.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Suspension {
    private Integer id;

    private Integer studentId;

    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date suspensionDate;

    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date resumptionDate;

    private Integer duration;

    private String reason;

    private String remarks;

    public Suspension(Integer id, Integer studentId, Date suspensionDate, Date resumptionDate, Integer duration, String reason, String remarks) {
        this.id = id;
        this.studentId = studentId;
        this.suspensionDate = suspensionDate;
        this.resumptionDate = resumptionDate;
        this.duration = duration;
        this.reason = reason;
        this.remarks = remarks;
    }

    public Suspension() {
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

    public Date getSuspensionDate() {
        return suspensionDate;
    }

    public void setSuspensionDate(Date suspensionDate) {
        this.suspensionDate = suspensionDate;
    }

    public Date getResumptionDate() {
        return resumptionDate;
    }

    public void setResumptionDate(Date resumptionDate) {
        this.resumptionDate = resumptionDate;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason == null ? null : reason.trim();
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
    }


    @Override
    public String toString() {
        return "Suspension{" +
                "id=" + id +
                ", studentId=" + studentId +
                ", suspensionDate=" + suspensionDate +
                ", resumptionDate=" + resumptionDate +
                ", duration=" + duration +
                ", reason='" + reason + '\'' +
                ", remarks='" + remarks + '\'' +
                '}';
    }
}