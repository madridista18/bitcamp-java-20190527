package ch26.a;

import java.io.InputStream;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Test {

  public  static void main(String[] args) throws Exception {
    InputStream inputStream = Resources.getResourceAsStream("ch26/a/mybatis-config.xml");
    
    SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    
    SqlSession sqlSession = sqlSessionFactory.openSession();
    
    sqlSession.insert("Board.insert");
        
        
        
        
        
  }
    
}
