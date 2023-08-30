package com.kh.movie.model.vo;

import java.util.ArrayList;

public class UserMode extends Moviekiosk{
    protected String name;
    protected int age;
    String movieName;
    public UserMode(){
        defualtuserInfo();
    }
    public void defualtuserInfo(){
        userInfo.add(new UserMode("차정석", 18, "인터스텔라"));
        userInfo.add(new UserMode("박찬준", 28, "인터스텔라"));
        userInfo.add(new UserMode("유명준", 15, "인터스텔라"));
        userInfo.add(new UserMode("이경택", 25, "인터스텔라"));
    }

    public UserMode(String name, int age, String movieName){
        this.age =age;
        this.name = name;
        this.movieName = movieName;
    }
    protected ArrayList<UserMode> userInfo= new ArrayList<>();

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


    public ArrayList<UserMode> getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(ArrayList<UserMode> userInfo) {
        this.userInfo = userInfo;
    }

    @Override
    public String toString() {
        return "UserMode{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", movieName='" + movieName + '\'' +
                '}';
    }
}
