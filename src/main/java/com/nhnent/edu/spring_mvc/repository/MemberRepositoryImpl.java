package com.nhnent.edu.spring_mvc.repository;

import com.nhnent.edu.spring_mvc.domain.Member;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Repository
public class MemberRepositoryImpl implements MemberRepository {
    private final Map<String, Member> memberMap;


    public MemberRepositoryImpl(@Qualifier("memberMap") Map<String, Member> memberMap) {
        this.memberMap = memberMap;
    }


    @Override
    public Member findById(String id) {
        return memberMap.getOrDefault(id, null);
    }

    @Override
    public Member get(String id, String password) {
        Member member = memberMap.get(id);
        if (member == null) {
            return null;
        }

        if (!Objects.equals(member.getPassword(), password)) {
            return null;
        }

        return member;
    }


    @Override
    public List<Member> list() {
        return new ArrayList<>(memberMap.values());
    }

}
