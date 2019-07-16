package com.eomcs.lms.handler;

import com.eomcs.lms.domain.Board;

public class BoardList {
  private static final int DEFAULT_CAPACITY = 100;

  private Board[] list;
  private int size = 0;

  public BoardList() {
    this(DEFAULT_CAPACITY); 
  }

  public BoardList(int initialCapacity) {
    if (initialCapacity < 50 || initialCapacity > 10000)
      list = new Board[DEFAULT_CAPACITY];
    else 
      list = new Board[initialCapacity];
  }

  public void add(Board board) { 
    if (this.size == list.length)
      throw new RuntimeException("배열이 꽉 찼습니다!");
    this.list[this.size++] = board;
  }

  public Board[] toArray() {
    Board[] arr = new Board[this.size];
    for (int i = 0; i < this.size; i++) {
      arr[i] = this.list[i];
    }
    return arr;
  }
}

