package com.kh.movie.view;
import com.kh.movie.controller.UserModeController;
import com.kh.movie.model.vo.Moviekiosk;

import java.util.Scanner;

public class UserModeUI{

    UserModeController a1 = new UserModeController();
    Moviekiosk mov = new Moviekiosk();

    public UserModeUI(){

    }
    Scanner sc = new Scanner(System.in);
    public void showUserInfo(){
        boolean tf = true;
        while (tf) {
            System.out.println("1. 영화 예매  ");
            System.out.println("2. 예매 내역조회");
            System.out.println("5. 뒤로가기");
            System.out.print("입력: ");
            int num = sc.nextInt();
            switch (num) {
                case 1:
                    mov.showMovieList();
                    firuserUi();
                    break;
                case 2:
                    a1.createReservationnum();
                    break;
                case 5:
                    tf = false;;
                    break;
                default:
                    return;
            }
        }
    }

    public void firuserUi(){
        System.out.println("예매할 영확를 선택해주새요");
        System.out.print("입력 : ");
        int num1 = sc.nextInt();
        a1.movieReservation(num1);
    }








}



