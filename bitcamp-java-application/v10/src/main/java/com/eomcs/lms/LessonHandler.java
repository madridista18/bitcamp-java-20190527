package com.eomcs.lms;

import java.sql.Date;
import java.util.Scanner;

public class LessonHandler {
  static Lesson[] lessons = new Lesson[100];
  static int lessonsSize = 0;
  static Scanner keyScan;
  
  static void addLesson() {
    // 수업 데이터를 저장할 메모리를 Lesson 설계도에 따라 만든다.
    Lesson lesson = new Lesson();

    // 사용자가 입력한 값을 Lesson 인스턴스의 각 변수에 저장한다.
    lesson.no = Input.getIntValue("번호? ");
    lesson.title = Input.getStringValue("수업명? ");
    lesson.contents = Input.getStringValue("설명? ");
    lesson.startDate = Input.getDateValue("시작일? ");
    lesson.endDate = Input.getDateValue("종료일? ");
    lesson.totalHours = Input.getIntValue("총 수업시간? ");
    lesson.dayHours = Input.getIntValue("일 수업시간? ");

    // 수업 데이터를 저장하고 있는 인스턴스의 주소를 레퍼런스 배열에 저장한다.
    lessons[lessonsSize++] = lesson;
    System.out.println("저장하였습니다. ");
  }

  static void listLesson() {
    for (int i = 0; i < lessonsSize; i++) {

      // 레퍼런스 배열에서 한 개의 인스턴스 주소를 꺼낸다.
      Lesson lesson = lessons[i];

      // 그 인스턴스 주소로 찾아가서 인스턴스의 각 변수 값을 꺼내 출력한다. 
      System.out.printf("%s, %s, %s ~ %s, %s\n", 
          lesson.no, lesson.title, lesson.contents, lesson.startDate, lesson.endDate, lesson.totalHours);
      // lessons[i2].no -> 배열로 바로 넣을수도 있지만 속도가 느리더라도 
      // 가독성이 좋고 좀 더 객체 지향적인 측면때문에 이 방법을 이용한다는 것을 알아야 한다.
      // 초보는 속도에 신경쓰지 말아야한다. 
    }
  }
}


