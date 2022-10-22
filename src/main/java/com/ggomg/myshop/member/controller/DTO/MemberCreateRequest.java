package com.ggomg.myshop.member.controller.DTO;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class MemberCreateRequest {
    private String name;
    private String email;
    private LocalDate birth;

    public static MemberCreateRequest of(String name, String email, String birth) {
        MemberCreateRequest request = new MemberCreateRequest();
        request.name=name;
        request.email=email;
        request.birth=LocalDate.parse(birth, DateTimeFormatter.ISO_DATE);
        return request;
    }
}
