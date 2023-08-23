package com.kh.movie.controller;

import com.kh.movie.interFace.MainInterface;
import com.kh.movie.interFace.UserInterface;
import com.kh.movie.model.vo.User;
import java.util.Scanner;

public class UserController extends User implements UserInterface {
    Scanner sc = new Scanner(System.in);
    public UserController(String name, int money, int age){
        super(name, money,age);
    }
    public UserController(){}
    @Override
    public void movieReservation(int num) {
        System.out.println(movieList.get(num-1).getMovieName() +"를 예약하시겠습니끼?"); //예외처리
        System.out.println("y/n를 입력해주세요");
        char a = sc.next().charAt(0);
        if (a == 'y'){
            checkReservation(num);
        } else if (a == 'n') {
            
        }
    };
    @Override
    public void movieinquiry() {

    }

    public void checkReservation(int num){
        int restMoney = this.money - super.movieList.get(num).getPrice();
        if ( restMoney >= 0)
            System.out.println("좌석을 선택해주세요");

        else {

        }
    }
}
