package com.kh.movie.service;

import com.kh.movie.common.JDBCTemplate;
import com.kh.movie.model.dao.UserDao;
import com.kh.movie.model.vo.ManagerMode;
import com.kh.movie.model.vo.Reservation;
import com.kh.movie.model.vo.UserMode;

import java.sql.Connection;
import java.util.ArrayList;

public class userServiec {
    public boolean loginUser(UserMode m1){
        Connection conn = JDBCTemplate.getConnection();
        boolean result = new UserDao().loginUser(conn,m1);
        JDBCTemplate.close(conn);
        return result;
    }
    public int createUser(UserMode m2){
        Connection conn = JDBCTemplate.getConnection();
        int result  =new UserDao().createUser(conn,m2);
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
        ArrayList<ManagerMode> showMovie =new UserDao().showMovie(conn);
        JDBCTemplate.close(conn);
        return showMovie;
    }
    public boolean reservation(String rvMovieName){
        Connection conn = JDBCTemplate.getConnection();
        boolean result  =new UserDao().reservation(conn,rvMovieName);
        if(result){
            JDBCTemplate.commit(conn);
        }else {
            JDBCTemplate.close(conn);
        }
        JDBCTemplate.close(conn);
        return result;
    }

    public  ArrayList<Reservation>   seleteReservation(){
        Connection conn = JDBCTemplate.getConnection();
        ArrayList<Reservation> reservation =  new UserDao().seleteReservation(conn);
        return reservation;
    }
    public  int deleteReMovie(int rv_num){
        Connection conn = JDBCTemplate.getConnection();

        int result =  new UserDao().deleteReMovie(conn,rv_num);
        if(result > 0){
            JDBCTemplate.commit(conn);
        }else {
            JDBCTemplate.close(conn);
        }
        JDBCTemplate.close(conn);

        return result;
    }



}
