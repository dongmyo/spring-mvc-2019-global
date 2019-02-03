package com.nhnent.edu.spring_mvc.controller;

import com.nhnent.edu.spring_mvc.domain.Member;
import com.nhnent.edu.spring_mvc.repository.MemberRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

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
        return "member/error";
    }

    @GetMapping(value = "/detail", params = { "id" })
    public ModelAndView detail2(@RequestParam(value = "id") String id) {
        Member member = memberRepository.findById(id);

        ModelAndView mav = new ModelAndView("member/detail");
        mav.addObject("detail", member);

        return mav;
    }

    @ModelAttribute("modelAttributeOnMethod")
    public void modelAttributeOnMethod() {
        System.out.println("modelAttributeOnMethod is called.");
    }

}
