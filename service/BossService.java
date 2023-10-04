package com.kh.movie.service;

import com.kh.movie.common.JDBCTemplate;
import com.kh.movie.model.dao.BossDao;
import com.kh.movie.model.dao.ManagerDao;
import com.kh.movie.model.dao.UserDao;
import com.kh.movie.model.vo.ManagerMode;
import com.kh.movie.model.vo.UserMode;

import java.sql.Connection;
import java.util.ArrayList;

public class BossService {
    public ArrayList<UserMode> checkUserGrade(int num){
        Connection conn = JDBCTemplate.getConnection();
        ArrayList<UserMode> checkUserGrade =new BossDao().checkUserGrade(num,conn);
        JDBCTemplate.close(conn);
        return checkUserGrade;
    }

    public int upgradeUser(int num){
        Connection conn = JDBCTemplate.getConnection();
        int result =  new BossDao().upgradeUser(conn,num);
        if(result > 0){
            JDBCTemplate.commit(conn);
        }else {
            JDBCTemplate.close(conn);
        }
        JDBCTemplate.close(conn);

        return result;
    }

    public int downgrade(int num){
        Connection conn = JDBCTemplate.getConnection();
        int result =  new BossDao().downgrade(conn,num);
        if(result > 0){
            JDBCTemplate.commit(conn);
        }else {
            JDBCTemplate.close(conn);
        }
        JDBCTemplate.close(conn);

        return result;
    }

    public ArrayList<ManagerMode> allMovieList(){
        Connection conn = JDBCTemplate.getConnection();
        ArrayList<ManagerMode> allMovieList =new BossDao().allMovieList(conn);
        JDBCTemplate.close(conn);
        return allMovieList;
    }
}
