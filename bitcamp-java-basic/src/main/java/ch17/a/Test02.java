// 추상 메서드 상속
package ch17.a;

abstract class My1 extends A {
  // A의 추상 메서드인 m2()를 구현하지 않으면 
  // My1도 추상 클래스가 되어야 한다.
  // 추상 메서드가 자기 것이든 상속 받은 것이든 상관없다.
  // 있으면 구현하든가 아니면 추상 클래스로 선언하든가 해야 한다.
}

class My2 extends A {

  @Override
  public void m2(String name) {
    // 이렇게 상속 받은 추상 메서드를 구현하게 되면 
    // 해당 클래스는 일반 클래스가 될 수 있다.
    System.out.println("My2.m2() - " + name);
  }
  
  public void m3() {
    System.out.println("Hello!");
  }
}

// 추상 클래스 <==> 일반 클래스(concrete class)

public class Test02 {

  public static void main(String[] args) {
    
    //A obj = new A(); // 컴파일 오류! 추상 클래스의 인스턴스는 생성할 수 없다.
    //My1 obj2 = new My1(); // 컴파일 오류! 추상 클래스의 인스턴스는 생성할 수 없다.
    
    My2 obj3 = new My2(); // OK!
    obj3.m1();
    obj3.m2("홍길동");
    obj3.m3();
    
    A obj4 = new My2(); 
    obj4.m1(); // m1()은 A 클래스에 있는 메서드이다. 호출할 수 있다.
               // 다만 obj4에 저장된 인스턴스(주소)는 실제 My2 클래스이기 때문에 
               // m1() 메서드를 찾을 때는 My2 클래스부터 상위 클래스로 찾아 올라간다.
    
    // m2() 또한 m1()과 같다.  
    // obj4는 A 클래스의 레퍼런스이지만,
    // 실제 obj4가 가리키는 인스턴스는 My2이다.
    // 만약 obj4가 호출하는 메서드를 My2가 오버라이딩 했다면,
    // 그 오버라이딩 한 메서드가 호출된다.
    obj4.m2("임꺽정");

    // *주의!
    // *오버라이딩 메서드를 호출해 준다고 해서,
    // *A 클래스의 없는 메서드 호출을 허락하는 것은 아니다.
    //obj4.m3(); // 컴파일 오류! obj4는 A 타입이고 A 타입(클래스)에는 m3()가 없다.
                 // obj4는 A클래스의 레퍼런스이기 때문에 문법적으로 m3() 메서드가 없어서 호출할 수 없다. 
                 // obj4가 어떤 클래스의 인스턴스를 가리키는 가는 중요한것이 아니다. 
                 // 일단 메서드를 호출할 때 레퍼런스의 클래스의 조건에 맞는 메서드만 호출할 수 있다. 
    
    // obj4에 My2 인스턴스를 저장한 것이 확실하다면
    // 컴파일러에게 개발자가 직접 알려줘야 한다.
    // 즉 다음과 같이 해당 레퍼런스에 어떤 클래스의 인스턴스가 들어 있는지 알려주기 위해 
    // 타입 캐스팅(형변환) 해주어야 한다.
    ((My2)obj4).m3(); // obj4가 가리키는 객체가 어떤 타입인지 컴파일러에게 알려주면
                      // 그 클래스의 메서드를 호출할 수 있다.
    
  }

}











