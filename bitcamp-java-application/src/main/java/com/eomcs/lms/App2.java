package com.eomcs.lms;

import java.util.Scanner;

public class App2 {
  public static void main(String[] args) {
    java.io.InputStream keyboard = System.in;
    Scanner keyScan = new Scanner(keyboard);
    
    System.out.print("번호?");
    String no = keyScan.nextLine();
    System.out.print("이름? ");
    String name = keyScan.nextLine();
    System.out.print("이메일? ");
    String email = keyScan.nextLine();
    System.out.print("암호? ");
    String password = keyScan.nextLine();
    System.out.print("사진? ");
    String photo = keyScan.nextLine();
    System.out.print("전화? ");
    String phoneNumber = keyScan.nextLine();
    
    System.out.println();
    
    System.out.println("번호: " + no);
    System.out.println("이름: " + name);
    System.out.println("이메일: " + email);
    System.out.println("암호: " + password);
    System.out.println("사진: " + photo);
    System.out.println("전화: " + phoneNumber);
    System.out.println("가입일: 2019-01-01");
    
    
    
  }
}
