package com.dbsy.student.pojo;

import java.util.Date;

public class History {
    Integer id;

    String ip;

    Integer adminId;

    Date insertTime;

    String url;

    String args;

    String ret;

    String method;

    public History() {
    }

    public History(Integer id, String ip, Integer adminId, Date insertTime, String url, String args, String ret, String method) {
        this.id = id;
        this.ip = ip;
        this.adminId = adminId;
        this.insertTime = insertTime;
        this.url = url;
        this.args = args;
        this.ret = ret;
        this.method = method;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Integer getAdminId() {
        return adminId;
    }

    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
    }

    public Date getInsertTime() {
        return insertTime;
    }

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getArgs() {
        return args;
    }

    public void setArgs(String args) {
        this.args = args;
    }

    public String getRet() {
        return ret;
    }

    public void setRet(String ret) {
        this.ret = ret;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }
}
