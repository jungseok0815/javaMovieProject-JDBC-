package com.kh.movie.view;
import com.kh.movie.controller.UserModeController;
import com.kh.movie.model.vo.ManagerMode;
import com.kh.movie.model.vo.Moviekiosk;
import com.kh.movie.model.vo.UserMode;

import java.util.ArrayList;
import java.util.Scanner;

public class UserModeUI{
    Scanner sc = new Scanner(System.in);
    UserModeController a1 = new UserModeController();

    UserMode user;



    public UserModeUI(){

    }

    public void fistUserUi(){
        boolean tf = true;
        while (tf) {
            System.out.println("1. 회원 로그인");
            System.out.println("2. 회원가입");
            System.out.println("5. 뒤로가기");
            int num = sc.nextInt();
            switch (num) {
                case 1:
                    if (new UserModeController().loginUser(loginUser())!=null){
                        user = new UserModeController().loginUser(loginUser());
                        successLoginUi();
                    }else {
                        tf = false;;
                    }
                    break;
                case 2:
                    joinUser();
                    break;
                case 3:

                    break;
                case 5:
                    tf = false;;
                    break;
                default:
                    return;
            }
        }
    }

    public void successLoginUi(){
        boolean tf = true;
        while (tf) {
            System.out.println("1. 영화예약");
            System.out.println("2. 예약취소");
            System.out.println("3. 에약검색");
            System.out.println("4. 사용자 정보 변경");
            int num = sc.nextInt();
            switch (num) {
                case 1:
                    new UserModeController().showMovie();
                    reservation();
                    break;
                case 2:

                    new UserModeController().deleteReMovie(user.getUserId(),deleterReMocie());
                    break;
                case 3:
                    new UserModeController().seleteReservation(user.getUserId());
                    break;
                case 4:

                case 5:
                    tf = false;;
                    break;
                default:
                    return;
            }
        }
    }

    /**
     * 회원가입을 위해 필요한 정보들을 입력받는 메소드
     */
    public void joinUser(){
        System.out.print("회원 아이디: ");
        String userid = sc.nextLine();
        System.out.print("회원 비밀번호 : ");
        String userPwd = sc.nextLine();
        System.out.print("회원 이름: ");
        String userName = sc.nextLine();
        System.out.print("회원 나이: ");
        int userAge = sc.nextInt();
        new UserModeController().createUser(userid,userPwd,userName,userAge);
    }

    /**
     * 로그인처리를 위해서 정보를 입력받는 메소드
     * @return
     */
    public String[] loginUser(){
        System.out.print("아이디 입력: ");
        String userid = sc.nextLine();
        System.out.print("비밀번호 입력: ");
        String userPwd = sc.nextLine();

        String[] logininfo = new String[2];
        logininfo[0] =userid;
        logininfo[1] =userPwd;

        return logininfo;
    }

    /**
     * 현재 등록되어있는 movieList전체를 가져와 화면에 띄우는 메소드
     * @param showMovie
     */
    public void showMovieList(ArrayList<ManagerMode> showMovie){
        if (showMovie == null){
            System.out.println("현재 등록된 영화가 존재하지 않습니다.");
        }else {
            for (ManagerMode i : showMovie){
                System.out.println(i.toString());
            }
        }
    }

    /**
     * 영화 예약을 위해서 영화를 입력받는 메소드
     */
    public void reservation(){
        System.out.println("영화선택 : ");
        int num = sc.nextInt();
        new UserModeController().reservation(num,user.getUserId());
    }

    /**
     * 예약내역을 전달받아서 화면에 출력하는 메소드
     * @param showrReservationList
     */
    public void seleteReservation(ArrayList<String[]> showrReservationList){
        if (showrReservationList == null){
            System.out.println("예약 내역 없음.");
        }else {
            for (String[] i : showrReservationList){
                System.out.println(i.toString());
            }
        }
    }

    public String deleterReMocie(){
        System.out.println("삭제할 영화를 입력해주세여: ");
        return sc.nextLine();
    }
















    ///////////////////////////////////////결과값 화면//////////////////////
    public void Success(String text){
        System.out.println(" 성공: " + text);
    }
    public void fail(String text){
        System.out.println("요청내용 실패: " + text);
    }





}



