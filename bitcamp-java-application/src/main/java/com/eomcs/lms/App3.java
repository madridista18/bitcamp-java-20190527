package com.eomcs.lms;

import java.util.Scanner;

public class App3 {
  public static void main(String[] args) {

    java.io.InputStream keyboard = System.in;
    Scanner keyScan = new Scanner(keyboard);
    System.out.print("번호? ");
    String no = keyScan.nextLine();
    System.out.print("내용? ");
    String content = keyScan.nextLine();
    
    System.out.println();

    System.out.println("번호: " + no);
    System.out.println("내용: " + content);
    System.out.println("작성일: 2019-01-01");
    System.out.println("조회수: 0");
  }
}
