package com.kh.movie.controller;

import com.kh.movie.interFace.UserInterface;
import com.kh.movie.model.vo.Moviekiosk;
import com.kh.movie.model.vo.UserMode;
import java.util.Scanner;

public class UserModeController implements UserInterface {
    Scanner sc = new Scanner(System.in);

    public UserModeController(){}
    @Override
    public void movieReservation(int num) {
        System.out.println(Moviekiosk.getMovieList().get(num-1).getMovieName() +"를 예약하시겠습니끼?"); //예외처리
        System.out.print("y/n를 입력해주세요");
        char a = sc.next().charAt(0);
        if (a == 'y'){
            createUserInfo(Moviekiosk.getMovieList().get(num-1).getMovieName());
            showSeat(num-1);
        } else{
            System.out.println("영화 예매가 취소되었습니다.");
        }
    }

    @Override
    public void movieinquiry(String movieName, String name, int age) {
        showUserList();
        boolean tf = false;
        for (UserMode a : Moviekiosk.getUserInfo()){
            System.out.println(a.getName());
            if(a.getName().equals(name)  && a.getAge() == age && a.getMovieName().equals(movieName)) {
                System.out.println(Moviekiosk.getUserInfo().toString() + "예약내역이 있습니다.");
                tf = true;
                break;
            }
        }
        if (tf == false){
            System.out.println("예약된 영화가 존재하지 않습니다.");
        }
    }

    public void showSeat(int num){
        System.out.println("================화면=================");
        for (int i = 1; i<= Moviekiosk.getMovieList().get(num).getMovieSeat().length; i++){
            System.out.print(Moviekiosk.getMovieList().get(num).getMovieSeat()[i-1]+" ");
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
        for (int i=0; i<Moviekiosk.getUserInfo().size(); i++){
            System.out.println(Moviekiosk.getUserInfo().get(i).toString());
        }
    }

    public void choiceSeat(int num, int num2){
        Moviekiosk.getMovieList().get(num).getMovieSeat()[num2-1] = "자리없음";
//        showSeat(num);
        System.out.println("영화 예매가 완료되었습니다.");
    }

    public void createUserInfo(String movieName){
        System.out.println("사용자 정보를 입력해주세요");
        System.out.println("이름 : ");
        String name = sc.next();
        System.out.println("나이 : ");
        int age = sc.nextInt();
        Moviekiosk.getUserInfo().add(new UserMode(name, age, movieName));
    }

}
