package com.nhnent.edu.spring_mvc.config;

import com.nhnent.edu.spring_mvc.Base;
import com.nhnent.edu.spring_mvc.domain.Member;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;

import java.util.HashMap;
import java.util.Map;

@Configuration
@ComponentScan(basePackageClasses = Base.class,
        excludeFilters = { @ComponentScan.Filter(Controller.class)})
public class RootConfig {
    @Bean
    public Member member1() {
        return new Member("yankee", "12345");
    }

    @Bean
    public Member member2() {
        return new Member("sunbi", "67890");
    }

    @Bean
    public Map<String, Member> memberMap() {
        Map<String, Member> memberMap = new HashMap<>();
        memberMap.put("yankee", member1());
        memberMap.put("sunbi", member2());

        return memberMap;
    }

}
