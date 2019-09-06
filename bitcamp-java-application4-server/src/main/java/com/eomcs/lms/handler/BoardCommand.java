package com.eomcs.lms.handler;

import java.io.PrintWriter;
import java.util.List;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import com.eomcs.lms.dao.BoardDao;
import com.eomcs.lms.domain.Board;
import com.eomcs.util.ServletRequest;
import com.eomcs.util.ServletResponse;

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

  @RequestMapping("/board/form")
  public void form(ServletRequest request, ServletResponse response) {
    PrintWriter out = response.getWriter();
    out.println("<html><head><title>게시물 등록폼</title></head>");
    out.println("<body><h1>게시물 등록폼</h1>");
    out.println("<form action='/board/add'>");
    out.println("내용 : <textarea name='contents' rows='5' cols='50'></textarea><br>");
    out.println("<button>등록</button>");
    out.println("</form>");
    out.println("</body></html>");

  }

  @RequestMapping("/board/add") // 클라이언트 요청이 들어 왔을 때 이 메서드를 호출하라고 표시한다. 
  public void add(ServletRequest request, ServletResponse response) {
    PrintWriter out = response.getWriter();
    out.println("<html><head><title>게시물 등록</title>"
        + "<meta http-equiv='Refresh' content='0.5;url=/board/list'>"
        + "</head>");
    out.println("<body><h1>게시물 등록</h1>");
    try {
      Board board = new Board();
      board.setContents(request.getParameter("contents"));

      boardDao.insert(board); 
      out.println("<p>저장하였습니다.</p>");

    } catch (Exception e) {
      out.println("<p>데이터 저장에 실패했습니다!</p>");
      throw new RuntimeException(e);
    }
    out.println("</body></html>");
  }

  @RequestMapping("/board/delete") // 클라이언트 요청이 들어 왔을 때 이 메서드를 호출하라고 표시한다. 
  public void delete(ServletRequest request, ServletResponse response) {
    PrintWriter out = response.getWriter();
    out.println("<html><head><title>게시물 삭제</title>"
        + "<meta http-equiv='Refresh' content='0.5;url=/board/list'>"
        + "</head>");
    out.println("<body><h1>게시물 삭제</h1>");
    try {
      int no = Integer.parseInt(request.getParameter("no"));
      if (boardDao.delete(no) > 0) {
        out.println("<p>데이터를 삭제하였습니다.</p>");
      } else {
        out.println("<p>해당 데이터가 없습니다.</p>");
      }

    } catch (Exception e) {
      out.println("<p>데이터 삭제에 실패했습니다!</p>");
      System.out.println(e.getMessage());
    }
    out.println("</body></html>");
  }

  @RequestMapping("/board/detail") // 클라이언트 요청이 들어 왔을 때 이 메서드를 호출하라고 표시한다. 
  public void detail(ServletRequest request, ServletResponse response) {
    PrintWriter out = response.getWriter();
    out.println("<html><head><title>게시물 상세</title></head>");
    out.println("<body><h1>게시물 상세정보</h1>");
    try {
      // 클라이언트에게 번호를 요구하여 받는다. 
      int no = Integer.parseInt(request.getParameter("no"));
      Board board = boardDao.findBy(no);

      if (board == null) {
        out.println("<p>해당 번호의 데이터가 없습니다.</p>");

      } else {
        out.println("<form action='/board/update'>");
        out.printf("번호 : <input type='text' name='no' value='%d' readonly><br>\n", 
            board.getNo());
        out.printf("내용 : <textarea name='contents' rows='5' "
            + "cols='50'>%s</textarea><br>\n",
            board.getContents());
        out.printf("등록일: %s<br>\n", board.getCreatedDate());
        out.printf("조회수: %s<br>\n", board.getViewCount());
        out.println("<button>변경</button>");
        out.printf("<a href='/board/delete?no=%d'>삭제</a>\n", board.getNo());
        out.println("</form>");
        boardDao.increaseViewCount(no);
      }

    } catch (Exception e) {
      out.println("<p>데이터 조회에 실패했습니다!</p>");
      System.out.println(e.getMessage());
    }
    out.println("</body></html>");
  }

  @RequestMapping("/board/list") // 클라이언트 요청이 들어 왔을 때 이 메서드를 호출하라고 표시한다. 
  public void list(ServletRequest request, ServletResponse response) {
    PrintWriter out = response.getWriter();
    out.println("<html><head><title>게시물 목록</title>"
        + "<link rel='stylesheet' href='https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css' integrity='sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T' crossorigin='anonymous'>"
        + "</head>");
    out.println("<body><h1>게시물 목록</h1>");
    out.println("<a href='/board/form'>새 글</a><br>");
    try {
      out.println("<table class='table table-hover'>");
      out.println("<tr><th>번호</th><th>내용</th><th>등록일</th><th>조회수</th></tr>");
      List<Board> boards = boardDao.findAll();
      for (Board board : boards) {
        out.printf("<tr><td>%d</td>"
            + "<td><a href='/board/detail?no=%d'>%s</a></td>"
            + "<td>%s</td><td>%d</td></tr>\n", 
            board.getNo(), 
            board.getNo(),
            board.getContents(), 
            board.getCreatedDate(), 
            board.getViewCount());
      }
      out.println("</table>");

    } catch (Exception e) {
      out.println("<p>데이터 조회에 실패했습니다!</p>");
      e.printStackTrace();
    }
    out.println("</body></html>");
  }

  @RequestMapping("/board/update") // 클라이언트 요청이 들어 왔을 때 이 메서드를 호출하라고 표시한다. 
  public void update(ServletRequest request, ServletResponse response) {
    PrintWriter out = response.getWriter();
    out.println("<html><head><title>게시물 변경</title>"
        + "<meta http-equiv='Refresh' content='0.5;url=/board/list'>"
        + "</head>");
    out.println("<body><h1>게시물 변경</h1>");
    try {
      Board board = new Board();
      board.setNo(Integer.parseInt(request.getParameter("no")));
      board.setContents(request.getParameter("contents"));

      boardDao.update(board);
      out.println("<p>변경하였습니다.</p>");

    } catch (Exception e) {
      out.println("<p>데이터 변경에 실패했습니다!</p>");
      System.out.println(e.getMessage());
    }
    out.println("</body></html>");
  }

}

