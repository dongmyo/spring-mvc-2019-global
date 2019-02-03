package com.nhnent.edu.spring_mvc.controller;

import com.nhnent.edu.spring_mvc.domain.Member;
import com.nhnent.edu.spring_mvc.repository.MemberRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/login")
public class LoginController {
    private final MemberRepository memberRepository;


    public LoginController(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }


    @GetMapping
    public String loginForm() {
        return "login/form";
    }

    @PostMapping
    public String doLogin(Member loginInfo, HttpSession session) {
        Member member = memberRepository.get(loginInfo.getId(), loginInfo.getPassword());
        if (member == null) {
            return "login/fail";
        }
        else {
            session.setAttribute("member", member);

            return "redirect:/member/list";
        }
    }

}
