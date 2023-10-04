package com.kh.movie.view;
import com.kh.movie.controller.UserModeController;
import com.kh.movie.model.dao.UserDao;
import com.kh.movie.model.vo.UserMode;

import java.util.Scanner;

public class MainUI  {

    Scanner sc = new Scanner(System.in);



    public MainUI(){
        showMainInfo();
    }
    public void showMainInfo(){
        UserDao.resetloginStatus();
        boolean tf = true;
        while (tf) {
            int num1 = firstPage();
            switch (num1) {
                case 1:
                    if (new UserModeController().loginUser(loginUser())) {
                        if (UserDao.m2.getGrade().equals("BOSS")) {
                            new BossModeUi().bossFistUi();
                        } else {
                            new UserModeUI().successLoginUi();
                        }
                    }
                    break;
                case 2:
                    new UserModeController().createUser(createUser());
                    break;
                case 3:
                    tf = false;
                    break;
                default:
            }
        }
    }

    public int firstPage(){
        System.out.println("============영화관 키오스크 ============");
        System.out.println("1.로그인");
        System.out.println("2.회원가입");
        System.out.println("3.키오스크 종료");
        System.out.print("입력: ");
        return sc.nextInt();
    }

    public UserMode loginUser(){
        System.out.println("---------------------로그인 페이지--------------------");
        System.out.print("아이디 입력 : ");
        String userId = sc.next();
        System.out.print("비밀번호 입력: ");
        String userPwd = sc.next();
        return new UserMode(userId,userPwd);
    }

    public UserMode createUser(){
        System.out.println("-----------------회원가입 페이지-------------------");
        System.out.print("이름 입력: ");
        String userName = sc.next();
        System.out.print("아이디 입력: ");
        String userId = sc.next();
        System.out.print("비밀번호 입력: ");
        String userPwd = sc.next();
        System.out.print("나이 입력: ");
        int userAge = sc.nextInt();
        sc.nextLine();
        System.out.println("관리자 권한 부여 check(yes or no): ");
        String checked = sc.next();

        return new UserMode(userName,userId,userPwd,userAge,checked);
    }

}
