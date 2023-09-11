package com.kh.movie.model.vo;

public class ManagerMode extends Moviekiosk{

    private String movieName;
    private int seat;
    private int runningTime;

    public ManagerMode(String movieName, int seat, int runningTime) {
        this.movieName = movieName;
        this.seat = seat;
        this.runningTime = runningTime;
    }

    @Override
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

    public int getRunningTime() {
        return runningTime;
    }

    public void setRunningTime(int runningTime) {
        this.runningTime = runningTime;
    }
}
