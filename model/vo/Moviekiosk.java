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

    public static void defualtmoarry(){ //기존에 등록되어 있는 영화
        Moviekiosk.movieList.add(new ManagerMode("아바타",2300, 180 ,40));
        Moviekiosk.movieList.add(new ManagerMode("어벤져스",2500, 150 ,30));
        Moviekiosk.movieList.add(new ManagerMode("인터스텔라",3000, 180, 50));
    }

    public static void defualtuserInfo(){ // 기존에 등록되어있는 예약유저

    }

    public void showMovieList(){
        int i =1;
        for (Moviekiosk m1 : Moviekiosk.movieList){
            System.out.println(i+" "+m1.toString());
            i++;
        }
    }

    @Override
    public String toString() {
        return "Moviekiosk{" +
                "movieName='" + movieName + '\'' +
                '}';
    }
}
