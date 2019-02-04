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
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody Member member) {
        memberRepository.create(member);
    }

    // TODO : #1 `GET /api/members/{id}` 요청에 멤버 정보를 반환하는 rest api를 작성하세요.
    //        method argument type은 수정하지 마세요.
    //        cf.) @PathVariable
    @GetMapping("/{id}")
    public Member detail(Long id) {
        // cf.) memberRepository.findById(id)
        return null;
    }

}
