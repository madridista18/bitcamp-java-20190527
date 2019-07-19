package algorithm.data_structure.linkedlist2.step1;

public class Node { // 값을 담을 상자
  Object value;
  Node next;
  
  public Node() {
    
  }
  
  public Node(Object value) {
    this.value = value;
  }
  
  public LinkedList() {
    
  }
  
  public boolean add(Object value) {
    Node temp = new Node(value);
    if (head == null)
      head = temp;
    if (tail != null) 
      tail.next = temp;
    tail = temp;
    size++;
    return true;
  }
  
  public get(int index) {
    
  }
  
}
