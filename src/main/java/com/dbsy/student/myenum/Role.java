package com.dbsy.student.myenum;

public enum Role {

    //校领导 10
    //院领导  20
    // 辅导员  2018  2017
    //学生 40
    User(),
    Admin(0),
    School(10),
    Department(20),
    Assistant(30),
    Student(40);
    private Integer role;

    private Role() {
    }

    private Role(Integer role) {
        this.role = role;
    }

    public Integer getRole() {
        return role;
    }

    public Role setRole(Integer role) {
        this.role = role;
        return this;
    }

    @Override
    public String toString() {
        return "Role{" +
                "role=" + role +
                '}';
    }
}
