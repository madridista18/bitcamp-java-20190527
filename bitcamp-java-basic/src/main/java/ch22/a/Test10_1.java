// java.io.File 클래스 : 필터 사용하기
package ch22.a;

import java.io.File;
import java.io.FilenameFilter;

public class Test10_1 {

  // static nested class
  static class TextFileFilter implements FilenameFilter {  
    @Override
    public boolean accept(File dir, String name) { 
      // 넘어오는 값이 이름으로 넘어오기 때문에 파일인지 디렉토리인지 모른다.
      return name.endsWith(".txt");
    }
  }
  
  public static void main(String[] args) throws Exception {
    
    File file = new File(".");
    
    String[] names = file.list(new TextFileFilter());
    
    for (String name : names) {
      System.out.println(name);
    }
    
  }    
}









