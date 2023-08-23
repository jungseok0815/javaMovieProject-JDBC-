package com.kh.movie.model.vo;

public class User extends Moviekiosk{
    protected String name;
    protected int money;
    protected int age;

    public User(){

    }

    public User(String name, int money, int age){
        this.age =age;
        this.money =money;
        this.name = name;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public int getMoney() {
        return money;
    }
    public void setMoney(int money) {
        this.money = money;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
