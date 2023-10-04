//package com.kh.movie.resources;
//
//import java.io.FileNotFoundException;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.util.Properties;
//
//public class test {
//    public static void main(String[] args) {
//        //파일로 출력하는 것
//        Properties prop = new Properties();
//
//        prop.setProperty("C","INSERT");//게시판 글 작성
//        prop.setProperty("R","READ");// 글 정보 읽기
//        prop.setProperty("U","UPDATE");//업데이트
//        prop.setProperty("D","DELETE");//삭제
//
//        try {
//            prop.store(new FileOutputStream("/driver.properties"),"properties test");
//            prop.storeToXML(new FileOutputStream("/query.xml"),"properties test");
//            System.out.println("파일 저장 성공");
//        } catch (FileNotFoundException e) {
//            throw new RuntimeException(e);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//    }
//}
