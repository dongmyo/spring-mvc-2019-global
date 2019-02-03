package com.nhnent.edu.spring_mvc.controller;

import com.nhnent.edu.spring_mvc.domain.Member;
import com.nhnent.edu.spring_mvc.repository.MemberRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/member")
public class MemberController {
    private final MemberRepository memberRepository;


    public MemberController(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }


    @GetMapping(value = "/list")
    public String list(ModelMap map) {
        List<Member> members = memberRepository.list();

        map.addAttribute("members", members);

        return "member/list";
    }

    @GetMapping("/detail")
    public String placeHolder() {
        // NOTE : do not modify this method!!!
        return "member/error";
    }

    // TODO : #1 "GET /member/detail/{id}" url 패턴에 대한 핸들러 메서드를 작성하세요.

    // TODO : #2 "GET /member/detail?id={id}" url 패턴에 대한 핸들러 메서드를 작성하세요.
    //        위에 있는 detail 메서드를 수정하지 말고, 아래에 새로이 메서드를 생성하세요.

}
