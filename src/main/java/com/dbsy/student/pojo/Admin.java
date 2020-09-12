package com.dbsy.student.pojo;

public class Admin {
    private Integer id;

    private String username;

    private String password;

    private String nickname;

    private String phoneNumber;

    private String email;

    private Boolean isLock;

    private Integer role;

    private Integer foreignId;

    private Integer department_id;


    public Boolean getLock() {
        return isLock;
    }

    public void setLock(Boolean lock) {
        isLock = lock;
    }

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }

    public Integer getForeignId() {
        return foreignId;
    }

    public Admin(Integer id, String username, String password, String nickname, String phoneNumber, String email,
                 Boolean isLock, Integer role, Integer foreignId, Integer department_id) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.nickname = nickname;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.isLock = isLock;
        this.role = role;
        this.foreignId = foreignId;
        this.department_id = department_id;
    }

    public void setForeignId(Integer foreignId) {
        this.foreignId = foreignId;
    }

    public Integer getDepartment_id() {
        return department_id;
    }

    public void setDepartment_id(Integer department_id) {
        this.department_id = department_id;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", nickname='" + nickname + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", isLock=" + isLock +
                ", role=" + role +
                ", foreignId=" + foreignId +
                ", department_id=" + department_id +
                '}';
    }

    public Admin() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname == null ? null : nickname.trim();
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber == null ? null : phoneNumber.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public Boolean getIsLock() {
        return isLock;
    }

    public void setIsLock(Boolean isLock) {
        this.isLock = isLock;
    }


}