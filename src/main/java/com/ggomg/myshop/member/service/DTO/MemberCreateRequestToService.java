package com.ggomg.myshop.member.service.DTO;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class MemberCreateRequestToService {

    private String name;
    private String email;
    private String password;
    private String birth;
}
