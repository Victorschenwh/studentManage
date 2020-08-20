package com.dbsy.student.pojo;

public class Reward {
    private Integer id;

    private Integer studentId;

    private String synopsis;

    private String type;

    public Reward(Integer id, Integer studentId, String synopsis, String type) {
        this.id = id;
        this.studentId = studentId;
        this.synopsis = synopsis;
        this.type = type;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }
}