package com.kh.movie.model.vo;

import java.util.ArrayList;

public class UserMode extends Moviekiosk{
    private String name;
    private String userId;
    private String userPwd;
    private int age;

    public UserMode(String name, String userId, String userPwd, int age) {
        this.name = name;
        this.userId = userId;
        this.userPwd = userPwd;
        this.age = age;
    }

    public UserMode(){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


}
