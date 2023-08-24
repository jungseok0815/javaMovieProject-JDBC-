package com.kh.movie.view;
import com.kh.movie.controller.UserController;
import com.kh.movie.model.vo.Manager;

import java.util.Scanner;

public class UserUI extends UserController {

    public UserUI(){

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
                    super.showMovieList();
                    firuserUi();
                    break;
                case 2:

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
        movieReservation(num1);
    }








}



