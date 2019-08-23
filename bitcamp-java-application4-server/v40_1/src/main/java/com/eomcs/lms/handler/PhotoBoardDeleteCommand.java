package com.eomcs.lms.handler;

import java.io.BufferedReader;
import java.io.PrintStream;
import java.sql.Connection;
import java.sql.SQLException;
import com.eomcs.lms.dao.PhotoBoardDao;
import com.eomcs.lms.dao.PhotoFileDao;
import com.eomcs.util.ConnectionFactory;
import com.eomcs.util.Input;

public class PhotoBoardDeleteCommand implements Command {

  private ConnectionFactory conFactory;
  private PhotoBoardDao photoBoardDao;
  private PhotoFileDao photoFileDao;

  // BoardHandler가 사용하는 Input 객체를 반드시 설정하도록 강제해보자!
  // => Input 객체처럼 어떤 작업을 실행하기 위해 반드시 있어야 하는 객체를 
  //   "의존 객체(dependency)"라 부른다. 
  // => 의존 객체를 강제로 설정하게 만드는 방법? 
  //   다음과 같이 의존 객체를 넘겨 받는 생성자를 정의하는 것이다.
  public PhotoBoardDeleteCommand(ConnectionFactory conFactory, PhotoBoardDao photoBoardDao, PhotoFileDao photoFileDao) {
    this.conFactory = conFactory;
    this.photoBoardDao = photoBoardDao;
    this.photoFileDao = photoFileDao;
  }

  @Override
  public void execute(BufferedReader in, PrintStream out) {
    Connection con = null;
    try {
      con = conFactory.getConnection();
      con.setAutoCommit(false);

      int no = Input.getIntValue(in, out, "번호? ");

      if (photoBoardDao.findBy(no) == null) {
        out.println("해당 데이터가 없습니다.");
        return;
      }

      // 먼저 게시물의 첨부파일을 삭제한다.
      photoFileDao.deleteAll(no);

      // 게시물을 삭제한다. 
      photoBoardDao.delete(no);

      con.commit();
      out.println("사진을 삭제하였습니다. ");

    } catch (Exception e) {
      try {con.rollback();} catch (SQLException e2) {}
      // 예외가 발생하면 DBMS의 임시데이터베이스에 보관된 데이터 변경 작업들을 모두 취소한다. 

      out.println("사진 삭제에 실패했습니다!");
      System.out.println(e.getMessage());

    } finally {
      // 커넥션 객체를 원래의 자동 커밋 상태로 설정한다. 
      // => DBMS 쪽 담당자(스레드)에게 이제부터 모든 데이터 변경 작업은 즉시 실행할 것을 명령한다.  
      try {con.setAutoCommit(true);} catch (Exception e) {}
    }
  }
}


