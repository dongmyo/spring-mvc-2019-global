package com.nhnent.edu.spring_mvc.controller;

import com.nhnent.edu.spring_mvc.domain.Member;
import com.nhnent.edu.spring_mvc.repository.MemberRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
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

    // TODO : #2 멤버 생성용 rest api를 작성하세요.
    /*
     * POST /api/members
     * Content-type: application/json
     *
     * {
     *   "id": "xxx",
     *   "password": "***"
     * }
     *
     * HTTP/1.1 201 Created
     *
     */
    // ???

}
