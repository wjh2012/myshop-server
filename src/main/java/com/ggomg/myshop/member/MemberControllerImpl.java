package com.ggomg.myshop.member;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequiredArgsConstructor
public class MemberControllerImpl implements MemberController{

    private final MemberService memberService;

    @PostMapping("/member")
    public Long saveMember(CreateMemberRequest request) {

        Member member = new Member();
    }

    @Data
    static class CreateMemberRequest{
        private String name;
        private String email;
        private Date birth;
    }
}
