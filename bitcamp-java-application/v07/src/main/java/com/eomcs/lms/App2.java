package com.eomcs.lms;

import java.util.Scanner;

public class App2 {

  static Scanner keyScan;

  public static void main(String[] args) {
    java.io.InputStream keyboard = System.in;
    keyScan = new Scanner(keyboard);

    int[] no = new int[100]; 
    String[] name = new String[100]; 
    String[] email = new String[100]; 
    int[] password = new int[100]; 
    String[] photo = new String[100]; 
    String[] phoneNumber = new String[100]; 

    int i = 0;
    for ( ; i<no.length; i++) {
      no[i] = getIntValue("번호? ");
      name[i] = getStringValue("이름? ");
      email[i] = getStringValue("이메일? ");
      password[i] = getIntValue("암호? ");
      photo[i] = getStringValue("사진? ");
      phoneNumber[i] = getStringValue("전화? ");
      
      System.out.println("계속 입력하시겠습니까?(Y/n) ");
      String reponse = keyScan.nextLine();
      
      if(reponse.equals("n")) 
        break;
    }

    System.out.println();
    
    for (int i2 = 0; i2<=i; i2++) {
      System.out.printf("%s, %s, %s, %s, %s\n",
          no[i2], name[i2], email[i2], phoneNumber[i2], "2019-01-01" );
      
    }
//    System.out.println("번호: " + no);
//    System.out.println("이름: " + name);
//    System.out.println("이메일: " + email);
//    System.out.println("암호: " + password);
//    System.out.println("사진: " + photo);
//    System.out.println("전화: " + phoneNumber);
//    System.out.println("가입일: 2019-01-01");

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





