package ch08;

public class Test0710 {
  
  static class Score {
    String name;
    int kor;
    int eng;
    int math;
    int sum;
    float avg;
  }
  public static void main(String[] args) {
      
    Score s1 = new Score();
    Score s2 = new Score();
    Score s3 = new Score();
    
    s1.name = "홍길동";
    s1.kor = 100;
    s1.eng = 100;
    s1.math = 100;
    
    s2.name = "김구";
    s2.kor = 90;
    s2.eng = 90;
    s2.math = 90;
    
    s3.name = "유관순";
    s3.kor = 80;
    s3.eng = 80;
    s3.math = 80;
    
    printScore(s1);
    printScore(s2);
    printScore(s3);
    
  }
  
  static void printScore(Score s) {
    int sum = s.kor + s.eng + s.math;
    float avg = sum/3f;
    System.out.printf("%s, %d, %d, %d, %d, %.2f\n", s.name, s.kor, s.eng, s.math, sum, avg);
  }
}
