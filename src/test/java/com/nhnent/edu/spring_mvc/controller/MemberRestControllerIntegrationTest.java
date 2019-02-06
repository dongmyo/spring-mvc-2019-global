package com.nhnent.edu.spring_mvc.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nhnent.edu.spring_mvc.config.RootConfig;
import com.nhnent.edu.spring_mvc.config.WebConfig;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.ContextHierarchy;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.Map;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextHierarchy({
        @ContextConfiguration(classes = RootConfig.class),
        @ContextConfiguration(classes = WebConfig.class)
})
public class MemberRestControllerIntegrationTest {
    @Autowired
    private WebApplicationContext wac;

    private MockMvc mockMvc;


    @Before
    public void setUp() throws Exception {
        mockMvc = MockMvcBuilders.webAppContextSetup(wac)
                                 .build();
    }

    @Test
    public void test() throws Exception {
        MvcResult mvcResult = mockMvc.perform(get("/api/members/{id}", "yankee")
                                                      .contentType(MediaType.APPLICATION_JSON))
                                     .andExpect(status().isInternalServerError())
                                     .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                                     .andReturn();

        String result = mvcResult.getResponse().getContentAsString();
        Map<String, Object> resultMap = new ObjectMapper()
                .readValue(result, new TypeReference<Map<String, Object>>() {});

        Assert.assertEquals("java.lang.NumberFormatException", resultMap.get("className"));
    }
}
