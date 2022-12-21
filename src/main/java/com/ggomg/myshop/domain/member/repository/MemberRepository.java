package com.ggomg.myshop.domain.member.repository;

import com.ggomg.myshop.domain.member.entity.Member;
import java.util.List;

public interface MemberRepository {

    void create(Member member);

    Member read(Long id);

    List<Member> findByName(String name);

    List<Member> findAll();

    List<Member> findByEmailAndPassword(String email, String password);

}
