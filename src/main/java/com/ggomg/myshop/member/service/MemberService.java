package com.ggomg.myshop.member.service;

import com.ggomg.myshop.member.controller.DTO.MemberLoginRequestToController;
import com.ggomg.myshop.member.service.DTO.MemberCreateRequestToService;
import com.ggomg.myshop.member.service.DTO.MemberListResponse;
import com.ggomg.myshop.member.service.DTO.MemberLoginRequestToService;

import java.util.List;

public interface MemberService {

    Long join(MemberCreateRequestToService memberCreateRequestToService);

    List<MemberListResponse> findMembers();

    Long login(MemberLoginRequestToService memberLoginRequestToService);
}
