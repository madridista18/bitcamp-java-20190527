package ch06;

public class TestEx {

  public static void main(String[] args) {

    int[] arr = new int[] {100};
    System.out.printf("첫번째 수: %d\n", arr[0]);
    System.out.println(arr);

    m1(arr);
    System.out.printf("변경 후: %d\n", arr[0]);
    System.out.println(arr);

  }

  static void m1(int[] arr) {
    arr[0] = 300;
    System.out.println(arr[0]);
    System.out.println(arr);
  }

}
