// 클래스(또는 인터페이스) 이름 알아내기 
package ch27.b;

public class Test01 {

  public static void main(String[] args) throws Exception {
    Class<?> clazz = Calculator.class; // 클래스에 대한 정보를 담는 클래스 : Class
    
    System.out.println(clazz.getName()); // 패키지 이름을 포함한 클래스명
    System.out.println(clazz.getCanonicalName()); // 패키지 이름을 포함한 클래스명
    System.out.println(clazz.getSimpleName()); // 패키지명을 제외한 클래스명
  }

}
// 실무에서 많이 쓴다. 
// Class clz;
// Class cls;
// Class clazz;