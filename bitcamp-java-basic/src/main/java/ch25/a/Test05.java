// java.sql.Connection 객체 
package ch25.a;

import java.sql.Connection;
import java.sql.DriverManager;

public class Test05 {

  public static void main(String[] args) {
    // DriverManager.getConnetion()
    // => 내부적으로 org.mariadb.jdbc.Driver.connect() 호출!
    //  
    try (Connection con = DriverManager.getConnection(
        "jdbc:mariadb://localhost/bitcampdb?user=bitcamp&password=1111")) {
      System.out.println("DBMS에 연결됨!");
      
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

}









