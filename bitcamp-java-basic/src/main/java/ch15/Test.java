package ch15;

import java.util.HashMap;

public class Test {
  String name;
  int age;
  
  public Test(String name, int age) {
    this.name = name;
    this.age = age;
  }
  
  public static void main(String[] args) {
   
     HashMap<Integer, Student> map = new HashMap<>();
//     Student s1 = new Student("홍길동", 23, true);
//     Student s2 = new Student("김광용", 32, false);
//     Student s3 = new Student("꺽정", 25, true);
     
     Integer k1 = new Integer(100);

     map.put(100, new Student("홍길동", 23, true));
     map.put(200, new Student("김광용", 32, false));
     map.put(300, new Student("꺽정", 25, true));
     
     System.out.println(map.get(300));
     System.out.println(map.get(k1));
   
  }
}
