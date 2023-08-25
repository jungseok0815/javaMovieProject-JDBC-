package com.kh.movie.model.vo;

import java.util.ArrayList;

public class User extends Moviekiosk{
    protected String name;
    protected int age;

    public User(){

    }

    public User(String name,  int age){
        this.age =age;
        this.name = name;
    }
    protected ArrayList<User> userInfo= new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
