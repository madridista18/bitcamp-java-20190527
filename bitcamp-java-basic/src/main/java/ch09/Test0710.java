package ch09;

public class Test0710 {

  public static void main(String[] args) {

    // Calculator1을 사용하여 두 계산식을 동시에 하기
    // 식1) 2 * 3 - 2 + 7 = ?
    // 식2) 6 / 2 + 4 = ?
    
    Calculator5 c5 = new Calculator5();
    Calculator5 c6 = new Calculator5();
   
    c5.plus(2);
    c5.multiple(3);
    c5.minus(2);
    c5.plus(7);
    
    c6.plus(6);
    c6.divide(2);
    c6.plus(4);
    
    System.out.println("결과: " + c5.result);
    System.out.println("결과: " + c6.result);
    
    
    
  }
}
