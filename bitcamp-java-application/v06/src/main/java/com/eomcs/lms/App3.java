package com.eomcs.lms;

import java.util.Scanner;

public class App3 {

  static Scanner keyScan;
  public static void main(String[] args) {

    java.io.InputStream keyboard = System.in;
    keyScan = new Scanner(keyboard);
    
    int[] no = new int[100];
    String[] content = new String[100];
    
    int i = 0;
    for ( ; i<no.length; i++) {
      no[i] = getIntValue("번호? ");
      content[i] = getStringValue("내용? ");
      i++;
      
      System.out.println("계속 하시겠습니까?(Y/n) ");
      String reponse = keyScan.nextLine();
      
      if (reponse.equals("n"))
        break;
    }

    System.out.println();
    for (int i2 = 0; i2<=i; i2++) {
      System.out.printf("%s, %s, %s, %s\n", 
          no[i2], content[i2], "2019-01-01" , "0");
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
    System.out.println(message);
    return keyScan.nextLine();
  }
}
