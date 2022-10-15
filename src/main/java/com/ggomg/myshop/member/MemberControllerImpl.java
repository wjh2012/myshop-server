package com.ggomg.myshop.member;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MemberControllerImpl {

    private final MemberService memberService;

    @PostMapping("/member")
    public Long saveMember(@RequestBody MemberRequest request) {
        Member member = Member.createMember(request);

        memberService.join(member);
        return member.getId();
    }

}
