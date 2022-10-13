package com.ggomg.myshop.member;

import java.util.List;

public interface MemberService {

    void join(Member member);

    List<Member> findMembers();
}
