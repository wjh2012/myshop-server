package com.ggomg.myshop;

import com.ggomg.myshop.member.DTO.MemberRequest;
import com.ggomg.myshop.member.Member;
import com.ggomg.myshop.member.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;

@Component
@RequiredArgsConstructor
public class InitDb {

    private final InitService initService;

    @PostConstruct
    public void init(){
        initService.dbInit1();
    }

    @Component
    @RequiredArgsConstructor
    @Transactional
    static class InitService{

        private final EntityManager em;
        private final MemberService memberService;

        private void dbInit1(){
            Member memberA = Member.createMember(new MemberRequest("memberA", "emailA", "1999-09-09"));
            Member memberB = Member.createMember(new MemberRequest("memberB", "emailB", "1969-09-04"));
            Member memberC = Member.createMember(new MemberRequest("memberC", "emailC", "1989-06-09"));
            Member memberD = Member.createMember(new MemberRequest("memberD", "emailD", "1997-12-09"));
            Member memberE = Member.createMember(new MemberRequest("memberE", "emailE", "1996-04-07"));

            memberService.join(memberA);
            memberService.join(memberB);
            memberService.join(memberC);
            memberService.join(memberD);
            memberService.join(memberE);
        }
    }

}

