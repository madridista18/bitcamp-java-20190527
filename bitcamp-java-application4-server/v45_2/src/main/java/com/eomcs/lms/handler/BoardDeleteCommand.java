package com.eomcs.lms.handler;

import java.io.BufferedReader;
import java.io.PrintStream;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import com.eomcs.lms.dao.BoardDao;
import com.eomcs.util.Input;

public class BoardDeleteCommand implements Command {

  private SqlSessionFactory sqlSessionFactory;

  // BoardHandler가 사용하는 Input 객체를 반드시 설정하도록 강제해보자!
  // => Input 객체처럼 어떤 작업을 실행하기 위해 반드시 있어야 하는 객체를 
  //   "의존 객체(dependency)"라 부른다. 
  // => 의존 객체를 강제로 설정하게 만드는 방법? 
  //   다음과 같이 의존 객체를 넘겨 받는 생성자를 정의하는 것이다.
  public BoardDeleteCommand(SqlSessionFactory sqlSessionFactory) {
    this.sqlSessionFactory = sqlSessionFactory;
  }

  @Override
  public void execute(BufferedReader in, PrintStream out) {
    try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
      BoardDao boardDao = sqlSession.getMapper(BoardDao.class);
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
}

