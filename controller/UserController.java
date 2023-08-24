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
        System.out.print("y/n를 입력해주세요");
        char a = sc.next().charAt(0);
        if (a == 'y'){
            showSeat(num-1);
            System.out.println("\n자리를 선택해주세요: ");
            int num2 = sc.nextInt(); //예외처리
            choiceSeat(num-1,num2);
        } else{
            System.out.println("영화 예매가 취소되었습니다.");
        }
    }
    @Override
    public void movieinquiry() {

    }

    public void showSeat(int num){
        System.out.println("================화면=================");
        int[] seat = super.getMovieList().get(num).getMovieSeat();
        for (int i = 1; i<=seat.length; i++){
            System.out.print(getMovieList().get(num).getMovieSeat()[i-1]+" ");
            if (i % 10 == 0) {
                    System.out.println();
            }
        }
        System.out.println("====================================");
    }

    public void choiceSeat(int num, int num2){
        getMovieList().get(num).getMovieSeat()[num2-1] = 0;
        showSeat(num);
        System.out.println("영화 예매가 완료되었습니다.");
    }

    public boolean checkReservation(int num){
        int restMoney = this.money - super.movieList.get(num).getPrice();
        if ( restMoney >= 0){ super.setMoney(restMoney); return true;}
        else {return false;}
    }

    public void createReservationnum(){

    }
}
