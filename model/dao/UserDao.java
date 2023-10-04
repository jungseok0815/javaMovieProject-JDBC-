package com.kh.movie.model.dao;

import com.kh.movie.common.JDBCTemplate;
import com.kh.movie.model.vo.ManagerMode;
import com.kh.movie.model.vo.Reservation;
import com.kh.movie.model.vo.UserMode;

import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserDao {
    static public UserMode m2;

    static public void resetloginStatus(){
        Connection conn = JDBCTemplate.getConnection();
        PreparedStatement pstmt = null;
        int result = 0;
        String sql = "UPDATE cinema_user SET status = 'NO' WHERE status = 'YSE'";
        try {
                pstmt = conn.prepareStatement(sql);
                result = pstmt.executeUpdate();

                if (result > 0){
                    System.out.println("업데이트 성공");
                }else{
                    System.out.println("업데이트 실패");
                }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            if(result > 0){
                JDBCTemplate.commit(conn);
            }else {
                JDBCTemplate.close(conn);
            }
            JDBCTemplate.close(conn);
        }
    }
    public boolean loginUser(Connection conn,UserMode m1){
        ResultSet rset;
        int result = 0;
        PreparedStatement pstmt = null;
        String sql = "select * from cinema_user where user_id = ? and user_pwd = ?";
        String sql2 = "UPDATE cinema_user SET status = 'YSE' WHERE user_id = ?";
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, m1.getUserId());
            pstmt.setString(2, m1.getUserPwd());

            rset = pstmt.executeQuery();

            if (rset.next()){
                m2 = new UserMode(rset.getInt("USER_NO"),rset.getString("USER_NAME"),
                        rset.getString("USER_ID"), rset.getString("USER_PWD"),
                        rset.getInt("USER_AGE"), rset.getString("USER_GRADE"));

                pstmt = conn.prepareStatement(sql2);
                pstmt.setString(1, m1.getUserId());
                result = pstmt.executeUpdate();
                if (result >0){
                    return true;
                }else {
                    System.out.println("상태저장실패");
                    return false;
                }
            }else {
                System.out.println("아이디 또는 비밀번호가 틀립니다.");
                return false;
            }
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            JDBCTemplate.close(pstmt);
        }
    }
    public int createUser(Connection conn, UserMode m2){
        int result = 0;
        PreparedStatement pstmt = null;
        String sql;

        if (m2.getChecked().equals("yes")){
            sql ="Insert into cinema_user values(seq_user.nextval, ?,?,?,?,'USER',DEFAULT,'YSE')";
        }else{

            sql = "Insert into cinema_user values(seq_user.nextval, ?,?,?,?,'USER',DEFAULT,DEFAULT)";
        }
        try {

            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, m2.getUserName());
            pstmt.setString(2, m2.getUserId());
            pstmt.setString(3, m2.getUserPwd());
            pstmt.setInt(4, m2.getAge());


            result = pstmt.executeUpdate();

        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            JDBCTemplate.close(pstmt);
        }

        return result;
    }
    public ArrayList<ManagerMode> showMovie(Connection conn){
        ResultSet rset;
        PreparedStatement pstmt = null;
        String sql = "select * from cinema_movie";


        ArrayList<ManagerMode> movieList = new ArrayList<>();
        try {
            pstmt = conn.prepareStatement(sql);
            rset = pstmt.executeQuery();
            while (rset.next()){
                movieList.add(new ManagerMode(
                        rset.getString("MV_NAME"),
                        rset.getInt("MV_SRATNUM")));

            }

        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            JDBCTemplate.close(pstmt);
        }
        return movieList;
    }
    public boolean reservation(Connection conn, String rvMovieName){
        ResultSet reset;
        ResultSet reset2;
        int result = 0;
        PreparedStatement pstmt = null;

        String sql = "SELECT MV_NO,MV_SRATNUM FROM CINEMA_MOVIE WHERE MV_NAME = ?";
        String sql2 = "SELECT USER_NO FROM CINEMA_USER WHERE STATUS = 'YSE' ";
        String sql3 = "Insert into CINEMA_RESERVATION values(SEQ_RESERVATION.nextval,?,?)";
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, rvMovieName);
            reset = pstmt.executeQuery();
            pstmt = conn.prepareStatement(sql2);
            reset2 = pstmt.executeQuery();

            if (reset.next() && reset2.next()) {
                int seat = reset.getInt("MV_SRATNUM");
                int num1 = reset.getInt("MV_NO");
                int num2 = reset2.getInt("USER_NO");

                pstmt = conn.prepareStatement(sql3);
                pstmt.setInt(1, num2);
                pstmt.setInt(2, num1);
                result = pstmt.executeUpdate();

                System.out.println(result);

                if (seat>0 && result>0)
                    return true;
                else
                    return false;
            }else{return false;}
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            JDBCTemplate.close(pstmt);
        }
    }

    public ArrayList<Reservation> seleteReservation(Connection conn){
        ResultSet rset;
        PreparedStatement pstmt = null;
        Reservation r1;
        ArrayList<Reservation> rList = new ArrayList();
        String sql = "SELECT rv_no, USER_NAME, MV_NAME FROM CINEMA_USER JOIN cinema_reservation USING(USER_NO) JOIN cinema_movie USING(MV_NO) WHERE STATUS = 'YSE' ";
        try {
            pstmt = conn.prepareStatement(sql);
            rset = pstmt.executeQuery();

            while (rset.next()){
                r1 = new Reservation(
                        rset.getString("user_name"),
                        rset.getInt("rv_no"),
                        rset.getString("mv_name")
                        );

                rList.add(r1);

            }


        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            JDBCTemplate.close(pstmt);
        }

        return rList;
    }

    public int deleteReMovie(Connection conn, int rv_num){
        int result = 0;
        PreparedStatement pstmt = null;
        String sql = "delete from cinema_reservation where rv_no = ? and user_no = ?";

        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,rv_num);
            pstmt.setInt(2,m2.getUserNo());
            result = pstmt.executeUpdate();
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            JDBCTemplate.close(pstmt);
        }

        return result;
    }

}
