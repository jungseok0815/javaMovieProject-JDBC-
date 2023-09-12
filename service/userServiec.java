package com.kh.movie.service;

import com.kh.movie.common.JDBCTemplate;
import com.kh.movie.model.dao.UserDao;
import com.kh.movie.model.vo.ManagerMode;
import com.kh.movie.model.vo.UserMode;

import java.sql.Connection;
import java.util.ArrayList;

public class userServiec {

    /**
     * 서버와 데이터베이스를 연결시켜주고 dao에서 회원가입을 요청하는 맴소드
     * @param m
     * @return
     */
    public int createUser(UserMode m){
        Connection conn = JDBCTemplate.getConnection();
        int result = new UserDao().createUser(conn,m);
        if(result > 0){
            JDBCTemplate.commit(conn);
        }else {
            JDBCTemplate.close(conn);
        }
        JDBCTemplate.close(conn);

        return result;
    }

    /**
     * 서버와 데이터베이스를 연결시켜주고 dao에게 로그인을 요청하는 메소드
     * @param userinfo : 입력받은 아이디와 비밀번호 가지고 있는 String배열
     * @return
     */
    public UserMode loginUser(String[] userinfo){
        Connection conn = JDBCTemplate.getConnection();
        UserMode result = new UserDao().loginUser(conn,userinfo);
        JDBCTemplate.close(conn);
        return result;
    }

    /**
     * 서버와 데이터베이스를 연결시켜주고 dao에게 등록된 전체 영화 목록을 보여주기 위한 메소드
     * @return
     */
    public ArrayList<ManagerMode>  showMovie(){
        Connection conn = JDBCTemplate.getConnection();
        ArrayList<ManagerMode> showMovie =new UserDao().showMovie(conn);
        JDBCTemplate.close(conn);
        return showMovie;
    }

    public int reservation(int num,String userid){
        Connection conn = JDBCTemplate.getConnection();
        int result  =new UserDao().reservation(conn,num, userid);
        if(result > 0){
            JDBCTemplate.commit(conn);
        }else {
            JDBCTemplate.close(conn);
        }
        JDBCTemplate.close(conn);
        return result;
    }

    public  ArrayList<String[]>   seleteReservation(String userid){
        Connection conn = JDBCTemplate.getConnection();
        ArrayList<String[]> reservation =  new UserDao().seleteReservation(conn, userid);
        return reservation;
    }
    public  int deleteReMovie(String userid, String movie){
        Connection conn = JDBCTemplate.getConnection();
        int result =  new UserDao().deleteReMovie(conn, userid, movie);
        if(result > 0){
            JDBCTemplate.commit(conn);
        }else {
            JDBCTemplate.close(conn);
        }
        JDBCTemplate.close(conn);

        return result;
    }



}
