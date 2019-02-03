package com.nhnent.edu.spring_mvc.repository;

import com.nhnent.edu.spring_mvc.domain.Member;

import java.util.List;

public interface MemberRepository {
    Member findById(String id);
    Member get(String id, String password);

    List<Member> list();

    // TODO : #1 멤버를 생성하기 위한 메서드 추가.
    void create(Member member);

}
