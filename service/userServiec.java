package com.kh.movie.service;

import com.kh.movie.common.JDBCTemplate;
import com.kh.movie.model.dao.UserDao;
import com.kh.movie.model.vo.ManagerMode;
import com.kh.movie.model.vo.UserMode;

import java.sql.Connection;
import java.util.ArrayList;

public class userServiec {
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

    public boolean loginUser(String[] userinfo){
        Connection conn = JDBCTemplate.getConnection();
        boolean result = new UserDao().loginUser(conn,userinfo);
        JDBCTemplate.close(conn);
        return result;
    }

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

}
