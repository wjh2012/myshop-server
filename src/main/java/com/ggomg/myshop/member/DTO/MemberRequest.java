package com.ggomg.myshop.member.DTO;

import lombok.Data;

import java.time.LocalDate;

@Data
public class MemberRequest {
    private String name;
    private String email;
    private LocalDate birth;
}
