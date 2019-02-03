package com.nhnent.edu.spring_mvc.controller;

import com.nhnent.edu.spring_mvc.domain.Member;
import com.nhnent.edu.spring_mvc.repository.MemberRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

// TODO : #1 MemberDetailController를 MemberController로부터 분리.
@Controller
@RequestMapping("/member/detail/{id}")
public class MemberDetailController {
    private final MemberRepository memberRepository;


    public MemberDetailController(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    // TODO : #2 method-level @ModelAttribute.
    @ModelAttribute("detail")
    public Member getMember(@PathVariable String id) {
        return memberRepository.findById(id);
    }


    @GetMapping
    // TODO : #3 method-argument-level @ModelAttribute.
    public String detail(@ModelAttribute("detail") Member member, Model model) {
        model.addAttribute("detail", member);
        return "member/detail";
    }


    // TODO : #4 "GET /member/detail/{id}?hiddenPassword=true" 요청에
    //        비밀번호를 "*****"로 반환하는 핸들러 메서드를 작성하세요.
    // ???

}
