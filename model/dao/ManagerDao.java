package com.kh.movie.model.dao;

import com.kh.movie.common.JDBCTemplate;
import com.kh.movie.model.vo.ManagerMode;
import com.kh.movie.model.vo.UserMode;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ManagerDao {
    public boolean addMovie(Connection conn,ManagerMode m1){
        int result = 0;
        PreparedStatement pstmt = null;
        boolean a;
        String sql = "insert into cinema_movie values(seq_movie.nextval,?,sysdate,?,?)";

        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, m1.getMovieName());
            pstmt.setInt(2, m1.getSeat());
            pstmt.setInt(3, UserDao.m2.getUserNo());
            result = pstmt.executeUpdate();

            a = result > 0 ?  true : false;
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            JDBCTemplate.close(pstmt);
        }
        return a;
    }
    public ArrayList<ManagerMode> showMovie(Connection conn){
        ResultSet rset;
        PreparedStatement pstmt = null;
        ArrayList<ManagerMode> movieList = new ArrayList<>();
        String sql = "select * from cinema_movie where user_no = ?";;
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, UserDao.m2.getUserNo());
            rset = pstmt.executeQuery();

            while (rset.next()){
                ManagerMode m1 = new ManagerMode(rset.getString("mv_name"), rset.getInt("mv_sratnum") ,rset.getInt("mv_no"),
                        rset.getInt("user_no"), rset.getDate("mv_date")
                        );
                movieList.add(m1);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            JDBCTemplate.close(pstmt);
        }
        return movieList;
    }
    public int deleteMovie(Connection conn, int num){
        int result;
        PreparedStatement pstmt = null;
        String sql = "delete cinema_movie where mv_no = ? and user_no = ?";
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,num);
            pstmt.setInt(2, UserDao.m2.getUserNo());
            result = pstmt.executeUpdate();
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            JDBCTemplate.close(pstmt);
        }


        return  result;
    }
    public int updateMovie(Connection conn, ManagerMode udMovie){
        int result=0;
        PreparedStatement pstmt = null;
        String sql = "update cinema_movie set mv_name = ?, mv_sratnum = ? where mv_no = ? and user_no =?";
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, udMovie.getMovieName());
            pstmt.setInt(2, udMovie.getSeat());
            pstmt.setInt(3, udMovie.getMovie_no());
            pstmt.setInt(4, UserDao.m2.getUserNo());

            result = pstmt.executeUpdate();
            System.out.println(udMovie.getMovieName() + "" +udMovie.getSeat() +" " +udMovie.getMovie_no() );
            System.out.println(UserDao.m2.getUserNo());
            System.out.println(result);
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            JDBCTemplate.close(pstmt);
        }
        return  result;
    }
}
