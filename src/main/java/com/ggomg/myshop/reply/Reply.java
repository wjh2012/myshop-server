package com.ggomg.myshop.reply;

import com.ggomg.myshop.member.Member;
import com.ggomg.myshop.post.Post;
import lombok.Getter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
public class Reply {

    // meta
    @Id
    @GeneratedValue
    @Column(name = "reply_id")
    private Long Id;

    @CreatedDate
    private LocalDateTime createdDate;


    // 단일속성
    private int good;
    private int bad;

    // 연관속성
    @ManyToOne
    @JoinColumn(name="member_id")
    @CreatedBy
    private Member writer;

    @ManyToOne
    private Post post;

    @OneToOne
    private ReplyContent replyContent;


}
