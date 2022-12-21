package com.ggomg.myshop.domain.member.service;

import com.ggomg.myshop.domain.member.service.DTO.MemberCreateRequestToService;
import com.ggomg.myshop.domain.member.service.DTO.MemberListResponse;
import com.ggomg.myshop.domain.member.service.DTO.MemberLoginRequestToService;
import java.util.List;

public interface MemberService {

    Long join(MemberCreateRequestToService memberCreateRequestToService);

    List<MemberListResponse> findMembers();

    Long login(MemberLoginRequestToService memberLoginRequestToService);
}
