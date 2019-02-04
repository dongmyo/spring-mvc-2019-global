package com.nhnent.edu.spring_mvc.controller;

import com.nhnent.edu.spring_mvc.domain.Member;
import com.nhnent.edu.spring_mvc.dto.UpdateMemberCommand;
import com.nhnent.edu.spring_mvc.exception.ApiValidationException;
import com.nhnent.edu.spring_mvc.repository.MemberRepository;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.ValidationException;
import java.util.List;
import java.util.StringJoiner;

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

    @GetMapping("/{id}")
    public Member detail(@PathVariable Long id) {
        return memberRepository.findById(id.toString());
    }

    // TODO : #3 Member update rest api
    //        @Valid UpdateMemberCommand command + BindingResult
    @PutMapping("/{id}")
    public Member update(@PathVariable String id,
                         @RequestBody @Valid UpdateMemberCommand command,
                         BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new ApiValidationException(bindingResult);
        }

        Member member = new Member(command.getName(), command.getPassword());
        memberRepository.update(id, member);

        return member;
    }

}
