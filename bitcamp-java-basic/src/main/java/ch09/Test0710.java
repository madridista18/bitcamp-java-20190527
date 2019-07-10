package ch09;

public class Test0710 {

  public static void main(String[] args) {

    // Calculator1을 사용하여 두 계산식을 동시에 하기
    // 식1) 2 * 3 - 2 + 7 = ?
    // 식2) 6 / 2 + 4 = ?
    
    Calculator5 c1 = new Calculator5();
    Calculator5 c2 = new Calculator5();
    
  
    c1.plus(2);
    c1.multiple(3);
    c1.minus(2);
    c1.plus(7);
    
    c2.plus(6);
    c2.divide(2);
    c2.plus(4);
    
    
    
    System.out.println(c1.re);
    System.out.println(c2.re);
    
    
  }
}
