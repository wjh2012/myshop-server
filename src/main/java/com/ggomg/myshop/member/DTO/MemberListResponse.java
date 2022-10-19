package com.ggomg.myshop.member.DTO;

import com.ggomg.myshop.member.Member;
import com.ggomg.myshop.member.MemberGrade;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
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
