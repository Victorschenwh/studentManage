package com.dbsy.student.myenum;

public enum Role {
    User(),
    Teacher(1),
    Admin(0),
    Student(5);
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
