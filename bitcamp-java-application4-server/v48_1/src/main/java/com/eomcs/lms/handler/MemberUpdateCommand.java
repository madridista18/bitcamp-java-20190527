package com.eomcs.lms.handler;

import java.io.BufferedReader;
import java.io.PrintStream;
import com.eomcs.lms.dao.MemberDao;
import com.eomcs.lms.domain.Member;
import com.eomcs.util.Component;
import com.eomcs.util.Input;
import com.eomcs.util.RequestMapping;

@Component("/member/update")
public class MemberUpdateCommand {
  private MemberDao memberDao;

  public MemberUpdateCommand(MemberDao memberDao) {
    this.memberDao = memberDao;
  }

  @RequestMapping // 클라이언트 요청이 들어 왔을 때 이 메서드를 호출하라고 표시한다. 
  public void execute(BufferedReader in , PrintStream out) {
    try {
      int no = Input.getIntValue(in, out, "번호? ");
      Member member = memberDao.findBy(no);
      if (member == null) {
        out.println("해당 번호의 데이터가 없습니다. ");
        return;
      }
      // 사용자로부터 변경할 값을 입력 받는다. 
      Member data = new Member();
      data.setNo(no);
      
      String str = Input.getStringValue(in, out, "이름(" + member.getName() + ")?");
      if (str.length() > 0) {
        data.setName(str);
      }

      str = Input.getStringValue(in, out, "이메일(" + member.getEmail() + ")?");
      if (str.length() > 0) {
        data.setEmail(str);
      }

      str = Input.getStringValue(in, out, "암호(" + member.getPassword() + ")?");
      if (str.length() > 0) {
        data.setPassword(str);
      }

      str = Input.getStringValue(in, out, "사진(" + member.getPhoto() + ")?");
      if (str.length() > 0) {
        data.setPhoto(str);
      }

      str = Input.getStringValue(in, out, "전화(" + member.getTel() + ")?");
      if (str.length() > 0) {
        data.setTel(str);
      }
      memberDao.update(data);
      out.println("데이터를 변경하였습니다. ");

    } catch (Exception e) {
      out.println("데이터 조회에 실패했습니다!");
      System.out.println(e.getMessage());
    }
  }
}


