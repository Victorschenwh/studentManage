package com.dbsy.student.pojo;

public class Clazz {
    private Integer id;

    private String name;

    private String introduce;

    private Integer majorId;

    private Integer teacherId;

    private Integer grade;

    private Integer departmentId;

    public Clazz(Integer id, String name, String introduce, Integer majorId, Integer teacherId, Integer grade, Integer departmentId) {
        this.id = id;
        this.name = name;
        this.introduce = introduce;
        this.majorId = majorId;
        this.teacherId = teacherId;
        this.grade = grade;
        this.departmentId = departmentId;
    }

    public Clazz() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce == null ? null : introduce.trim();
    }

    public Integer getMajorId() {
        return majorId;
    }

    public void setMajorId(Integer majorId) {
        this.majorId = majorId;
    }

    public Integer getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Integer teacherId) {
        this.teacherId = teacherId;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    @Override
    public String toString() {
        return "Clazz{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", introduce='" + introduce + '\'' +
                ", majorId=" + majorId +
                ", teacherId=" + teacherId +
                ", grade=" + grade +
                ", departmentId=" + departmentId +
                '}';
    }
}