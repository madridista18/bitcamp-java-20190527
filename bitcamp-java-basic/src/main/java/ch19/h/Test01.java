// Lambda 문법 - functional interface를 효과적으로 다루는 문법
package ch19.h;

public class Test01 {
  
  // 다음과 같이 추상 메서드가 한 개 있는 인터페이스를 "functional interface"라고 부른다. 
  // 메서드 한 개만 구현할 때 사용! 두 개는 안 됨
  // => 이런 경우에 람다 문법으로 사용할 수 있다.
  static interface Player {
    void play();
  }
  
  public static void main(String[] args) {
    // 익명 클래스로 인터페이스 구현하기
    Player p1 = new Player() {
      public void play() {
        System.out.println("테스트1");
      }
    };
    
    p1.play();
    
    // 람다 클래스로 인터페이스 구현하기
    Player p2 = () -> {
        System.out.println("테스트1");
      };
    
    p2.play();
  }
}









