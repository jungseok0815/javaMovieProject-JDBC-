package com.kh.movie.model.dao;

import com.kh.movie.common.JDBCTemplate;
import com.kh.movie.model.vo.ManagerMode;
import com.kh.movie.model.vo.UserMode;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserDao {
    /**
     * user계정을 생성하는 메소드
     * @param conn
     * @param m
     * @return
     */
    public int createUser(Connection conn, UserMode m){
        int result = 0;
        PreparedStatement pstmt = null;
        String sql = "Insert into user values(seq_userno.nextval, ?,?,?,?,sysdate)";
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, m.getName());
            pstmt.setString(2, m.getUserId());
            pstmt.setString(3, m.getUserPwd());
            pstmt.setInt(4, m.getAge());
            result = pstmt.executeUpdate();
            System.out.println(result);
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            JDBCTemplate.close(pstmt);
        }

        return result;
    }

    public Boolean loginUser(Connection conn, String[] userinfo){
        ResultSet rset;
        PreparedStatement pstmt = null;
        String sql = "select userid, userpwd from user where userid = ? && userpwd = ?";
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, userinfo[0]);
            pstmt.setString(2, userinfo[1]);

            rset = pstmt.executeQuery();
            System.out.println(rset);
            if (rset == null){
                return false;
            }else {
                return  true;
            }
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            JDBCTemplate.close(pstmt);
        }
    }

    public ArrayList<ManagerMode> showMovie(Connection conn){
        ResultSet rset;
        PreparedStatement pstmt = null;
        String sql = "select * from movie";
        ArrayList<ManagerMode> movieList = new ArrayList<>();
        try {
            pstmt = conn.prepareStatement(sql);
            rset = pstmt.executeQuery();
            System.out.println(rset);
            while (rset.next()){
                movieList.add(new ManagerMode(rset.getString("moviename"),rset.getInt("seat"),
                        rset.getInt("runningTime")));
            }
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            JDBCTemplate.close(pstmt);
        }
        return movieList;
    }

    public int  reservation(Connection conn, int num, String userid){
        int result = 0;
        PreparedStatement pstmt = null;
        String sql = "Insert into reservation  values(?,?)";
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, num);
            pstmt.setString(2, userid);

            result = pstmt.executeUpdate();
            System.out.println(result);
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            JDBCTemplate.close(pstmt);
        }

        return result;
    }

}
