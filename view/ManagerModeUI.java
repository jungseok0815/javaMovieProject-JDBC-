package com.kh.movie.view;
import com.kh.movie.controller.ManagerModeContoller;
import com.kh.movie.model.vo.ManagerMode;

import java.util.*;
public class ManagerModeUI{
    Scanner sc = new Scanner(System.in);

    public void showManagerInfo(){
        boolean tf = true;
        while (tf) {
            System.out.println("1. 영화 추가");
            System.out.println("2. 영화 삭제");
            System.out.println("3. 영화 수정");
            System.out.println("4. 등록영화 전체확인");
            System.out.println("5. 뒤로가기");
            System.out.print("입력: ");
            int num = sc.nextInt();
            switch (num) {
                case 1:
                    new ManagerModeContoller().addMovie(addMovieUi());
                    break;
                case 2:
                    new ManagerModeContoller().deleteMovieUi(deleteMovieUi());
                    break;
                case 3:
                    new ManagerModeContoller().updateMovie(updateMovieUi());
                    break;
                case 4:
                    new ManagerModeContoller().showMovieList();
                    break;
                case 5:
                    tf = false;
                    break;
                default:
                   return;
            }
        }
    }

    public ManagerMode addMovieUi(){
        System.out.println("등록할 영화 정보를 입력해주세요");
        System.out.print("1. 영화이름: ");
        String movieName = sc.next();
        System.out.print("2. 영화관람 자리 수: ");
        int seatNum = sc.nextInt();
        ManagerMode m1 = new ManagerMode(movieName,seatNum);
        return m1;
    }
    public int deleteMovieUi(){
        System.out.print("삭제할 영화의 번호를 선택해주세요 :");
        return sc.nextInt();
    }
    public ManagerMode updateMovieUi(){
        System.out.println("변경할 영화번호를 선택해주세요");
        System.out.print("입력: ");
        int movieNum = sc.nextInt();
        System.out.print("수정영화 이름: ");
        String movieName = sc.next();
        System.out.print("수정 영화관람 자리수: ");
        int seatNum = sc.nextInt();
        return new ManagerMode(movieName, seatNum, movieNum);
    }
    public void showMovieList(ArrayList<ManagerMode> m1){
        if (m1 == null){
            System.out.println("현재 등록된 영화가 존재하지 않습니다.");
        }else {
            for (ManagerMode i : m1){
                System.out.println("영화번호: "+i.getMovie_no()+" "+ i.getMovieName() +" 영화를 " + i.getDate()+"에 등록했습니다");
                System.out.println("남은 자리는: "+ i.getSeat() + "입니다.");
            }
        }
    }

//=========================================================================
    public void Success(String text){
    System.out.println(" 성공: " + text);
}
    public void fail(String text){
        System.out.println("요청내용 실패: " + text);
    }
}
