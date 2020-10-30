package com.dbsy.student.pojo;

public class Power {
    Integer id;

    String role;

    Integer menuId;

    public Power() {
    }

    public Power(Integer id, String role, Integer menuId) {
        this.id = id;
        this.role = role;
        this.menuId = menuId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Integer getMenuId() {
        return menuId;
    }

    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }
}
