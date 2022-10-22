package com.ggomg.myshop.member.service;

import com.ggomg.myshop.member.controller.DTO.MemberCreateRequest;
import com.ggomg.myshop.member.entity.Member;
import com.ggomg.myshop.member.service.DTO.MemberListResponse;

import java.util.List;

public interface MemberService {

    Long join(MemberCreateRequest memberCreateRequest);

    List<MemberListResponse> findMembers();
}
