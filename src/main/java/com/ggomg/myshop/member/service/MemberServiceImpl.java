package com.ggomg.myshop.member.service;

import com.ggomg.myshop.member.controller.DTO.MemberCreateRequestToController;
import com.ggomg.myshop.member.entity.Member;
import com.ggomg.myshop.member.entity.MemberGrade;
import com.ggomg.myshop.member.repository.MemberRepository;
import com.ggomg.myshop.member.service.DTO.MemberCreateRequestToService;
import com.ggomg.myshop.member.service.DTO.MemberListResponse;
import com.ggomg.myshop.member.service.DTO.MemberLoginRequestToService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;

    @Transactional(readOnly = false)
    @Override
    public Long join(MemberCreateRequestToService request) {

        validateDuplicateMemberName(request.getName());

        Member member = Member.builder()
                .name(request.getName())
                .email(request.getEmail())
                .password(request.getPassword())
                .birth(LocalDate.parse(request.getBirth(), DateTimeFormatter.ISO_LOCAL_DATE))
                .memberGrade(MemberGrade.NEWB)
                        .build();

        memberRepository.create(member);
        return member.getId();
    }

    private void validateDuplicateMemberName(String name) {

        List<Member> foundMember = memberRepository.findByName(name);
        if (!foundMember.isEmpty()){
            throw new IllegalStateException("이미 존재하는 닉네임입니다.");
        }
    }

    @Override
    public List<MemberListResponse> findMembers() {

        List<Member> findMembers = memberRepository.findAll();

        List<MemberListResponse> collect = findMembers.stream()
                .map(m -> new MemberListResponse(m))
                .collect((Collectors.toList()));

        return collect;
    }

    @Override
    public Long login(MemberLoginRequestToService request) {
        Member member = validateLoginMember(request.getEmail(), request.getPassword()).get(0);
        return member.getId();
    }


    private List<Member> validateLoginMember(String email, String password){
        List<Member> Result = memberRepository.findByEmailAndPassword(email, password);
        if (Result.isEmpty()){
            throw new IllegalStateException("없는 회원입니다.");
        }
        return Result;
    }

}
