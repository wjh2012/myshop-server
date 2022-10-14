package com.ggomg.myshop.member;

import lombok.Data;

import java.util.Date;

@Data
public class MemberDto {
    private String name;
    private String email;
    private Date birth;


}
