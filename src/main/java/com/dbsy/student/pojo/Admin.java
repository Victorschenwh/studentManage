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

    private Integer departmentId;

    /**
     * 学生用户初始化
     *
     * @param student
     * @return
     */
    public static Admin student(Student student) {
        return new Admin(null, student.getNumber(), student.getIdCard().substring(student.getIdCard().length() - 6), student.getName(),
                student.getPhoneNumber(), student.getEmail(), false, 40, student.getId(), null);
    }

    /**
     * 教师用户初始化
     *
     * @param teacher
     * @return
     */
    public static Admin teacher(Teacher teacher) {
        return new Admin(null, teacher.getUsername(), teacher.getPhoneNumber().substring(teacher.getPhoneNumber().length() - 6),
                teacher.getName(), teacher.getPhoneNumber(), teacher.getEmail(), false, teacher.getLevel(), teacher.getId(), teacher.getDepartmentId());
    }

    public Admin(Integer id, String username, String password, String nickname, String phoneNumber, String email,
                 Boolean isLock, Integer role, Integer foreignId, Integer departmentId) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.nickname = nickname;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.isLock = isLock;
        this.role = role;
        this.foreignId = foreignId;
        this.departmentId = departmentId;
    }

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


    public void setForeignId(Integer foreignId) {
        this.foreignId = foreignId;
    }

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
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