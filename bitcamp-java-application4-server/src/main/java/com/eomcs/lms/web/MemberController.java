package com.eomcs.lms.web;

import java.io.File;
import java.util.List;
import java.util.UUID;
import javax.annotation.Resource;
import javax.servlet.ServletContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import com.eomcs.lms.domain.Member;
import com.eomcs.lms.service.MemberService;

@Controller
@RequestMapping("/member")
public class MemberController {

  @Resource private MemberService memberService;
  String uploadDir;

  public MemberController(ServletContext sc) {
    uploadDir = sc.getRealPath("/upload/member");
  }

  @RequestMapping("form")
  public void form() {
  }

  @RequestMapping("add")
  public String add(Member member, MultipartFile file) throws Exception {
    member.setPhoto(writeFile(file));
    memberService.insert(member);
    return "redirect:list";
  }

  @RequestMapping("delete")
  public String delete(int no) throws Exception {
    memberService.delete(no);
    return "redirect:list";
  }

  @RequestMapping("detail")
  public void detail(Model model, int no) throws Exception {
    Member member = memberService.get(no);
    model.addAttribute("member", member);
  }

  @RequestMapping("list")
  public void list(Model model) throws Exception {
    List<Member> members = memberService.list();
    model.addAttribute("members", members);
  }

  @RequestMapping("search")
  public void search(Model model, String keyword) throws Exception {
    List<Member> members = memberService.search("keyword");
    model.addAttribute("members", members);
  }

  @RequestMapping("update")
  public String update(Member member, MultipartFile file) throws Exception {
    // 업로드 된 사진 파일 처리
    member.setPhoto(writeFile(file));
    memberService.update(member);
    return "redirect:list";
  }

  private String writeFile(MultipartFile file) throws Exception {
    if (!file.isEmpty()) 
      return null;

    String filename = UUID.randomUUID().toString();
    file.transferTo(new File(uploadDir + "/" + filename));
    return filename;
  }
}



