package com.kh.movie.view;
import com.kh.movie.controller.UserModeController;
import com.kh.movie.model.dao.UserDao;
import com.kh.movie.model.vo.ManagerMode;
import com.kh.movie.model.vo.Reservation;
import com.kh.movie.model.vo.UserMode;

import java.util.ArrayList;
import java.util.Scanner;

public class UserModeUI{
    Scanner sc = new Scanner(System.in);
    public void successLoginUi(){
        boolean tf = true;
        while (tf) {
            System.out.println("1. 영화예약");
            System.out.println("2. 예매검색");
            System.out.println("3. 예매취소");
            System.out.println("4. 관리자모드로 접근");
            System.out.println("5. 로그아웃");
            System.out.print("입력: ");
            int num = sc.nextInt();
            switch (num) {
                case 1:
                    if (new UserModeController().showMovie()){
                        reservation();
                    }else{
                        return;
                    }
                    break;
                case 2:
                    new UserModeController().seleteReservation();
                    break;
                case 3:
                    new UserModeController().seleteReservation();
                    new UserModeController().deleteReMovie(deleterReMocie());
                    break;
                case 4:
                    if (UserDao.m2.getGrade().equals("MANGER")){
                        new ManagerModeUI().showManagerInfo();
                    }else{
                        System.out.println("일반 사용자는 접근할 수 없습니다.");
                        break;
                    }
                    break;
                case 5:
                    UserDao.m2 = null;
                    System.out.println(UserDao.m2);
                    return;
                default:
                    return;
            }
        }
    }

    public boolean showMovieList(ArrayList<ManagerMode> showMovie){
        if (showMovie == null){
            System.out.println("현재 등록된 영화가 존재하지 않습니다.");
            return false;
        }else {
            for (ManagerMode i : showMovie){
                System.out.println(i.getMovieName() +",남은 자리는 : " + i.getSeat());
            }
            return true;

        }
    }
    public void reservation(){
        System.out.println("예매할 영화 이름 입력 : ");
        String rvMovieName = sc.next();
        new UserModeController().reservation(rvMovieName);
    }
    public void seleteReservation(ArrayList<Reservation> showrReservationList){
        if (showrReservationList == null){
            System.out.println("예약 내역 없음.");
        }else {
            for (Reservation i : showrReservationList){
                System.out.println(i.getUserName()+"님이 얘매하신 예매번호 "+i.getRvNum()+" 영화 : "+i.getMovieName());
            }
        }
    }
    public int deleterReMocie(){
        System.out.println("삭제할 영화의 예매번호를 입력해주세요:  ");
        return sc.nextInt();
    }




    ///////////////////////////////////////결과값 화면//////////////////////
    public void Success(String text){
        System.out.println(" 성공: " + text);
    }
    public void fail(String text){
        System.out.println("요청내용 실패: " + text);
    }





}



