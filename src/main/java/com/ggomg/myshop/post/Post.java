package com.ggomg.myshop.post;

import com.ggomg.myshop.reply.Reply;
import com.ggomg.myshop.group.Group;
import com.ggomg.myshop.member.Member;
import lombok.Getter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
public class Post {

    // meta
    @Id
    @GeneratedValue
    @Column(name="post_id")
    private Long Id;

    @CreatedDate
    private LocalDateTime createdDate;

    @LastModifiedDate
    private LocalDateTime modifiedDate;

    // 단일속성
    private Category category;
    private int good;
    private int bad;

    // 연관속성
    @ManyToOne
    @JoinColumn(name="member_id")
    @CreatedBy
    private Member member;

    @OneToMany
    private List<Reply> replies = new ArrayList<>();

    @ManyToOne
    private Group group;

    @OneToOne
    private PostContent postContent;


}