package ch26.a;

import java.io.InputStream;
import java.util.List;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Test {

  public static void main(String[] args) throws Exception {
    InputStream inputStream = 
        Resources.getResourceAsStream("ch26/a/mybatis-config.xml");

    SqlSessionFactory sqlSessionFactory =
        new SqlSessionFactoryBuilder().build(inputStream);
    
    SqlSession sqlSession = sqlSessionFactory.openSession();
    
    List<Board> list = sqlSession.selectList("board.select1");
    
    for (Board b : list) {
      System.out.printf("%d, %s, %s, %s, %d\n",
          b.getBoard_id(),
          b.getTitle(), 
          b.getContents(), 
          b.getCreated_date(), 
          b.getView_count());
    }
    sqlSession.close();

  }
}
