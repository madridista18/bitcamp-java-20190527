package com.eomcs.lms.handler;

import java.sql.Date;
import java.util.List;
import com.eomcs.lms.domain.Board;
import com.eomcs.util.Input;

public class BoardHandler {
  
  private List<Board> boardList;
  private Input input;

  // BoardHandler가 사용하는 Input 객체를 반드시 설정하도록 강제해보자!
  // => Input 객체처럼 어떤 작업을 실행하기 위해 반드시 있어야 하는 객체를 
  //   "의존 객체(dependency)"라 부른다. 
  // => 의존 객체를 강제로 설정하게 만드는 방법? 
  //   다음과 같이 의존 객체를 넘겨 받는 생성자를 정의하는 것이다.
  public BoardHandler(Input input, List<Board> list) {
    this.input = input;
    this.boardList = list;
  }

  public void addBoard() {
    Board board = new Board();
    board.setNo(input.getIntValue("번호? "));
    board.setContents(input.getStringValue("내용? "));
    board.setCreatedDate(new Date(System.currentTimeMillis()));

    boardList.add(board);
    System.out.println("저장하였습니다. ");
  }

  public void listBoard() {
   //Board[] boards = new Board[boardList.size()];
   //boardList.toArray(boards);
   Board[] boards = boardList.toArray(new Board[] {});
   for (Board board : boards) {
      System.out.printf("%s, %s, %s, %s\n", 
          board.getNo(), board.getContents(), board.getCreatedDate(), board.getViewCount());
    }
  }
  
  public void detailBoard() {
    int no = input.getIntValue("번호? ");
    
    Board board = null;
    for (int i = 0; i < boardList.size(); i++) {
      Board temp = boardList.get(i);
      if (temp.getNo() == no) {
        board = temp;
        break;
      }
    }
    if (board == null) {
      System.out.println("해당 번호의 데이터가 없습니다. ");
      return;
    }
    System.out.println("내용: " + board.getContents());
    System.out.println("작성일: " + board.getCreatedDate());
  }

  public void updateBoard() {
    int no = input.getIntValue("번호? ");
    
    Board board = null;
    for (int i = 0; i < boardList.size(); i++) {
      Board temp = boardList.get(i);
      if (temp.getNo() == no) {
        board = temp;
        break;
      }
    }
    if (board == null) {
      System.out.println("해당 번호의 데이터가 없습니다. ");
      return;
    }
    
    String str = input.getStringValue("내용" + board.getContents());
    if (str.length() > 0) {
      board.setContents(str);
    }
    
    System.out.println("게시글을 변경하였습니다. ");
    
    
    
  }

  public void deleteBoard() {
    int no = input.getIntValue("번호? ");
    
    for (int i = 0; i < boardList.size(); i++) {
      Board temp = boardList.get(i);
      if (temp.getNo() == no) {
        boardList.remove(i);
        System.out.println("데이터를 삭제하였습니다. ");
        return;
      }
    }
      System.out.println("해당 번호의 데이터가 없습니다. ");
  }
}

