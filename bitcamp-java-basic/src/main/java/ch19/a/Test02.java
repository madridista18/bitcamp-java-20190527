// 중첩 클래스 종류 
package ch19.a;

public class Test02 {

  // 중첩 클래스
  // => 특정 클래스 안에서만 사용되는 클래스가 있다면 중첩 클래스로 선언하라.
  // => 즉 노출 범위를 좁히는 것이 유지보수에 좋다.
  //
  // 1) static nested class 
  // => 바깥 클래스의 특정 인스턴스에 종속되지 않는 클래스.
  static class A {} // ex) Test02.A obj = new Test02.A();
  
  // => 다른 static 멤버
  static int a; // ex) Test02.a = 100;
  static void f1() {} // ex) Test02.f1();
  static {} // 클래스 로딩할 때 자동으로 실행
  
  // 2) non-static nested class = inner class
  // => 바깥 클래스의 특정 인스턴스에 종속되는 클래스. 인스턴스가 있어야지만 사용가능
  class B {} // ex) t.new obj.B() {}
  
  // => 다른 인스턴스 멤버
  int b; // ex) t.b = 100;
  void f2() {} // ex) t.f2();
  {} // 인스턴스가 생성된 후 생성자 호출 전에 실행 
  
  public static void main(String[] args) {
    // 3) local class
    // => 특정 메서드 안에서만 사용되는 클래스.
    class C {}

    // 4) anonymous class 
    // => 클래스의 이름이 없다.
    // => 클래스를 정의하는 동시에 인스턴스를 생성해야 한다.
    // => 클래스 이름이 없기 때문에 생성자를 정의할 수 없다.
    // => 만약 인스턴스의 값을 초기화시키기 위해 복잡한 코드를 작성해야 한다면,
    //    인스턴스 블록에 작성하라!
    // => 단 한 개의 인스턴스만 생성해서 사용할 경우 익명 클래스를 적용한다.
    // => 문법
    //      new 수퍼클래스() {클래스 정의}
    //      new 인터페이스() {클래스 정의}
    
    Object obj = new Object() {
      // Object 클래스를 상속 받은 익명 클래스를 만들고 
      // f1() 메서드를 추가한다 
      public void f1() {
        System.out.println("Hello");
      }
    }; // new 명령은 인스턴스를 생성하는 명령이기 때문에 문장 끝에 세미콜론(;)을 붙여야 한다.
  }    
  
  // 스태틱 메서드 
  public static void m1() {
    // 스태틱 멤버는 오직 같은 스태틱 멤버만 사용할 수 있다.
    A obj = new A();
    
    // 스태틱 멤버는 인스턴스 주소를 담는 this라는 built-in 변수가 없기 때문에 
    // 인스턴스 멤버(필드, 메서드, inner 클래스)를 사용할 수 없다.
    B obj2; // 레퍼런스 변수를 선언할 때는 inner 클래스를 사용할 수 있다.
    //obj2 = new B(); // 컴파일 오류!
    
    // 다른 로컬 멤버(변수, 중첩 클래스)는 사용할 수 없다.
    //C obj3; // 컴파일 오류! C 클래스는 main()에서만 사용할 수 있다.
    //obj3 = new C(); // 컴파일 오류!
    
  }
}







