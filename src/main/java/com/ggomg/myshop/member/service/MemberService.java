package com.ggomg.myshop.member.service;

import com.ggomg.myshop.member.service.DTO.MemberCreateRequestToService;
import com.ggomg.myshop.member.service.DTO.MemberListResponse;

import java.util.List;

public interface MemberService {

    Long join(MemberCreateRequestToService memberCreateRequestToService);

    List<MemberListResponse> findMembers();
}
