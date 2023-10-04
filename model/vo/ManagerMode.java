package com.kh.movie.model.vo;

import java.util.Date;

public class ManagerMode{

    private String movieName;
    private int seat;
    private int movie_no;
    private int userNo;
    private Date date;

    public ManagerMode(String movieName, int seat, int movie_no) {
        this.movieName = movieName;
        this.seat = seat;
        this.movie_no = movie_no;
    }

    public ManagerMode(String movieName, int seat) {
        this.movieName = movieName;
        this.seat = seat;
    }

    public ManagerMode(String movieName, int seat, int movie_no, int userNo, Date date) {
        this.movieName = movieName;
        this.seat = seat;
        this.movie_no = movie_no;
        this.userNo = userNo;
        this.date = date;
    }


    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public int getSeat() {
        return seat;
    }

    public void setSeat(int seat) {
        this.seat = seat;
    }

    public int getMovie_no() {
        return movie_no;
    }

    public void setMovie_no(int movie_no) {
        this.movie_no = movie_no;
    }

    public int getUserNo() {
        return userNo;
    }

    public void setUserNo(int userNo) {
        this.userNo = userNo;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
