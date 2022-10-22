package com.ggomg.myshop;

import com.ggomg.myshop.member.controller.DTO.MemberCreateRequest;
import com.ggomg.myshop.member.service.MemberService;
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
            memberService.join(MemberCreateRequest.of("memberA", "emailA", "1999-09-09"));
            memberService.join(MemberCreateRequest.of("memberB", "emailB", "1969-09-04"));
            memberService.join(MemberCreateRequest.of("memberC", "emailC", "1989-06-09"));
            memberService.join(MemberCreateRequest.of("memberD", "emailD", "1997-12-09"));
            memberService.join(MemberCreateRequest.of("memberE", "emailE", "1996-04-07"));
            memberService.join(MemberCreateRequest.of("memberF", "emailF", "1996-09-07"));
            memberService.join(MemberCreateRequest.of("memberG", "emailG", "1996-11-07"));
            memberService.join(MemberCreateRequest.of("memberH", "emailH", "1946-05-07"));
            memberService.join(MemberCreateRequest.of("memberI", "emailI", "1996-01-07"));
            memberService.join(MemberCreateRequest.of("memberJ", "emailJ", "1996-03-07"));
            memberService.join(MemberCreateRequest.of("memberK", "emailK", "1996-02-07"));
        }
    }

}

