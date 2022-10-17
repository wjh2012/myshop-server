package com.ggomg.myshop.member;

import com.ggomg.myshop.member.DTO.MemberListResponse;
import com.ggomg.myshop.member.DTO.MemberRequest;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

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

    @GetMapping("/members")
    public Result memberList(){
        List<Member> findMembers = memberService.findMembers();
        List<MemberListResponse> collect = findMembers.stream()
                .map(m -> new MemberListResponse(m))
                .collect((Collectors.toList()));

        return new Result(collect);
    }

    @Data
    @AllArgsConstructor
    static class Result<T>{
        private T data;
    }

}
