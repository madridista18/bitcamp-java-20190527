package com.eomcs.lms.handler;

import java.io.BufferedReader;
import java.io.PrintStream;
import com.eomcs.lms.dao.PhotoBoardDao;
import com.eomcs.lms.dao.PhotoFileDao;
import com.eomcs.util.Input;
import com.eomcs.util.PlatformTransactionManager;

public class PhotoBoardDeleteCommand implements Command {

  private PlatformTransactionManager txManager; 
  private PhotoBoardDao photoBoardDao;
  private PhotoFileDao photoFileDao;

  // BoardHandler가 사용하는 Input 객체를 반드시 설정하도록 강제해보자!
  // => Input 객체처럼 어떤 작업을 실행하기 위해 반드시 있어야 하는 객체를 
  //   "의존 객체(dependency)"라 부른다. 
  // => 의존 객체를 강제로 설정하게 만드는 방법? 
  //   다음과 같이 의존 객체를 넘겨 받는 생성자를 정의하는 것이다.
  public PhotoBoardDeleteCommand(PlatformTransactionManager txManager,  PhotoBoardDao photoBoardDao, PhotoFileDao photoFileDao) {
    this.txManager = txManager;
    this.photoBoardDao = photoBoardDao;
    this.photoFileDao = photoFileDao;
  }
  
  public String getCommandName() {
    return "/photoboard/delete";
  }

  @Override
  public void execute(BufferedReader in, PrintStream out) {
    try {
      txManager.beginTransaction();

      int no = Input.getIntValue(in, out, "번호? ");

      if (photoBoardDao.findBy(no) == null) {
        out.println("해당 데이터가 없습니다.");
        return;
      }

      // 먼저 게시물의 첨부파일을 삭제한다.
      photoFileDao.deleteAll(no);

      // 게시물을 삭제한다. 
      photoBoardDao.delete(no);

      txManager.commit();
      out.println("사진을 삭제하였습니다. ");

    } catch (Exception e) {
      try {txManager.rollback();} catch (Exception e2) {}
      // 예외가 발생하면 DBMS의 임시데이터베이스에 보관된 데이터 변경 작업들을 모두 취소한다. 

      out.println("사진 삭제에 실패했습니다!");
      System.out.println(e.getMessage());

    } 
  }
}


