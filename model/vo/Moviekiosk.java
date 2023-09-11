package com.kh.movie.model.vo;

import java.util.ArrayList;
import java.util.Iterator;

public class Moviekiosk {
    protected String[] movieSeat;
    protected String movieName;

    private static ArrayList<ManagerMode> movieList= new ArrayList<>();
    private static ArrayList<UserMode> userInfo= new ArrayList<>();

    public Moviekiosk(){};


    public String[] getMovieSeat() {
        return movieSeat;
    }

    public static ArrayList<ManagerMode> getMovieList() {
        return movieList;
    }

    public static ArrayList<UserMode> getUserInfo() {
        return userInfo;
    }


    public String getMovieName() {
        return movieName;
    }


    public static void defualtuserInfo(){ // 기존에 등록되어있는 예약유저

    }


}
