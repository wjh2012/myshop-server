package com.ggomg.myshop;

import com.ggomg.myshop.member.controller.DTO.MemberCreateRequestToController;
import com.ggomg.myshop.member.service.DTO.MemberCreateRequestToService;
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
            memberService.join(MemberCreateRequestToService.of(new MemberCreateRequestToController("memberA", "emailA", "1999-09-09")));
            memberService.join(MemberCreateRequestToService.of(new MemberCreateRequestToController("memberB", "emailB", "1969-09-04")));
            memberService.join(MemberCreateRequestToService.of(new MemberCreateRequestToController("memberC", "emailC", "1989-06-09")));
            memberService.join(MemberCreateRequestToService.of(new MemberCreateRequestToController("memberD", "emailD", "1997-12-09")));
            memberService.join(MemberCreateRequestToService.of(new MemberCreateRequestToController("memberE", "emailE", "1996-04-07")));
            memberService.join(MemberCreateRequestToService.of(new MemberCreateRequestToController("memberF", "emailF", "1996-09-07")));
            memberService.join(MemberCreateRequestToService.of(new MemberCreateRequestToController("memberG", "emailG", "1996-11-07")));
            memberService.join(MemberCreateRequestToService.of(new MemberCreateRequestToController("memberH", "emailH", "1946-05-07")));
            memberService.join(MemberCreateRequestToService.of(new MemberCreateRequestToController("memberI", "emailI", "1996-01-07")));
            memberService.join(MemberCreateRequestToService.of(new MemberCreateRequestToController("memberJ", "emailJ", "1996-03-07")));
            memberService.join(MemberCreateRequestToService.of(new MemberCreateRequestToController("memberK", "emailK", "1996-02-07")));
        }
    }

}

