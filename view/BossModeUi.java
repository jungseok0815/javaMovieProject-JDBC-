package com.kh.movie.view;

import com.kh.movie.controller.BossModeController;
import com.kh.movie.controller.ManagerModeContoller;
import com.kh.movie.model.vo.ManagerMode;
import com.kh.movie.model.vo.Reservation;
import com.kh.movie.model.vo.UserMode;

import java.util.ArrayList;
import java.util.Scanner;

public class BossModeUi {
    Scanner sc = new Scanner(System.in);
    public void bossFistUi(){
        boolean tf = true;
        while (tf) {
            System.out.println("1. 관리자 등록");
            System.out.println("2. 관리자 삭제");
            System.out.println("3. 등록영화 전체확인");
            System.out.println("4. 전체 관리자 목록보기");
            System.out.println("5. 뒤로가기");
            System.out.print("입력: ");
            int num = sc.nextInt();
            switch (num) {
                case 1:
                    new BossModeController().checkUserGrade(num);
                    new BossModeController().upgradeUser(upgradeUser());
                    break;
                case 2:
                    new BossModeController().checkUserGrade(num);
                    new BossModeController().downgrade(downgrade());
                    break;
                case 3:
                    new BossModeController().allMovieList();
                    break;
                case 4:
                    new BossModeController().checkUserGrade(2);
                    break;
                case 5:
                    tf = false;
                    break;
                default:
                    return;
            }
        }
    }
    public void checkUserGrade( ArrayList<UserMode> checkUserGrade){
        if (checkUserGrade == null){
            System.out.println("매니저 신청자 없음");
        }else {
            for (UserMode i : checkUserGrade){
                System.out.println(i.getUserNo()+" "+i.getUserName()+" " + i.getUserId() +" " + i.getAge());
            }
        }
    }
    public int upgradeUser(){
        System.out.print("매니저로 등급을 올릴 유저번호 입력: ");
        return sc.nextInt();
    }
    public int downgrade(){
        System.out.println("일반유저 등급으로 내릴 유저번호입력: ");
        return sc.nextInt();
    }
    public void allMovieList(ArrayList<ManagerMode> allMovieList){
        if (allMovieList == null){
            System.out.println("현재 등록된 영화가 존재하지 않습니다.");

        }else {
            for (ManagerMode i : allMovieList){
                System.out.println(i.getMovie_no()+"번 영화 "+i.getMovieName()+"영화는 현재 \n" +
                        i.getSeat()+"자리가 남았고" + i.getUserNo()+"번 사림이 해당 영화를 등록했습니다.");
            }


        }
    }
    public void Success(String text){
        System.out.println("성공: " + text);
    }
    public void fail(String text){
        System.out.println("요청내용 실패: " + text);
    }

}
