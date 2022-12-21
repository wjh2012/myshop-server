package com.ggomg.myshop.domain.member.controller;

import com.ggomg.myshop.domain.member.controller.DTO.MemberCreateRequestToController;
import com.ggomg.myshop.domain.member.controller.DTO.MemberListResponse;
import com.ggomg.myshop.domain.member.service.DTO.MemberCreateRequestToService;
import com.ggomg.myshop.domain.member.service.DTO.MemberLoginRequestToService;
import com.ggomg.myshop.domain.member.controller.DTO.MemberLoginRequestToController;
import com.ggomg.myshop.domain.member.service.MemberService;
import com.ggomg.myshop.security.TokenProvideService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MemberControllerImpl {

    private final MemberService memberService;
    private final TokenProvideService tokenProvideService;


    @PostMapping("/signup")
    public Long saveMember(@RequestBody MemberCreateRequestToController request) {
        return memberService.join(
                new MemberCreateRequestToService(request.getName(), request.getEmail(), request.getPassword(),
                        request.getBirth()));
    }

    @GetMapping("/members")
    public MemberListResponse memberList() {
        List<com.ggomg.myshop.domain.member.service.DTO.MemberListResponse> dataSet = memberService.findMembers();
        return new MemberListResponse(dataSet);
    }

    @PostMapping("/signin")
    public String signIn(@RequestBody MemberLoginRequestToController request) {
        Long memberId = memberService.login(new MemberLoginRequestToService(request.getEmail(), request.getPassword()));
        return tokenProvideService.create(memberId);
    }

}
