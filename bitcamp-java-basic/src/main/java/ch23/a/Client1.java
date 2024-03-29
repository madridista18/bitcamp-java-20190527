// 클라이언트 만들기
package ch23.a;

import java.net.Socket;

public class Client1 {

  public static void main(String[] args) throws Exception {
    // 클라이언트(client)?
    // => 연결을 요청하는 쪽을 가리키는 용어다.
    // 서버(server)?
    // => 연결 요청을 받는 쪽을 가리키는 용어다.

    //1) 서버에 연결 요청을 할 때 사용할 도구를 준비한다.
    //   => 서버와의 연결이 이루어지면 Socket 객체를 리턴한다.
    Socket socket = new Socket("localhost", 8888);
    // "localhost" : IP 주소(ex: 234.3.4.56) 또는 도메인명(ex: www.daum.net)
    //               특수 IP : 127.0.0.1 - 로컬 컴퓨터를 가리킨다.
    //               특수 도메인명 : localhost - 127.0.0.1을 가리킨다.
    // 
    // 8888 : 포트번호 - 서버를 구분하는 식별 번호.
    //        IP 주소가 회사 대표 번호라면, 포트 번호는 내선 번호라 할 수 있다.

    System.out.println("서버와 연결되었음!");

    //2) 서버와 연결 해제
    //   => 작업이 끝난 후에는 항상 서버와의 연결을 해제해야 한다.
    //   => 물론 해제하지 않아도 서버측에서 일정 시간이 지나면 자동으로 연결과 관련된 자원을 해제한다.
    //   => 그러나 가능한 명시적으로 연결을 해제하는 것이 좋다.
    //      서버측에서 해당 클라이언트와 연결하기 위해 사용한 자원을 빠르게 회수하여 
    //      다른 클라이언트를 위해 사용할 수 있기 때문이다.
    //
    socket.close();
  }

}
