package com.eomcs.lms.servlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import com.eomcs.lms.Servlet;
import com.eomcs.lms.domain.Board;
import com.eomcs.lms.domain.Member;

public class MemberServlet implements Servlet {
  ArrayList<Member> memberList = new ArrayList<>();
  
  ObjectInputStream in;
  ObjectOutputStream out;
  
  public MemberServlet(ObjectInputStream in, ObjectOutputStream out) throws ClassNotFoundException {
    this.in = in;
    this.out = out;
    
    try {
      loadData();
    } catch (IOException e) {
      System.out.println("게시물 데이터 로딩 중 오류 발생!");
    }
  }

  @SuppressWarnings("unchecked")
  private void loadData() throws IOException, ClassNotFoundException  {
    File file = new File("./member.ser");
    
    try (ObjectInputStream in = new ObjectInputStream(
        new FileInputStream(file))) {
      memberList = (ArrayList<Member>) in.readObject();
      System.out.println("게시물 데이터 로딩 완료!");

    } 
  }

  public void saveData() throws FileNotFoundException {
    File file = new File("./member.ser");

    try (ObjectOutputStream out = new ObjectOutputStream(
        new FileOutputStream(file))) {

      out.writeObject(memberList);
      System.out.println("게시물 데이터 저장 완료!");

    } catch (IOException e) {
      System.out.println("파일에 데이터를 출력하는 중에 오류 발생!");

    } 
  }

  @Override
  public void service(String command) throws Exception {
    switch (command) {
      case "/member/add":
        addMember();
        break;
      case "/member/list":
        listMember();
        break;
      case "/member/delete":
        deleteMember();
        break;
      case "/member/detail":
        detailMember();
        break;
      case "/member/update":
        updateMember();
        break;
      default:
        out.writeUTF("fail");
        out.writeUTF("지원하지 않는 명령입니다.");
    }
    
  }
  
  private void updateMember0() throws Exception {
    Member member = (Member) in.readObject();
    for (Member m : memberList) {
      if (m.getNo() == member.getNo()) { 
        m.setName(member.getName());
        m.setEmail(member.getEmail());
        m.setPassword(member.getPassword());
        m.setPhoto(member.getPhoto());
        m.setPhoneNumber(member.getPhoneNumber());
        m.setRegisteredDate(member.getRegisteredDate());
        out.writeUTF("ok");
        return;
      }
    }
    fail("해당 번호의 회원이 없습니다. ");
  }
  private void updateMember() throws Exception {
    Member member = (Member) in.readObject();

    int index = indexOfMember(member.getNo());
    if (index == -1) {
      fail("해당 번호의 회원이 없습니다. ");
      return;
    }
    memberList.set(index, member);
    out.writeUTF("ok");

    //    for (int i = 0; i < memberList.size(); i++) {
    //      Member m = memberList.get(i);
    //      if (m.getNo() == member.getNo()) { 
    //        // 기존 객체를 클라이언트가 보낸걸로 교체한다. 
    //        memberList.set(i, member);
    //        out.writeUTF("ok");
    //        return;
    //      }
    //    }
    //    out.writeUTF("fail");
    //    out.writeUTF("해당 번호의 회원이 없습니다. ");
  }

  private void detailMember() throws Exception {
    int no = in.readInt();

    int index = indexOfMember(no);
    if (index == -1) {
      fail("해당 번호의 회원이 없습니다. ");
      return;
    }
    out.writeUTF("ok");
    out.writeObject(memberList.get(index));

    //    for (Member m : memberList) {
    //      if (m.getNo() == no) { 
    //        out.writeUTF("ok");
    //        out.writeObject(m);
    //        return;
    //      }
    //    }
    //    out.writeUTF("fail");
    //    out.writeUTF("해당 번호의 회원이 없습니다. ");


  }

  private void deleteMember() throws Exception {
    int no = in.readInt();

    int index = indexOfMember(no);
    if (index == -1) {
      fail("해당 번호의 회원이 없습니다. ");
      return;
    }
    memberList.remove(index);
    out.writeUTF("ok");

    //    for (Member m : memberList) {
    //      if (m.getNo() == no) { 
    //        memberList.remove(m);
    //        out.writeUTF("ok");
    //        return;
    //      }
    //    }
    //out.writeUTF("fail");
    //out.writeUTF("해당 번호의 회원이 없습니다. ");

  }

  private void addMember() throws Exception {
    Member member = (Member)in.readObject();
    memberList.add(member);
    out.writeUTF("ok");
  }

  private void listMember() throws Exception {
    out.writeUTF("ok");
    out.reset(); // 기존에 serialize 했던 객체의 상태를 무시하고 다시 serialize 한다. 
    out.writeObject(memberList);
  }

  private int indexOfMember(int no) {
    int i =0 ;
    for (Member m : memberList) {
      if (m.getNo() == no) {
        return i;
      }
      i++;
    }
    return -1;
  }
  
  private void fail(String cause) throws Exception {
    out.writeUTF("fail");
    out.writeUTF(cause);
  }
  
}
