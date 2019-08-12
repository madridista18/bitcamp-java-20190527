package ch25;

import java.sql.Connection;
import java.sql.DriverManager;

public class Test {

  public static void main(String[] args) throws Exception {
      
    Connection con = DriverManager.getConnection(
        "jdbc:mariadb://localhost/bitcampdb", "bitcamp", "1111");
        
    
  }
}
