package com.ggomg.myshop.member;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;

    @Transactional(readOnly = false)
    @Override
    public void join(Member member) {
        validateDuplicateMemberName(member.getName());
        memberRepository.create(member);
    }

    private void validateDuplicateMemberName(String name) {

        List<Member> foundMember = memberRepository.findByName(name);
        if (!foundMember.isEmpty()){
            throw new IllegalStateException("이미 존재하는 닉네임입니다.");
        }
    }

    @Override
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

}
