package ch23.a;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class TestServer {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    ServerSocket serverSocket = null;
        try {
          serverSocket = new ServerSocket(8888);

          System.out.println("서버 소켓 생성 완료!");
          System.out.println("클라이언트의 연결을 기다림!");

          while (true) {
            String input = scan.nextLine();
            if (input.equalsIgnoreCase("q")) {
              break;
            }

            Socket socket = serverSocket.accept();
            System.out.println("클라이언트와 연결 됨!");

          }
        } catch (Exception e) {
          System.out.println(e.getMessage());
        }
   
  }
}
