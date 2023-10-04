package com.kh.movie.model.dao;

import com.kh.movie.common.JDBCTemplate;
import com.kh.movie.model.vo.ManagerMode;
import com.kh.movie.model.vo.UserMode;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BossDao {
    public ArrayList<UserMode> checkUserGrade(int num, Connection conn){
        ResultSet rset;
        PreparedStatement pstmt = null;
        String sql = "select * from cinema_user where checked = 'YSE' ";
        String sql2 = "select * from cinema_user where user_grade = 'MANGER'";

        ArrayList<UserMode> checkUserGrade = new ArrayList<>();
        try {
            if (num == 1){
                pstmt = conn.prepareStatement(sql);
                rset = pstmt.executeQuery();

            }else{
                pstmt = conn.prepareStatement(sql2);
                rset = pstmt.executeQuery();

            }


            while (rset.next()){
                checkUserGrade.add(new UserMode(
                        rset.getInt("user_no"),
                        rset.getString("user_name"),
                        rset.getString("user_id"),
                        rset.getInt("user_age")
                        ));
            }

        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            JDBCTemplate.close(pstmt);
        }
        return checkUserGrade;

    }
    public int upgradeUser(Connection conn, int num){
        int result = 0;
        PreparedStatement pstmt = null;
        String sql = "update cinema_user set user_grade = 'MANGER', checked = 'NO' where USER_NO = (select user_no from cinema_user where checked = 'YSE' AND USER_NO = ?)";
            try {
                pstmt = conn.prepareStatement(sql);
                pstmt.setInt(1,num);
                result = pstmt.executeUpdate();

        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            JDBCTemplate.close(pstmt);
        }
        return result;
    }
    public int downgrade(Connection conn,int num){
        int result = 0;
        PreparedStatement pstmt = null;
        String sql = "update cinema_user set user_grade = 'USER' where USER_NO = (select user_no from cinema_user where user_grade = 'MANGER'  AND USER_NO = ?)";
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,num);
            result = pstmt.executeUpdate();
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            JDBCTemplate.close(pstmt);
        }
        return result;
    }
    public ArrayList<ManagerMode> allMovieList(Connection conn){
        ResultSet rset;
        PreparedStatement pstmt = null;
        String sql = "select * from cinema_movie";

        ArrayList<ManagerMode> allMovieList = new ArrayList<>();
        try {
            pstmt = conn.prepareStatement(sql);
            rset = pstmt.executeQuery();

            while (rset.next()){
                allMovieList.add(new ManagerMode(
                        rset.getString("mv_name"),
                        rset.getInt("mv_sratnum"),
                        rset.getInt("mv_no"),
                        rset.getInt("user_no"),
                        rset.getDate("mv_date")
                ));
            }

        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            JDBCTemplate.close(pstmt);
        }
        return allMovieList;

    }


}
