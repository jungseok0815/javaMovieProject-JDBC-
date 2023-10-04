package com.kh.movie.model.vo;

public class UserMode {
    private  int userNo;
    private String userName;
    private String userId;
    private String userPwd;
    private int age;
    private String grade;
    private String status;
    private String checked;


    public UserMode(String userId, String userPwd) {
        this.userId = userId;
        this.userPwd = userPwd;
    }

    public UserMode(String userName, String userId, String userPwd, int age, String grade) {
        this.userName = userName;
        this.userId = userId;
        this.userPwd = userPwd;
        this.age = age;
        this.grade = grade;
    }

    public UserMode(int userNo, String userName, String userId, String userPwd, int age, String grade) {
        this.userNo = userNo;
        this.userName = userName;
        this.userId = userId;
        this.userPwd = userPwd;
        this.age = age;
        this.grade = grade;
    }

    public UserMode(int userNo, String userName, String userId, int age) {
        this.userNo = userNo;
        this.userName = userName;
        this.userId = userId;
        this.age = age;
    }

    @Override
    public String toString() {
        return "UserMode{" +
                "userNo=" + userNo +
                ", userName='" + userName + '\'' +
                ", userId='" + userId + '\'' +
                ", userPwd='" + userPwd + '\'' +
                ", age=" + age +
                ", grade='" + grade + '\'' +
                '}';
    }

    public int getUserNo() {
        return userNo;
    }

    public void setUserNo(int userNo) {
        this.userNo = userNo;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getChecked() {
        return checked;
    }

    public void setChecked(String checked) {
        this.checked = checked;
    }
}
