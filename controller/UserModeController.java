package com.kh.movie.controller;


import com.kh.movie.model.vo.ManagerMode;

import com.kh.movie.model.vo.UserMode;
import com.kh.movie.service.*;
import com.kh.movie.view.UserModeUI;
import java.util.ArrayList;
import java.util.Scanner;

public class UserModeController {
    Scanner sc = new Scanner(System.in);


    /**
     * 사용자의 정보를 service로 보내는 주고 결과값으로 처리하는 메소드
     * @param userid :사용자입력 아이디
     * @param userPwd: 사용자입력 패스워드
     * @param userName: 사용자입력 이름
     * @param userAge: 사용자입력 나이
     */
    public void createUser(String userid,String userPwd,String userName, int userAge){
        UserMode user1 = new UserMode(userName,userid,userPwd,userAge);
        int result = new userServiec().createUser(user1);
            if (result>0){
                new UserModeUI().Success("회원가입 성공");
        }else {
            new UserModeUI().fail("회원가입 실패");
        }
    }

    public boolean loginUser(String[] userinfo){
       boolean result =  new userServiec().loginUser(userinfo);
       if (result){
           new UserModeUI().Success("로그인성공");
           return true;
       }else {
           new UserModeUI().fail("로그인실패");
           return false;
       }
    }

    public void showMovie(){
        ArrayList<ManagerMode> showMovie = new userServiec().showMovie();
        new UserModeUI().showMovieList(showMovie);

    }

    public int reservation(int num,String userid){
         int result = new userServiec().reservation(num,userid);
         if (result> 0){
             new UserModeUI().Success("예약성공");
         }else {
             new UserModeUI().fail("예약실패");
         }
         return result;
    }




}
