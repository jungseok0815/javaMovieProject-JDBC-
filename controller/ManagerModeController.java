package com.kh.movie.controller;
import com.kh.movie.interFace.ManagerInterface;
import com.kh.movie.model.vo.ManagerMode;
import com.kh.movie.model.vo.Moviekiosk;

//public class ManagerModeController implements ManagerInterface {
////    ManagerMode m1 = new ManagerMode();
////    @Override
////    public boolean totalCheckManager(String id, String password) {return checkId(id) && checkpassword(password);}
////
////    @Override
////    public boolean checkId(String id){  //예와처리
////        return id.equals(m1.getId());
////    }
////    @Override
////    public boolean checkpassword(String password){return password.equals(m1.getPassword());}
////    @Override
////    public void addMovie(String name, int price, int runningTime,int num){
////        Moviekiosk.getMovieList().add(new ManagerMode(name,price,runningTime,num));
////        System.out.println("성공적으로 영화 등록이 완료되었습니다.");
////    }
////    @Override
////    public void delectMovie(int num){
////       Moviekiosk.getMovieList().remove(num-1);
////        System.out.println("삭제처리 완료되었습니다.");
////    }
////    @Override
////    public void insertMovie(ManagerMode indexToModify, int newValue){
////        Moviekiosk.getMovieList().set(newValue-1,indexToModify);
////    }
//}
