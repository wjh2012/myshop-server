package com.ggomg.myshop.comment;

import com.ggomg.myshop.member.Member;
import lombok.Getter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
public class Comment {

    @javax.persistence.Id
    @GeneratedValue
    private Long Id;

    @ManyToOne
    @JoinColumn(name="member_id")
    @CreatedBy
    private Member member;

    @CreatedDate
    private LocalDateTime createdDate;

    private String contents;

}
