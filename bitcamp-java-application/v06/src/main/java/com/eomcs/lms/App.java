// 애플리케이션 메인 클래스
// => 애플리케이션을 실행할 때 이 클래스를 실행한다.
package com.eomcs.lms;

import java.sql.Date;
import java.util.Scanner;

public class App {

  static Scanner keyScan;

  public static void main(String[] args) {
    java.io.InputStream keyboard = System.in;
    keyScan = new Scanner(keyboard);

    int[] no = new int[100];
    String[] lectureName = new String[100];
    String[] description = new String[100];
    Date[] startDate = new Date[100];
    Date[] endDate = new Date[100];
    int[] totalHours = new int[100];
    int[] dayHours = new int[100];

    int i = 0;
    for ( ; i<no.length; i++) {
      no[i] = getIntValue("번호? ");
      lectureName[i] = getStringValue("수업명? ");
      description[i] = getStringValue("설명? ");
      startDate[i] = getDateValue("시작일? ");
      endDate[i] = getDateValue("종료일? ");
      totalHours[i] = getIntValue("총 수업시간? ");
      dayHours[i] = getIntValue("일 수업시간? ");

      System.out.println("계속 입력하시겠습니까?(Y/n) ");
      String response = keyScan.nextLine();

      if (response.equals("n")) 
        break;


    }


    //    System.out.print("설명? ");
    //    java.lang.String description = keyScan.nextLine(); 
    // lang package는 자주 사용하기 때문에 알려주지 않아도 됨


    //    int startDate = 0;
    //    while (true) {
    //      try {
    //        System.out.print("시작일? ");
    //        startDate = Integer.parseInt(keyScan.nextLine());
    //        break;
    //      } catch (NumberFormatException e){
    //        System.out.println("숫자 입력");
    //      }
    //    }


    System.out.println();


    for (int i2 = 0; i2 <= i; i2++) {
      System.out.printf("%s, %s, %s ~ %s, %s\n", 
          no[i2], lectureName[i2], startDate[i2], endDate[i2], totalHours[i2]);
    }

    //    System.out.printf("번호: %s\n", no);
    //    System.out.printf("수업명: %s\n", lectureName);
    //    System.out.printf("설명: %s\n", description);
    //    System.out.printf("시작일: %s\n", startDate);
    //    System.out.printf("종료일: %s\n", endDate);
    //    System.out.printf("총수업시간: %s\n", totalHours);
    //    System.out.printf("일수업시간: %s\n", dayHours);


  }

  private static int getIntValue(String message) {
    while (true) {
      try { 
        System.out.print(message);
        return Integer.parseInt(keyScan.nextLine());
      } catch (NumberFormatException e) {
        System.out.println("숫자를 입력하세요.");
      }
    }
  }

  // copy(복사) & paste(붙여넣기)
  private static Date getDateValue(String message) {
    while (true) {
      try { 
        System.out.print(message);
        return Date.valueOf(keyScan.nextLine());
      } catch (IllegalArgumentException e) {
        System.out.println("yyyy-MM-dd 형식으로 입력하세요.");
      }
    }
  }

  private static String getStringValue(String message) {
    System.out.print(message);
    return keyScan.nextLine();
  }

}
