package com.eomcs.lms.handler;

import java.sql.Date;
import com.eomcs.lms.domain.Member;
import com.eomcs.util.Input;
import com.eomcs.util.LinkedList;

public class MemberHandler {
  private LinkedList<Member> memberList = new LinkedList<>();
  private Input input;

  public MemberHandler(Input input) {
    this.input = input;
  }

  public void addMember() {
    Member member = new Member();
    member.setNo(input.getIntValue("번호? "));
    member.setName(input.getStringValue("이름? "));
    member.setEmail(input.getStringValue("이메일? "));
    member.setPassword(input.getStringValue("암호? "));
    member.setPhoto(input.getStringValue("사진? "));
    member.setPhoneNumber(input.getStringValue("전화? "));
    member.setRegisteredDate(new Date(System.currentTimeMillis()));

    memberList.add(member);
    System.out.println("저장하였습니다. ");
  }

  public void listMember() {
    //Member[] members = new Member[memberList.size()];
    //memberList.toArray(members);

    Member[] members = memberList.toArray(new Member[] {});
    for (Member member : members) {
      System.out.printf("%s, %s, %s, %s, %s\n",
          member.getNo(), member.getName(), member.getEmail(), member.getPhoneNumber(), member.getRegisteredDate());
    }
  }

  public void detailMember() {
    int no = input.getIntValue("번호? ");

    Member member = null;
    for (int i = 0; i < memberList.size(); i++) {
      Member temp = memberList.get(i);
      if (temp.getNo() == no) {
        member = temp;
        break;
      }
    }
    if (member == null) {
      System.out.println("해당 번호의 데이터가 없습니다. ");
      return;
    }
    
    System.out.println("이름: " + member.getName());
    System.out.println("이메일: " + member.getEmail());
    System.out.println("암호: " + member.getPassword());
    System.out.println("사진: " + member.getPhoto());
    System.out.println("전화: " + member.getPhoneNumber());
    System.out.println("가입일: " + member.getRegisteredDate());
  }

  public void updateMember() {
    int no = input.getIntValue("번호? ");
    
    Member member = null;
    for (int i = 0; i < memberList.size(); i++) {
      Member temp= memberList.get(i);
      if (temp.getNo() == no) {
        member = temp;
        break;
      }
    }
    
    if (member == null) {
      System.out.println("해당 번호의 데이터가 없습니다. ");
      return;
    }
    
    String str = input.getStringValue("이름(" + member.getName() + ")?");
    if (str.length() > 0) {
      member.setName(str);
    }
    
    str = input.getStringValue("이메일(" + member.getEmail() + ")?");
    if (str.length() > 0) {
      member.setEmail(str);
    }
    
    str = input.getStringValue("암호(" + member.getPassword() + ")?");
    if (str.length() > 0) {
      member.setPassword(str);
    }
    
    str = input.getStringValue("사진(" + member.getPhoto() + ")?");
    if (str.length() > 0) {
      member.setPhoto(str);
    }
    
    str = input.getStringValue("전화(" + member.getPhoneNumber() + ")?");
    if (str.length() > 0) {
      member.setPhoneNumber(str);
    }
    
    System.out.println("데이터를 변경하였습니다. ");
  }

  public void deleteMember() {
    int no = input.getIntValue("번호? ");
    
    Member member = null;
    for (int i = 0; i < memberList.size(); i++) {
      Member temp = memberList.get(i);
      if (temp.getNo() == no) {
        memberList.remove(i);
        System.out.println("데이터를 삭제하였습니다. ");
        return;
      }
    }
      System.out.println("해당 번호의 데이터가 없습니다. ");
  }
  
}

















