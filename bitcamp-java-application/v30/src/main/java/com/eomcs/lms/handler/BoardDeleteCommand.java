package com.eomcs.lms.handler;

import java.util.List;
import com.eomcs.lms.domain.Board;
import com.eomcs.util.Input;

public class BoardDeleteCommand implements Command {
  
  private List<Board> list;
  private Input input;

  // BoardHandler가 사용하는 Input 객체를 반드시 설정하도록 강제해보자!
  // => Input 객체처럼 어떤 작업을 실행하기 위해 반드시 있어야 하는 객체를 
  //   "의존 객체(dependency)"라 부른다. 
  // => 의존 객체를 강제로 설정하게 만드는 방법? 
  //   다음과 같이 의존 객체를 넘겨 받는 생성자를 정의하는 것이다.
  public BoardDeleteCommand(Input input, List<Board> list) {
    this.input = input;
    this.list = list;
  }

  @Override
  public void execute() {
    int no = input.getIntValue("번호? ");
    
    for (int i = 0; i < list.size(); i++) {
      Board temp = list.get(i);
      if (temp.getNo() == no) {
        list.remove(i);
        System.out.println("데이터를 삭제하였습니다. ");
        return;
      }
    }
      System.out.println("해당 번호의 데이터가 없습니다. ");
  }
}

