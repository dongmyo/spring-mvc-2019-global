package com.nhnent.edu.spring_mvc.controller;

import com.nhnent.edu.spring_mvc.domain.Member;
import com.nhnent.edu.spring_mvc.dto.UpdateMemberCommand;
import com.nhnent.edu.spring_mvc.exception.ApiValidationException;
import com.nhnent.edu.spring_mvc.repository.MemberRepository;
import com.nhnent.edu.spring_mvc.validator.UpdateMemberCommandValidator;
import org.springframework.http.HttpStatus;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/members")
public class MemberRestController {
    private final MemberRepository memberRepository;
    private final UpdateMemberCommandValidator validator;


    public MemberRestController(MemberRepository memberRepository, UpdateMemberCommandValidator validator) {
        this.memberRepository = memberRepository;
        this.validator = validator;
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

    // TODO : #3 @Validated(@Valid) apply validator
    @PutMapping("/{id}")
    public Member update(@PathVariable String id,
                         @RequestBody @Validated UpdateMemberCommand command,
                         Errors errors) {
        if (errors.hasErrors()) {
            throw new ApiValidationException(errors);
        }

        Member member = new Member(command.getName(), command.getPassword());
        memberRepository.update(id, member);

        return member;
    }

    // TODO : #2 initBinder + addValidator
    @InitBinder("updateMemberCommand")
    protected void initBinder(WebDataBinder binder) {
        binder.addValidators(validator);
    }

}
