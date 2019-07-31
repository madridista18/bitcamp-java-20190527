package design_pattern.observer2.before;

import java.io.Reader;

public class Analyzer {
  Reader in;

  public Analyzer(Reader in) {
    this.in = in;
  }

  public void execute() {
    try {
      int ch;
      int count = 0;
      while ((ch = in.read()) == -1) {
        count++;
        System.out.printf("총 문자 수: ", count);

      }
    } catch (Exception e) {
      System.out.println("오류");
    }
  }
}
