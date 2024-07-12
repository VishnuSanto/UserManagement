package com.example.usermanagement.dto;

import com.example.usermanagement.model.UserTbl;

public class UserDto {

    private int id;
    private String userName;
    private String name;
    private String gender;
    private String password;

    public UserDto(UserTbl userTbl) {
        this.id = userTbl.getId();
        this.userName = userTbl.getUserName();
        this.name = userTbl.getName();
        this.gender = userTbl.getGender();
        this.password = userTbl.getPassword();
    }

    public UserDto() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
