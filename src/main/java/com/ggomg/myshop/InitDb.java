package com.ggomg.myshop;

import com.ggomg.myshop.member.service.DTO.MemberCreateRequestToService;
import com.ggomg.myshop.member.service.MemberService;
import javax.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
public class InitDb {

    private final InitService initService;

    @PostConstruct
    public void init() {
        initService.dbInit1();
    }

    @Component
    @RequiredArgsConstructor
    @Transactional
    static class InitService {

        private final MemberService memberService;

        private void dbInit1() {
            memberService.join(new MemberCreateRequestToService("memberA", "emailA", "0000", "1999-09-09"));
            memberService.join(new MemberCreateRequestToService("memberB", "emailB", "0000", "1969-09-04"));
            memberService.join(new MemberCreateRequestToService("memberC", "emailC", "0000", "1989-06-09"));
            memberService.join(new MemberCreateRequestToService("memberD", "emailD", "0000", "1997-12-09"));
            memberService.join(new MemberCreateRequestToService("memberE", "emailE", "0000", "1996-04-07"));
            memberService.join(new MemberCreateRequestToService("memberF", "emailF", "0000", "1996-09-07"));
            memberService.join(new MemberCreateRequestToService("memberG", "emailG", "0000", "1996-11-07"));
            memberService.join(new MemberCreateRequestToService("memberH", "emailH", "0000", "1946-05-07"));
            memberService.join(new MemberCreateRequestToService("memberI", "emailI", "0000", "1996-01-07"));
            memberService.join(new MemberCreateRequestToService("memberJ", "emailJ", "0000", "1996-03-07"));
            memberService.join(new MemberCreateRequestToService("memberK", "emailK", "0000", "1996-02-07"));
        }
    }

}

