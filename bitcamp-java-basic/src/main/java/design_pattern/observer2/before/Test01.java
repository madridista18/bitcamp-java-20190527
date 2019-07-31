package design_pattern.observer2.before;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class Test01 {

  public static void main(String[] args) throws FileNotFoundException {

    FileReader in = new FileReader("build.gradle");
      
      Analyzer analyzer = new Analyzer(in);
      analyzer.execute();
    
  }

}
