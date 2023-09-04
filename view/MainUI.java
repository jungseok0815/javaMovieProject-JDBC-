package com.kh.movie.view;
import com.kh.movie.model.vo.Moviekiosk;

import java.util.Scanner;

public class MainUI  {

    Scanner sc = new Scanner(System.in);
    ManagerModeUI mui = new ManagerModeUI();
    UserModeUI ue1 = new UserModeUI();


    public MainUI(){
        showMainInfo();
    }
    public void showMainInfo(){
        Moviekiosk.defualtmoarry();
        Moviekiosk.defualtuserInfo();
        boolean tf = true;
        while (tf) {
            System.out.println("============영화관 키오스크 ============");
            System.out.println("1.관리자 모드로 접속");
            System.out.println("2.고객 모드로 접속");
            System.out.println("3.키오스크 종료");
            System.out.print("입력: ");
            int num1 = sc.nextInt();
            switch (num1) {
                case 1:
                    mui.showManagerLogin();
                    break;
                case 2:
                    ue1.showUserInfo();
                    break;
                case 3:
                    tf = false;
                    break;
                default:

            }
        }
    }

}
