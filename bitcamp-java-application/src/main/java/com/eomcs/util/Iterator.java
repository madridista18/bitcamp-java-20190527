package com.eomcs.util;

// Collection에서 값을 꺼내는 기능을 객체화시킨다. 
// => Collection에서 값을 꺼내는 기능을 클래스로 정의한다. 
// => Collection에서 값을 꺼내는 기능을 추상화한다. 
// => Collection에서 값을 꺼내는 기능을 캡슐화한다. 
//
// Collection에서 값을 꺼내는 객체를 Iterator(반복자)라고 부른다. 
// => Iterator를 일관된 방법으로 사용할 수 있도록 다음과 같이 사용 규칙을 정의한다. 
// => Iterator의 메서드를 일관된 방법으로 호출할 수 있도록 다음과 같이 메서드 규칙을 정의한다. 
public interface Iterator<E> {
  // Collection에서 꺼낼 데이터가 있는지 검사할 때 호출할 메서드
  boolean hasNext();
  
  // Collection에서 한 개의 데이터를 꺼낼 때 호출할 메서드 
  E next();
  
}
