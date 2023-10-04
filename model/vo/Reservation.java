package com.kh.movie.model.vo;



public class Reservation  {
    private String userName;
    private int rvNum;
    private String movieName;

    public Reservation(String userName, int rvNum, String movieName) {
        this.userName = userName;
        this.rvNum = rvNum;
        this.movieName = movieName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getRvNum() {
        return rvNum;
    }

    public void setRvNum(int rvNum) {
        this.rvNum = rvNum;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }
}
