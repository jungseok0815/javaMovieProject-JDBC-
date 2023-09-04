package com.kh.movie.model.vo;

public class ManagerMode extends Moviekiosk{
    protected int price;
    protected int runningTime;

    private final String id = "kil15978";
    private final String password = "kil79518";

    public ManagerMode(){
    }

    public ManagerMode(String movieName, int price, int runningTime, int num ){
        super.movieName = movieName;
        this.price = price;
        this.runningTime =runningTime;
        super.movieSeat = new String[num];

        for (int i = 0; i< movieSeat.length; i++){
            this.movieSeat[i] = "자리있음";
        }
    }

    public String getId() {
        return id;
    }
    public String getPassword() {
        return password;
    }

}
