package com.dbsy.student.pojo;

public class Menu {
    Integer id;

    String perm;

    Integer type;

    String name;

    String url;

    String icon;

    Integer parentId;

    String introduce;

    public Menu() {
    }

    public Menu(Integer id, String perm, Integer type, String name,
                String url, String icon, Integer parentId, String introduce) {
        this.id = id;
        this.perm = perm;
        this.type = type;
        this.name = name;
        this.url = url;
        this.icon = icon;
        this.parentId = parentId;
        this.introduce = introduce;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPerm() {
        return perm;
    }

    public void setPerm(String perm) {
        this.perm = perm;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }
}
