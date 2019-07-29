// 버퍼 사용 - 사용 전
package ch22.c.ex9;

import java.io.FileOutputStream;

public class Test02_1 {
  public static void main(String[] args) throws Exception {

    FileOutputStream out = new FileOutputStream("data.bin");

    System.out.println("데이터 쓰는 중...");

    long start = System.currentTimeMillis();

    for (int i = 0; i < 1000000; i++) {
      out.write(0x55);
    }

    long end = System.currentTimeMillis();

    System.out.println(end - start);

    out.close();    
    System.out.println("출력 완료!");
  }
}








