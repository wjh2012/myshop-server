package com.ggomg.myshop.member;

import com.ggomg.myshop.domain.Member;
import com.ggomg.myshop.repository.MemberRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
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

        Member findMember = memberRepository.findOne(savedId);
        assertEquals(member.getId(), findMember.getId());
    }

}