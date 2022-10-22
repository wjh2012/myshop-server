package com.ggomg.myshop.member.service.DTO;

import com.ggomg.myshop.member.entity.Member;
import com.ggomg.myshop.member.entity.MemberGrade;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class MemberListResponse {
    private Long id;
    private String name;
    private String email;
    private LocalDate birth;
    private MemberGrade memberGrade;
    private LocalDateTime createdDate;

    public MemberListResponse(Member member){
        this.id = member.getId();
        this.name = member.getName();
        this.email = member.getEmail();
        this.birth = member.getBirth();
        this.memberGrade = member.getMemberGrade();
        this.createdDate = member.getCreatedDate();
    }
}
