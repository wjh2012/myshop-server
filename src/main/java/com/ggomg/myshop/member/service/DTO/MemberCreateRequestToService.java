package com.ggomg.myshop.member.service.DTO;

import com.ggomg.myshop.member.controller.DTO.MemberCreateRequestToController;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class MemberCreateRequestToService {

    private String name;
    private String email;
    private LocalDate birth;

    public static MemberCreateRequestToService of(MemberCreateRequestToController requestFromController) {
        MemberCreateRequestToService request = new MemberCreateRequestToService();

        request.name=requestFromController.getName();
        request.email=requestFromController.getEmail();
        request.birth=LocalDate.parse(requestFromController.getBirth(), DateTimeFormatter.ISO_DATE);

        return request;
    }
}
