package com.eomcs.lms.handler;

import java.sql.Date;
import com.eomcs.lms.domain.Member;
import com.eomcs.lms.util.Input;

public class MemberHandler {
  private Member[] members = new Member[100];
  private int membersSize = 0;
  
  public void addMember() {
    Member member = new Member();
    member.no = Input.getIntValue("번호? ");
    member.name = Input.getStringValue("이름? ");
    member.email = Input.getStringValue("이메일? ");
    member.password = Input.getStringValue("암호? ");
    member.photo = Input.getStringValue("사진? ");
    member.phoneNumber = Input.getStringValue("전화? ");
    member.registeredDate = new Date(System.currentTimeMillis());

    members[membersSize++] = member;
    System.out.println("저장하였습니다. ");
  }

  public void listMember() {
    for (int i = 0; i < membersSize; i++) {
      Member member = members[i];
      System.out.printf("%s, %s, %s, %s, %s\n",
          member.no, member.name, member.email, member.phoneNumber, member.registeredDate );
    }
  }
}

