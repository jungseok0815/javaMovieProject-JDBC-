package com.kh.movie.controller;


import com.kh.movie.model.vo.ManagerMode;
import com.kh.movie.model.vo.Reservation;
import com.kh.movie.model.vo.UserMode;
import com.kh.movie.service.*;
import com.kh.movie.view.UserModeUI;
import java.util.ArrayList;
import java.util.Scanner;

public class UserModeController {

    public boolean loginUser(UserMode m1){
        boolean result =  new userServiec().loginUser(m1);
       if (result){
               new UserModeUI().Success("로그인 성공");
               return result;
           }else {
               new UserModeUI().fail("로그인 실패");
           return result;
       }
    }
    public void createUser(UserMode m2){
        int result = new userServiec().createUser(m2);
        if (result>0){
            new UserModeUI().Success("회원가입 성공");
        }else {
            new UserModeUI().fail("회원가입 실패");
        }
    }
    public boolean showMovie(){
        ArrayList<ManagerMode> showMovie = new userServiec().showMovie();
        return new UserModeUI().showMovieList(showMovie);
    }
    public boolean reservation(String rvMovieName){
         boolean result = new userServiec().reservation(rvMovieName);
         if (result){
             new UserModeUI().Success("예약성공");
         }else {
             new UserModeUI().fail("예약실패");
         }
         return result;
    }
    public void deleteReMovie(int rv_num){
        int result = new userServiec().deleteReMovie(rv_num);
        if (result>0){
            new UserModeUI().Success("예약삭제성공");
        }else {
            new UserModeUI().fail("예약삭제실패");
        }
    }
    public  void  seleteReservation(){
        ArrayList<Reservation> reservation =  new userServiec().seleteReservation();
        new UserModeUI().seleteReservation(reservation);
    }


}
