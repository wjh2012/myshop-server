package com.ggomg.myshop.member.controller.DTO;

import lombok.*;

@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class MemberCreateRequestToController {
    private String email;
    private String password;
    private String name;
    private String birth;
}
