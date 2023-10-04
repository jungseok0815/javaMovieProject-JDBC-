package com.kh.movie.controller;

import com.kh.movie.model.vo.ManagerMode;
import com.kh.movie.service.MangerService;
import com.kh.movie.view.ManagerModeUI;
import java.util.ArrayList;

public class ManagerModeContoller {
    public void  addMovie(ManagerMode m1){
       boolean result = new MangerService().addMovie(m1);
       if (result){
           new ManagerModeUI().Success("영화 등록 성공");
       }else{
           new ManagerModeUI().fail("영화 등록 실패");
       }
    }

    public void showMovieList(){
        ArrayList<ManagerMode> m1 = new MangerService().showMovie();
        new ManagerModeUI().showMovieList(m1);
    }

    public void deleteMovieUi(int num){
        int result = new MangerService().deleteMovie(num);
        if (result>0){
            new ManagerModeUI().Success("영화삭제");
        }else{
            new ManagerModeUI().fail("영화삭제 실패");
        }
    }

    public void updateMovie(ManagerMode udMovie){
        int result = new MangerService().updateMovie(udMovie);
        if (result >0){
            new ManagerModeUI().Success("업데이트 성공");
        }else{
            new ManagerModeUI().fail("업데이트 실페");
        }

    }

}
