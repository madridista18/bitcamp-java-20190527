package com.eomcs.lms;


import java.sql.Date;
import java.util.Scanner;

public class App2 {

  static Scanner keyScan;

  public static void main(String[] args) {
    java.io.InputStream keyboard = System.in;
    keyScan = new Scanner(keyboard);

    Member[] memberArr = new Member[100];

    int i = 0;
    for (; i < memberArr.length; i++) {
      Member member = new Member();
      member.no = getIntValue("번호? ");
      member.name = getStringValue("이름? ");
      member.email = getStringValue("이메일? ");
      member.password = getStringValue("암호? ");
      member.photo = getStringValue("사진? ");
      member.phoneNumber = getStringValue("전화? ");
      member.registeredDate = new Date(System.currentTimeMillis());

      memberArr[i] = member;


      System.out.println("계속 입력하시겠습니까?(Y/n) ");
      String reponse = keyScan.nextLine();

      if(reponse.equals("n")) 
        break;
    }

    System.out.println();

    for (int i2 = 0; i2<=i; i2++) {
      Member member = memberArr[i2];
      System.out.printf("%s, %s, %s, %s, %s\n",
          member.no, member.name, member.email, member.phoneNumber, member.registeredDate );
    }
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





