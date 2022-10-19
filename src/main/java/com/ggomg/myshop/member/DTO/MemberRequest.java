package com.ggomg.myshop.member.DTO;

import lombok.Data;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Data
public class MemberRequest {
    private String name;
    private String email;
    private LocalDate birth;

    public MemberRequest(String name, String email, String birth) {
        LocalDate birthday = LocalDate.parse(birth, DateTimeFormatter.ISO_DATE);
        this.name = name;
        this.email = email;
        this.birth = birthday;
    }
}
