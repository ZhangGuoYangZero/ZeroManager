package com.manager.mag.vo;

public class User {
    private String useName;

    private String password;

    private String realName;

    private Integer ID;

    public String getUseName() {
        return useName;
    }

    public void setUseName(String useName) {
        this.useName = useName == null ? null : useName.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer id) {
        this.ID = id;
    }
}