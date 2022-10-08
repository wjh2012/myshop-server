package com.ggomg.myshop.comment;

import com.ggomg.myshop.member.Member;
import com.ggomg.myshop.post.Post;
import lombok.Getter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
public class Comment {

    @Id
    @GeneratedValue
    private Long Id;

    // 단일속성
    private String contents;
    private int good;
    private int bad;

    // 연관속성
    @ManyToOne
    @JoinColumn(name="member_id")
    @CreatedBy
    private Member writer;

    @ManyToOne
    private Post owner;

    // meta
    @CreatedDate
    private LocalDateTime createdDate;


}
