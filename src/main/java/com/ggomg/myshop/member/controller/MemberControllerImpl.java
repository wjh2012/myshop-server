package com.ggomg.myshop.member.controller;

import com.ggomg.myshop.member.controller.DTO.MemberCreateResponse;
import com.ggomg.myshop.member.service.DTO.MemberListResponse;
import com.ggomg.myshop.member.controller.DTO.MemberCreateRequest;
import com.ggomg.myshop.member.service.MemberService;
import com.ggomg.myshop.member.entity.Member;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class MemberControllerImpl {

    private final MemberService memberService;

    @PostMapping("/member")
    public Long saveMember(@RequestBody MemberCreateRequest request) {
        return memberService.join(request);
    }

    @GetMapping("/members")
    public MemberCreateResponse memberList(){
        List<MemberListResponse> collect = memberService.findMembers();
        return new MemberCreateResponse(collect);
    }

}
