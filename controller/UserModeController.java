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
     * 회원가입을 위한 사용자의 정보를 service로 보내는 주고 결과값으로 처리하는 메소드
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

    /**
     * 서비스에게 로그인을 위해 입력받은 정보를 전달하고, 돌아오는 값을 통하여 값을 처리하는 메소드
     * @param userinfo
     * @return
     */
    public UserMode loginUser(String[] userinfo){
        UserMode result =  new userServiec().loginUser(userinfo);
       if (result != null){
            new UserModeUI().Success("로그인 성공");
           return result;
       }else {
           new UserModeUI().fail("로그인 실패");
           return null;
       }
    }

    /**
     * 서비스에게 영화전체를 보여주기 위한 요청을 부탁하고 받아오는 메소드
     */
    public void showMovie(){
        ArrayList<ManagerMode> showMovie = new userServiec().showMovie();
        new UserModeUI().showMovieList(showMovie);

    }

    /**
     * 서비스에게 영화 예약요청을 부탁하고 받아오는 값을 처리하는 메소드
     * @param num 영화선택 화면을 보고 예약한 영화
     * @param userid 현재 로그인한 사람의 userid
     * @return
     */
    public int reservation(int num,String userid){
         int result = new userServiec().reservation(num,userid);
         if (result> 0){
             new UserModeUI().Success("예약성공");
         }else {
             new UserModeUI().fail("예약실패");
         }
         return result;
    }


    /**
     * 현재 로그인되어있는 사용자에 예약 내역을 보여주기 위해 서비스에게 관련 정보를 보내는 매소드
     * @param userid
     */
    public  void  seleteReservation(String userid){
        ArrayList<String[]> reservation =  new userServiec().seleteReservation(userid);
        new UserModeUI().seleteReservation(reservation);
    }

    public void deleteReMovie(String userid,String movie){
        int result = new userServiec().deleteReMovie(userid,movie);
        if (result>0){
            new UserModeUI().Success("예약삭제성공");
        }else {
            new UserModeUI().fail("예약삭제실패");
        }
    }
}
