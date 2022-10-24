package com.ggomg.myshop.member.service.DTO;

import lombok.*;

@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class MemberCreateRequestToService {

    private String name;
    private String email;
    private String password;
    private String birth;
}
