package com.nhnent.edu.spring_mvc.controller;

import com.nhnent.edu.spring_mvc.domain.Member;
import com.nhnent.edu.spring_mvc.repository.MemberRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@RunWith(MockitoJUnitRunner.class)
public class MemberControllerTest {
    @Mock
    private MemberRepository memberRepository;

    @InjectMocks
    private MemberController memberController;

    private MockMvc mockMvc;

    private static Member member1 = new Member("yankee", "12345");
    private static Member member2 = new Member("sunbi", "67890");


    @Before
    public void setUp() throws Exception {
        mockMvc = MockMvcBuilders.standaloneSetup(memberController)
                                 .build();

    }

    @Test
    public void testMemberList() throws Exception {
        // given
        List<Member> members = new ArrayList<>();
        members.add(member1);
        members.add(member2);

        // when
        when(memberRepository.list())
                .thenReturn(members);


        // then
        MvcResult mvcResult = mockMvc.perform(get("/member/list"))
                                     .andExpect(status().isOk())
                                     .andExpect(view().name("member/list"))
                                     .andReturn();

        ModelAndView mav = mvcResult.getModelAndView();
        List<Member> result = (List<Member>) mav.getModel().get("members");
        Assert.assertNotNull(result);
        Assert.assertEquals(2, result.size());
    }

}
