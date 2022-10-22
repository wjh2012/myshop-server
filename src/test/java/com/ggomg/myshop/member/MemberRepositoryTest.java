package com.ggomg.myshop.member;

import com.ggomg.myshop.member.entity.Member;
import com.ggomg.myshop.member.repository.MemberRepositoryImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MemberRepositoryTest {

    @Autowired
    MemberRepositoryImpl memberRepositoryImpl;

    @Test
    @Transactional
    public void testMember(){
        Member member = new Member();
        Long savedId = memberRepositoryImpl.save(member);

        Member findMember = memberRepositoryImpl.findOne(savedId);
        assertEquals(member.getId(), findMember.getId());
    }

}