package com.ggomg.myshop.member;

import lombok.Data;

import java.time.LocalDate;

@Data
public class MemberRequest {
    private String name;
    private String email;
    private LocalDate birth;
}
