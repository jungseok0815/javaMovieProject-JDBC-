package com.kh.movie.model.vo;

import java.util.ArrayList;

public class Moviekiosk {
    protected String movieName;
    protected int price;
    protected int runningTime;
    protected int MovieSeat;

    protected ArrayList<Moviekiosk> movieList= new ArrayList<>();

    public Moviekiosk(){}
    public Moviekiosk(String movieName, int price, int runningTime,int MovieSeat){
        this.movieName = movieName;
        this.price = price;
        this.runningTime = runningTime;
        this.MovieSeat=MovieSeat;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getRunningTime() {
        return runningTime;
    }

    public void setRunningTime(int runningTime) {
        this.runningTime = runningTime;
    }

    public ArrayList<Moviekiosk> getMovieList() {
        return movieList;
    }
    public void setMovieList(ArrayList<Moviekiosk> movieList) {
        this.movieList = movieList;
    }

    public void showMovieList(){
        int i =1;
        for (Moviekiosk m1 : movieList){
            System.out.println(i+" "+m1.toString());
            i++;
        }
    }

    @Override
    public String toString() {
        return movieName + "가격 : "+price+ "러닝타임 : " + runningTime;
    }

}
