package com.nhnent.edu.spring_mvc.repository;

import com.nhnent.edu.spring_mvc.domain.Member;

import java.util.List;

public interface MemberRepository {
    Member findById(String id);
    Member get(String id, String password);

    List<Member> list();

    void create(Member member);

}
