package com.ggomg.myshop.member;

import java.util.List;

public interface MemberRepository {

    void create(Member member);

    Member read(Long id);

    List<Member> findByName(String name);

    List<Member> findAll();

}
