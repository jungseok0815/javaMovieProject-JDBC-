package com.kh.movie.controller;

import com.kh.movie.model.dao.BossDao;
import com.kh.movie.model.vo.ManagerMode;
import com.kh.movie.model.vo.UserMode;
import com.kh.movie.service.BossService;
import com.kh.movie.view.BossModeUi;

import java.util.ArrayList;

public class BossModeController {
    public void checkUserGrade(int num){
        ArrayList<UserMode> checkUserGrade = new BossService().checkUserGrade(num);
        new BossModeUi().checkUserGrade(checkUserGrade);
    }
    public void upgradeUser(int num){
        int result = new BossService().upgradeUser(num);
        if (result > 0){
            new BossModeUi().Success("등급 업그레이드 성공");
        }else{
            new BossModeUi().fail(("등급 업그레이드 실패"));
        }
    }
    public void downgrade(int num){
        int result = new BossService().downgrade(num);
        if (result > 0){
            new BossModeUi().Success("등급 내리기 성공");
        }else{
            new BossModeUi().fail(("등급 내리기 실패"));
        }
    }
    public void allMovieList(){
        ArrayList<ManagerMode> allMovieList =new BossService().allMovieList();
        new BossModeUi().allMovieList(allMovieList);
    }
}
