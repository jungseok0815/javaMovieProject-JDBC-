package com.kh.movie.interFace;

import com.kh.movie.model.vo.ManagerMode;

public interface ManagerInterface {

    //아이디, 비밀번호 확인
    boolean totalCheckManager(String id, String password);
    boolean checkId(String id);
    boolean checkpassword(String password);
    //관리자모드에서 영화 추가
    void addMovie(String name, int price, int runningTime,int num);
    //영화 수정
    void insertMovie(ManagerMode indexToModify, int newValue);
    //영화 삭제
    void delectMovie(int num);
}
