package com.eomcs.lms.handler;

import java.io.BufferedReader;
import java.io.PrintStream;
import java.util.List;
import com.eomcs.lms.dao.BoardDao;
import com.eomcs.lms.domain.Board;
import com.eomcs.util.Component;
import com.eomcs.util.Input;
import com.eomcs.util.RequestMapping;

@Component
public class BoardCommand {

  private BoardDao boardDao; 

  // BoardHandler가 사용하는 Input 객체를 반드시 설정하도록 강제해보자!
  // => Input 객체처럼 어떤 작업을 실행하기 위해 반드시 있어야 하는 객체를 
  //   "의존 객체(dependency)"라 부른다. 
  // => 의존 객체를 강제로 설정하게 만드는 방법? 
  //   다음과 같이 의존 객체를 넘겨 받는 생성자를 정의하는 것이다.
  public BoardCommand(BoardDao boardDao) {
    this.boardDao = boardDao;
  }

  @RequestMapping("/board/add") // 클라이언트 요청이 들어 왔을 때 이 메서드를 호출하라고 표시한다. 
  public void add(BufferedReader in, PrintStream out) {
    try {
      Board board = new Board();
      board.setContents(Input.getStringValue(in, out, "내용? "));

      boardDao.insert(board);
      out.println("저장하였습니다. ");

    } catch (Exception e) {
      out.println("데이터 저장에 실패했습니다!");
      System.out.println(e.getMessage());
    }
  }
  
  @RequestMapping("/board/delete") // 클라이언트 요청이 들어 왔을 때 이 메서드를 호출하라고 표시한다. 
  public void delete(BufferedReader in, PrintStream out) {
    try {
      int no = Input.getIntValue(in, out, "번호? ");

      if (boardDao.delete(no) > 0) {
        out.println("데이터를 삭제하였습니다. ");
      } else {
        out.println("해당 데이터가 없습니다. ");
      }

    } catch (Exception e) {
      out.println("데이터 삭제에 실패했습니다!");
      System.out.println(e.getMessage());
    }
  }
  
  @RequestMapping("/board/detail") // 클라이언트 요청이 들어 왔을 때 이 메서드를 호출하라고 표시한다. 
  public void detail(BufferedReader in, PrintStream out) {
    try {
    // 클라이언트에게 번호를 요구하여 받는다. 
    int no = Input.getIntValue(in, out, "번호? ");

      Board board = boardDao.findBy(no);
      if (board == null) {
        out.println("해당 번호의 데이터가 없습니다. ");
        return;
      }
      boardDao.increaseViewCount(no);

      out.println("내용: " + board.getContents());
      out.println("작성일: " + board.getCreatedDate());

    } catch (Exception e) {
      out.println("데이터 조회에 실패했습니다!");
      System.out.println(e.getMessage());
    }
  }
  
  @RequestMapping("/board/list") // 클라이언트 요청이 들어 왔을 때 이 메서드를 호출하라고 표시한다. 
  public void list(BufferedReader in, PrintStream out) {
    try {
      List<Board> boards = boardDao.findAll();
      for (Board board : boards) {
        out.printf("%s, %s, %s, %s\n", 
            board.getNo(), board.getContents(), 
            board.getCreatedDate(), board.getViewCount());
      }

    } catch (Exception e) {
      out.println("데이터 조회에 실패했습니다!");
      e.printStackTrace();
    }
  }
  
  @RequestMapping("/board/update") // 클라이언트 요청이 들어 왔을 때 이 메서드를 호출하라고 표시한다. 
  public void update(BufferedReader in, PrintStream out) {
    try {
      int no = Input.getIntValue(in, out, "번호? ");
      
      Board board = boardDao.findBy(no);
      if (board == null) {
        out.println("해당 번호의 데이터가 없습니다. ");
        return;
      }

      String str = Input.getStringValue(in, out, "내용? ");
      if (str.length() > 0) {
        board.setContents(str);
        boardDao.update(board);
        out.println("데이터를 변경하였습니다. ");
        
      } else {
        out.println("데이터 변경을 취소합니다.");
      }

    } catch (Exception e) {
      out.println("데이터 변경에 실패했습니다!");
      System.out.println(e.getMessage());
    }
  }
  
}

