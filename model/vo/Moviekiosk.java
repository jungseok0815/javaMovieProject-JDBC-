package com.kh.movie.model.vo;

import java.util.ArrayList;

public class Moviekiosk {
    protected String movieName;
    protected int price;
    protected int runningTime;
    public int[] MovieSeat;

    protected ArrayList<Moviekiosk> movieList= new ArrayList<>();

    public void moarry(){
        movieList.add(new Moviekiosk("아바타",2300, 180 ,new int[40]));
        movieList.add(new Moviekiosk("어벤져스",2500, 150 ,new int[30]));
        movieList.add(new Moviekiosk("인터스텔라",3000, 180,new int[50]));
    }
    public Moviekiosk(){
        moarry();
    }

    public Moviekiosk(String movieName, int price, int runningTime,int[] MovieSeat){
        this.movieName = movieName;
        this.price = price;
        this.runningTime = runningTime;
        this.MovieSeat=MovieSeat;
        for (int i = 0; i< this.MovieSeat.length; i++){
            this.MovieSeat[i] = i+1;
        }
    }

    public int[] getMovieSeat() {
        return MovieSeat;
    }

    public void setMovieSeat(int[] movieSeat) {
        MovieSeat = movieSeat;
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


    public void showMovieList(){
        int i =1;
        for (Moviekiosk m1 : this.movieList){
            System.out.println(i+" "+m1.toString());
            i++;
        }
    }

    @Override
    public String toString() {
        return movieName + "가격 : "+price+ "러닝타임 : " + runningTime;
    }

}
