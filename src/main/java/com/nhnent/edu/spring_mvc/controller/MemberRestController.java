package com.nhnent.edu.spring_mvc.controller;

import com.nhnent.edu.spring_mvc.domain.Member;
import com.nhnent.edu.spring_mvc.repository.MemberRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/members")
public class MemberRestController {
    private final MemberRepository memberRepository;


    public MemberRestController(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }


    @GetMapping
    public List<Member> list() {
        return memberRepository.list();
    }

}
