package com.eomcs.lms;

import java.util.Scanner;

public class App2 {

  static Scanner keyScan;

  public static void main(String[] args) {
    java.io.InputStream keyboard = System.in;
    keyScan = new Scanner(keyboard);

    int no = getIntValue("번호? ");
    String name = getStringValue("이름? ");
    String email = getStringValue("이메일? ");
    int password = getIntValue("암호? ");
    String photo = getStringValue("사진? ");
    int phoneNumber = getIntValue("전화? ");

    System.out.println();

    System.out.println("번호: " + no);
    System.out.println("이름: " + name);
    System.out.println("이메일: " + email);
    System.out.println("암호: " + password);
    System.out.println("사진: " + photo);
    System.out.println("전화: " + phoneNumber);
    System.out.println("가입일: 2019-01-01");

  }

  private static int getIntValue(String message) {
    while (true) {
      try {
        System.out.print(message);
        return Integer.parseInt(keyScan.nextLine());
      } catch (NumberFormatException e) {
        System.out.println("숫자로 입력하세요. ");
      }
    }
  }

  private static String getStringValue(String message) {
    System.out.print(message);
    return keyScan.nextLine();
  }


}





