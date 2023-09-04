package com.kh.movie.model.vo;

import java.util.ArrayList;

public class UserMode extends Moviekiosk{
    private String name;
    private int age;
    private String movieName;

    public UserMode(String name, int age, String movieName){
        this.age =age;
        this.name = name;
        this.movieName = movieName;
    }
    public UserMode(){

    };

    @Override
    public String getMovieName() {
        return movieName;
    }
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

    @Override
    public String toString() {
        return "UserMode{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", movieName='" + movieName + '\'' +
                '}';
    }
}
