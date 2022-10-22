package com.ggomg.myshop.member.repository;

import com.ggomg.myshop.member.entity.Member;

import java.util.List;

public interface MemberRepository {

    void create(Member member);

    Member read(Long id);

    List<Member> findByName(String name);

    List<Member> findAll();

}
