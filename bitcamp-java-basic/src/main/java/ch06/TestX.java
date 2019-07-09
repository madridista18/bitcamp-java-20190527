package ch06;

public class TestX {
  public static void main(String[] args) {

    String value1 = System.getProperty("name");
    String value2 = System.getProperty("kor");
    String value3 = System.getProperty("eng");
    String value4 = System.getProperty("math");
    
    
    int sum = Integer.parseInt(value2) + Integer.parseInt(value3) +Integer.parseInt(value4);
    System.out.printf("이름: %s\n",value1);
    System.out.printf("총점: %s\n", sum);
    System.out.printf("평균: %.2f\n", (float)sum/3);
  }
}
