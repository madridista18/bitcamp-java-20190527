// v32_9: 회원/수업/게시물 요청을 처리하는 클래스를 패키지로 분류한다.  
package com.eomcs.lms;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import com.eomcs.lms.domain.Board;
import com.eomcs.lms.domain.Lesson;
import com.eomcs.lms.domain.Member;
import com.eomcs.lms.servlet.BoardServlet;
import com.eomcs.lms.servlet.LessonServlet;
import com.eomcs.lms.servlet.MemberServlet;

public class ServerApp {

  static ObjectInputStream in;
  static ObjectOutputStream out;

  public static void main(String[] args) {
    System.out.println("[수업관리시스템 서버 애플리케이션]");


    try (ServerSocket serverSocket = new ServerSocket(8888)) {
      System.out.println("서버 시작!");

      try (Socket clientSocket = serverSocket.accept();
          ObjectInputStream in = new ObjectInputStream(clientSocket.getInputStream());
          ObjectOutputStream out = new ObjectOutputStream(clientSocket.getOutputStream())) {

        System.out.println("클라이언트와 연결되었음.");

        // 다른 메서드가 사용할 수 있도록 입출력 스트림을 스태틱 변수에 저장한다.
        ServerApp.in = in;
        ServerApp.out = out;
        
        BoardServlet boardServlet = new BoardServlet(in, out);
        MemberServlet memberServlet = new MemberServlet(in, out);
        LessonServlet lessonServlet = new LessonServlet(in, out);

        loop:
          while (true) {
            // 클라이언트가 보낸 명령을 읽는다.
            String command = in.readUTF();
            System.out.println(command + " 요청 처리중...");
            
            if (command.startsWith("/board/")) {
              boardServlet.service(command);
              out.flush();
              continue;
            }
            if (command.startsWith("/member/")) {
              memberServlet.service(command);
              out.flush();
              continue;
            }
            if (command.startsWith("/lesson/")) {
              lessonServlet.service(command);
              out.flush();
              continue;
            }

            // 명령어에 따라 처리한다.
            switch (command) {
              
              case "quit":
                out.writeUTF("ok");
                break loop;
              default:
                out.writeUTF("fail");
                out.writeUTF("지원하지 않는 명령입니다.");
            }
            out.flush();
            System.out.println("클라이언트에게 응답 완료!");

          } // loop:
        out.flush();
      } 

      System.out.println("클라이언트와 연결을 끊었음.");

    } catch (Exception e) {
      e.printStackTrace();
    }

    System.out.println("서버 종료!");
  }

}






