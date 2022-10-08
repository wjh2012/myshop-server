package com.ggomg.myshop.post;

import com.ggomg.myshop.member.Member;
import lombok.Getter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
public class Post {

    @Id
    @GeneratedValue
    private Long Id;

    private String title;
    private String contents;
    private String group;

    @ManyToOne
    @JoinColumn(name="member_id")
    @CreatedBy
    private Member member;

    @CreatedDate
    private LocalDateTime createdDate;

    @LastModifiedDate
    private LocalDateTime modifiedDate;

}
