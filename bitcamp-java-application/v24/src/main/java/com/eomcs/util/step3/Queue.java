// 상속 문법을 이용하여 stack 만들기 
package com.eomcs.util.step3;

import com.eomcs.util.Iterator;
import com.eomcs.util.LinkedList;

public class Queue<E> extends LinkedList<E> implements Cloneable {

  @Override
  public Queue<E> clone() throws CloneNotSupportedException {
    // 현재 큐 객체의 노드를 그대로 유지하기 위해 "deep copy"를 실행한다. 
    // => 새 큐를 만들고,
    Queue<E> temp = new Queue<>();
    for (int i = 0; i < size(); i++) {
      // => 현재 큐에서 값을 꺼내 새 큐의 새 노드에 넣는다. 
      //   즉, 새 큐는 값을 넣을 때 마다 새 노드를 생성하기 때문에 
      //   현재 큐의 노드에는 영향을 끼치지 않는다. 
      temp.offer(get(i));
    }
    return temp;
  }

  public void offer(E value) {
    add(value);
  }

  public E poll() {
    return remove(0);
  }

  public boolean empty() {
    return size() == 0;
  }

  // 큐의 데이터를 꺼내줄 Iterator를 제공한다. 
  public Iterator<E> createIterator() {
    // 특정 메서드 안에서만 사용되는 클래스라면 메서드 안에 선언하라!
    // 이렇게 메서드 안에 선언된 중첩 클래스를 "local class" 라 부른다. 
    class QueueIterator implements Iterator<E> {
      @Override
      public boolean hasNext() {
        return size() > 0;
      }

      @Override
      public E next() {
        return poll();
      }
    }
    return new QueueIterator();
  }
}
