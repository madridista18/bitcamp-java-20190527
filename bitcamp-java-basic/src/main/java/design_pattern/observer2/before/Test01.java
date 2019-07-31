package design_pattern.observer2.before;

public class Test01 {


  public static void main(String[] args) {

    class TextAnalyzer {
      public void execute() {
        System.out.println("분석");
      }
    }

    TextAnalyzer analyzer = new TextAnalyzer();
    analyzer.execute();
  }

}
