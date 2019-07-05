package com.eomcs.lms;

import java.sql.Date;
import java.util.Scanner;

public class Test {

  static Scanner keyScan;

  public static void main(String[] args) {
    java.io.InputStream keyBoard = System.in;
    keyScan = new Scanner(keyBoard);

    Lesson[] lessons = new Lesson[100];
    int i = 0;
    for (; i < lessons.length; i++) {

      Lesson lesson = new Lesson();

      lesson.no = getIntValue("번호? ");
      lesson.title = getStringValue("수업명? ");
      lesson.contents = getStringValue("설명? ");
      lesson.startDate = getDateValue("시작일 ? ");
      lesson.endDate = getDateValue("종료일 ? ");
      lesson.totalHours = getIntValue("총 수업시간? ");
      lesson.dayHours = getIntValue("일 수업시간? ");

      lessons[i] = lesson;

      System.out.println("계속 하시겠습니까?(Y/n) ");
      String reponse = keyScan.nextLine();
      if (reponse.equals("n"))
        break;

    }

    System.out.println();

    for (int i2 = 0; i2 <= i; i2++) {
      Lesson lesson = lessons[i2];
      System.out.printf("%s, %s, %s ~ %s, %s\n", 
          lesson.no, lesson.title, lesson.startDate, lesson.endDate, lesson.totalHours);
    }
  }

  private static int getIntValue(String message) {
    while (true) {
      try {
        System.out.println(message);
        return Integer.parseInt(keyScan.nextLine());
      } catch (NumberFormatException e) {
        System.out.println("숫자로 입력하세요. ");
      }
    }
  }

  private static Date getDateValue(String message) {
    while (true) {
      try {
        System.out.print(message);
        return Date.valueOf(keyScan.nextLine());
      } catch (IllegalArgumentException e) {
        System.out.println("yyyy-MM-dd 형식으로 입력하세요. ");
      }
    }
  }

  private static String getStringValue(String message) {
    System.out.println(message);
    return keyScan.nextLine();
  }
}
