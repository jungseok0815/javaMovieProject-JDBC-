package com.kh.movie.view;
import com.kh.movie.controller.ManagerModeController;
import com.kh.movie.model.vo.ManagerMode;
import com.kh.movie.model.vo.Moviekiosk;

import java.util.*;
public class ManagerModeUI{
    Scanner sc = new Scanner(System.in);
    ManagerModeController m1 = new ManagerModeController();
    Moviekiosk kiosk = new Moviekiosk();

    public void showManagerLogin(){
        System.out.println("로그인이 필요한 모드입니다.");
        System.out.print("아이디 입력: ");
        String id = sc.next();
        System.out.print("비밀번호 입력: ");
        String password = sc.next();
        if (m1.totalCheckManager(id, password)){
            System.out.println("로그인에 성공하셨습니다.");
            showManagerInfo();
        }else {
            System.out.println("로그인에 실패라였습니다. 다시 로그인 해주세요");
        }
    }
    public void showManagerInfo(){
        boolean tf = true;
        while (tf) {
            System.out.println("1. 영화 추가");
            System.out.println("2. 영화 삭제");
            System.out.println("3. 영화 수정");
            System.out.println("4. 영화 정보확인");
            System.out.println("5. 뒤로가기");
            System.out.print("입력: ");
            int num = sc.nextInt();
            switch (num) {
                case 1:
                    addMovieUi();
                    break;
                case 2:
                    deleteMovieUi();
                    break;
                case 3:
                    insertMovieUi();
                    break;
                case 4:
                    kiosk.showMovieList();
                    break;
                case 5:
                    tf = false;
                    break;
                default:
                   return;
            }
        }
    }

    public void addMovieUi(){
        System.out.println("등록할 영화 정보를 입력해주세요");
        System.out.print("1. 영화이름: ");
        String movieName = sc.next();
        System.out.print("2. 가격:");
        int price = sc.nextInt();
        System.out.print("3. 러닝타임: ");
        int runningTime = sc.nextInt();
        System.out.print("4. 영화관람 자리 수 ");
        int movieSeat = sc.nextInt();
        m1.addMovie(movieName, price, runningTime, movieSeat);
    }
    public void deleteMovieUi(){
        kiosk.showMovieList();
        System.out.println("삭제할 영화의 번호를 선택해주세요");
        int delectnum = sc.nextInt();
        m1.delectMovie(delectnum);  //예외처리 배열에 저장된 넘 보다 클경우
    }

    public void insertMovieUi(){
        kiosk.showMovieList();
        System.out.println("변경할 영화를 선택해주세요");
        System.out.print("입력: ");
        int num2 = sc.nextInt();
        System.out.println("수정영화 이름: ");
        String str1 = sc.next();
        System.out.println("수정영화 가격");
        int num4 = sc.nextInt();
        System.out.println("수정 러닝타임");
        int num5 = sc.nextInt();
        System.out.println("수정 영화관람 자리수");
        int num6 = sc.nextInt();
        m1.insertMovie(new ManagerMode(str1, num4, num5, num6),num2);
    }


}
