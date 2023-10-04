package com.kh.movie.service;

import com.kh.movie.common.JDBCTemplate;
import com.kh.movie.model.dao.ManagerDao;
import com.kh.movie.model.dao.UserDao;
import com.kh.movie.model.vo.ManagerMode;
import com.kh.movie.model.vo.Reservation;
import com.kh.movie.model.vo.UserMode;
import com.kh.movie.view.UserModeUI;

import java.sql.Connection;
import java.util.ArrayList;

public class MangerService {
    public boolean addMovie(ManagerMode m1){
        Connection conn = JDBCTemplate.getConnection();
        boolean result = new ManagerDao().addMovie(conn,m1);
        JDBCTemplate.close(conn);
        return result;
    }
    public int deleteMovie(int num){
        Connection conn = JDBCTemplate.getConnection();
        int result  =new ManagerDao().deleteMovie(conn,num);
        if(result > 0){
            JDBCTemplate.commit(conn);
        }else {
            JDBCTemplate.close(conn);
        }
        JDBCTemplate.close(conn);
        return result;
    }
    public ArrayList<ManagerMode> showMovie(){
        Connection conn = JDBCTemplate.getConnection();
        ArrayList<ManagerMode> showMovie =new ManagerDao().showMovie(conn);
        JDBCTemplate.close(conn);
        return showMovie;
    }
    public int updateMovie(ManagerMode udMovie){
        Connection conn = JDBCTemplate.getConnection();
        int result  = new ManagerDao().updateMovie(conn,udMovie);
        if(result > 0){
            JDBCTemplate.commit(conn);
        }else {
            JDBCTemplate.close(conn);
        }
        JDBCTemplate.close(conn);
        return result;
    }

}
