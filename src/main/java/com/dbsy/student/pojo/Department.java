package com.dbsy.student.pojo;

public class Department {
    private Integer id;

    private String name;

    private String introduce;

    public Department(Integer id, String name, String introduce) {
        this.id = id;
        this.name = name;
        this.introduce = introduce;
    }

    public Department() {
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
}