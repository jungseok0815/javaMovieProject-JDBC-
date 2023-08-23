package com.kh.movie.view;
import com.kh.movie.interFace.MainInterface;
import com.kh.movie.model.vo.User;
import java.util.Scanner;

public class MainUI  {

    Scanner sc = new Scanner(System.in);
    ManagerUI mui = new ManagerUI();
    UserUI ue1 = new UserUI();

    public MainUI(){
        showMainInfo();
    }
    public void showMainInfo(){
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
