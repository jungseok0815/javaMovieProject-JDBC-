package com.kh.movie.model.vo;

public class Manager extends Moviekiosk{

    private final String id = "kil15978";
    private final String password = "kil79518";

    public Manager(){

    }
    public Manager(String moviename, int prive, int runningTime,int movieSeat ){
        super(moviename,prive,runningTime,movieSeat);
    }


    public String getId() {
        return id;
    }
    public String getPassword() {
        return password;
    }



//    static public void movieList(){
//        int i = 1;
//        for (Movie name : getMovieList()){
//            System.out.println(i+"."+name.toString());
//            i++;
//        }
//    }
}
