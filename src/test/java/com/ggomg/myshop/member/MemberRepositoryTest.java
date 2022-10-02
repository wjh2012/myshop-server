package com.ggomg.myshop.member;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MemberRepositoryTest {

    @Autowired
    MemberRepository memberRepository;

    @Test
    @Transactional
    public void testMember(){
        Member member = new Member();
        member.setName("ggomg");
        Long savedId = memberRepository.save(member);

        Member findMember = memberRepository.find(savedId);
        assertEquals(member.getId(), findMember.getId());
    }

}