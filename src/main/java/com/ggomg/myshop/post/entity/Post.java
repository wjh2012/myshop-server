package com.ggomg.myshop.post.entity;

import com.ggomg.myshop.reply.Reply;
import com.ggomg.myshop.board.Board;
import com.ggomg.myshop.member.entity.Member;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EntityListeners(AuditingEntityListener.class)
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
    private String title;
    private String content;

    private Category category;
    private int good;
    private int bad;

    // 연관속성
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="member_id")
    @CreatedBy
    private Member member;

    @OneToMany(mappedBy = "post")
    private List<Reply> replies = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "board_id")
    private Board board;

    @Builder
    public Post(Board board, Category category, String title, String content){
        this.board = board;
        this.category = category;
        this.title = title;
        this.content = content;
    }

}
