package com.nhnent.edu.spring_mvc.controller;

import com.nhnent.edu.spring_mvc.controlleradvice.ApiControllerAdvice;
import com.nhnent.edu.spring_mvc.repository.MemberRepository;
import com.nhnent.edu.spring_mvc.validator.UpdateMemberCommandValidator;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.MediaType;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(MockitoJUnitRunner.class)
public class MemberRestControllerTest {
    @Mock
    private MemberRepository memberRepository;

    private UpdateMemberCommandValidator validator = new UpdateMemberCommandValidator();

    @InjectMocks
    private MemberRestController memberRestController;

    private MockMvc mockMvc;


    @Before
    public void setUp() throws Exception {
        mockMvc = MockMvcBuilders.standaloneSetup(memberRestController)
                                 .setControllerAdvice(new ApiControllerAdvice())
                                 .build();

        ReflectionTestUtils.setField(memberRestController, "validator", validator);
    }

    @Test
    public void testCreateMember() throws Exception {
        mockMvc.perform(post("/api/members")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content("{\"name\":\"alien\",\"password\":\"abcde\"}")
                       )
               .andExpect(status().isCreated());
    }

    // TODO : #1 실습 - 아래 테스트 케이스를 완성하세요.
    // TODO : #1 practice - complete the test case below.
    @Test
    public void testUpdateMember() throws Exception {
        mockMvc.perform(put("/api/members/{id}", "yankee")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content("{\"name\":\"\",\"password\":\"\"}")
                       )
               .andExpect(/* http status is internal server error? */)
               .andExpect(/* content type is compatible with application/json */);
    }

}
