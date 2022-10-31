package com.ggomg.myshop.member.controller;

import com.ggomg.myshop.member.controller.DTO.MemberCreateResponse;
import com.ggomg.myshop.member.controller.DTO.MemberLoginRequestToController;
import com.ggomg.myshop.member.service.DTO.MemberCreateRequestToService;
import com.ggomg.myshop.member.service.DTO.MemberListResponse;
import com.ggomg.myshop.member.controller.DTO.MemberCreateRequestToController;
import com.ggomg.myshop.member.service.DTO.MemberLoginRequestToService;
import com.ggomg.myshop.member.service.MemberService;
import com.ggomg.myshop.security.TokenProvideService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MemberControllerImpl {

    private final MemberService memberService;
    private final TokenProvideService tokenProvideService;


    @PostMapping("/signup")
    public Long saveMember(@RequestBody MemberCreateRequestToController request) {
        return memberService.join(new MemberCreateRequestToService(request.getName(), request.getEmail(), request.getPassword(), request.getBirth()));
    }

    @GetMapping("/members")
    public MemberCreateResponse memberList(){
        List<MemberListResponse> dataSet = memberService.findMembers();
        return new MemberCreateResponse(dataSet);
    }

    @PostMapping("/signin")
    public String signIn(@RequestBody MemberLoginRequestToController request) {
        Long memberId = memberService.login(new MemberLoginRequestToService(request.getEmail(), request.getPassword()));
        String token = tokenProvideService.create(memberId);
        return token;
    }

}
