package com.eomcs.lms.handler;

import com.eomcs.lms.domain.Lesson;
import com.eomcs.lms.util.Input;

public class LessonHandler {
  private Lesson[] lessons = new Lesson[100];
  private int lessonsSize = 0;
  
  public Input input;
  
  public LessonHandler(Input input) {
    this.input = input;
  }
  
  public void addLesson() {
    // 수업 데이터를 저장할 메모리를 Lesson 설계도에 따라 만든다.
    Lesson lesson = new Lesson();

    // 사용자가 입력한 값을 Lesson 인스턴스의 각 변수에 저장한다.
    lesson.setNo(input.getIntValue("번호? "));
    lesson.setTitle(input.getStringValue("수업명? "));
    lesson.setContents(input.getStringValue("설명? "));
    lesson.setStartDate(input.getDateValue("시작일? "));
    lesson.setEndDate(input.getDateValue("종료일? "));
    lesson.setTotalHours(input.getIntValue("총 수업시간? "));
    lesson.setDayHours(input.getIntValue("일 수업시간? "));

    // 수업 데이터를 저장하고 있는 인스턴스의 주소를 레퍼런스 배열에 저장한다.
    lessons[lessonsSize++] = lesson;
    System.out.println("저장하였습니다. ");
  }

  public void listLesson() {
    for (int i = 0; i < lessonsSize; i++) {

      // 레퍼런스 배열에서 한 개의 인스턴스 주소를 꺼낸다.
      Lesson lesson = lessons[i];

      // 그 인스턴스 주소로 찾아가서 인스턴스의 각 변수 값을 꺼내 출력한다. 
      System.out.printf("%s, %s, %s ~ %s, %s\n", 
          lesson.getNo(), lesson.getTitle(), lesson.getContents(), lesson.getStartDate(), lesson.getEndDate(), lesson.getTotalHours());
      // lessons[i2].no -> 배열로 바로 넣을수도 있지만 속도가 느리더라도 
      // 가독성이 좋고 좀 더 객체 지향적인 측면때문에 이 방법을 이용한다는 것을 알아야 한다.
      // 초보는 속도에 신경쓰지 말아야한다. 
    }
  }
}


