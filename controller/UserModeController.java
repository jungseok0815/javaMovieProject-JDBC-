package com.kh.movie.controller;

import com.kh.movie.interFace.UserInterface;
import com.kh.movie.model.vo.Moviekiosk;
import com.kh.movie.model.vo.UserMode;
import java.util.Scanner;

public class UserModeController implements UserInterface {
    Moviekiosk mov = new Moviekiosk();
    UserMode a1 = new UserMode();

    Scanner sc = new Scanner(System.in);

    public UserModeController(){}
    @Override
    public void movieReservation(int num) {
        System.out.println(mov.getMovieList().get(num-1).getMovieName() +"를 예약하시겠습니끼?"); //예외처리
        System.out.print("y/n를 입력해주세요");
        char a = sc.next().charAt(0);
        if (a == 'y'){
            createUserInfo(mov.getMovieList().get(num-1).getMovieName());
            showSeat(num-1);
        } else{
            System.out.println("영화 예매가 취소되었습니다.");
        }
    }
    @Override
    public void movieinquiry() {

    }

    public void showSeat(int num){
        System.out.println("================화면=================");
        for (int i = 1; i<= mov.getMovieList().get(num).getMovieSeat().length; i++){
            System.out.print(mov.getMovieList().get(num).getMovieSeat()[i-1]+" ");
            if (i % 10 == 0) {
                    System.out.println();
            }
        }
        System.out.println("====================================");
        System.out.println("\n자리를 선택해주세요: ");
        int num2 = sc.nextInt(); //예외처리
        choiceSeat(num,num2);

    }
    public  void showUserList(){
        for (int i=0; i<a1.getUserInfo().size(); i++){
            System.out.println(a1.getUserInfo().get(i).toString());
        }
    }

    public void choiceSeat(int num, int num2){
        mov.getMovieList().get(num).getMovieSeat()[num2-1] = 0;
//        showSeat(num);
        System.out.println("영화 예매가 완료되었습니다.");
    }

    public void createUserInfo(String movieName){
        System.out.println("사용자 정보를 입력해주세요");
        System.out.println("이름 : ");
        String name = sc.next();
        System.out.println("나이 : ");
        int age = sc.nextInt();

        a1.getUserInfo().add(new UserMode(name, age, movieName));
    }


    public void createReservationnum(){
        showUserList();
        System.out.println("사용자 정보를 입력해주세요");
        System.out.println("이름 : ");
        String name = sc.nextLine();
        System.out.println("나이 : ");
        int age = sc.nextInt();
        boolean tf = false;

        for (UserMode a : a1.getUserInfo()){
            if(a.getName() == name && a.getAge() == age) {
                System.out.println(a1.getUserInfo().toString());
                tf = true;
            }
        }
        if (tf == false){
            System.out.println("예약된 영화가 존재하지 않습니다.");
        }
    }
}
