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
     * @param conn    * @param m
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

    /**
     * 로그인을 위한 메소드
     * @param conn
     * @param userinfo
     * @return
     */
    public UserMode loginUser(Connection conn, String[] userinfo){
        ResultSet rset;
        PreparedStatement pstmt = null;
        UserMode user;
        String sql = "select userid, userpwd from user where userid = ? && userpwd = ?";
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, userinfo[0]);
            pstmt.setString(2, userinfo[1]);

            rset = pstmt.executeQuery();
            System.out.println(rset);
            if (rset == null){
                return null;
            }else {
                 user = new UserMode(rset.getString("username"),
                        rset.getString("userid"),
                        rset.getString("userpwd"),
                        rset.getInt("age"));
                return user;
            }
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            JDBCTemplate.close(pstmt);
        }
    }

    /**
     * 전체 영화 목록을 보여주기 위해 데이터베이스에 접근하는 메소드
     * @param conn
     * @return
     */
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

    /**
     * 예약이 이루어지면 데이터베이스에 저장하는 메소드
     * @param conn
     * @param num
     * @param userid
     * @return
     */
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

    /**
     * 로그인된 유저의 예약리스트를 가지고오기 위해서 데이터베이스에 접근하는 메소드
     * @param conn
     * @param userid
     * @return
     */
    public ArrayList<String[]> seleteReservation(Connection conn,String userid){
        ResultSet rset;
        PreparedStatement pstmt = null;
        ArrayList<String[]> reservation = new ArrayList<>();
        String[] reservationList = new String[3];
        String sql = "selete * from "; //데이터베이스 구성후 selete문 작성
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, userid);

            rset = pstmt.executeQuery();
            System.out.println(rset);
            while (rset.next()){
                reservationList[0]  = rset.getString("userid");
                reservationList[1] = rset.getString("username");
                reservationList[2] = rset.getString("moviename");
                reservation.add(reservationList);
            }
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            JDBCTemplate.close(pstmt);
        }

        return reservation;
    }

    public int deleteReMovie(Connection conn, String userid, String moviename){
        int result = 0;
        PreparedStatement pstmt = null;
        String sql = "delete from Reservation where userid = ? && movienaem = ?";
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,userid);
            pstmt.setString(2, moviename);

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
