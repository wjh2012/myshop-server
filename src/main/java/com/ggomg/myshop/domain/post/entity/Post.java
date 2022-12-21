package com.ggomg.myshop.domain.post.entity;

import com.ggomg.myshop.domain.board.Board;
import com.ggomg.myshop.domain.member.entity.Member;
import com.ggomg.myshop.domain.reply.Reply;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EntityListeners(AuditingEntityListener.class)
public class Post {

    @OneToMany(mappedBy = "post")
    private final List<Reply> replies = new ArrayList<>();
    // meta
    @Id
    @GeneratedValue
    @Column(name = "post_id")
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
    @JoinColumn(name = "member_id")
    @CreatedBy
    private Member member;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "board_id")
    private Board board;

    @Builder
    public Post(Board board, Category category, Member member, String title, String content) {
        this.board = board;
        this.category = category;
        this.member = member;
        this.title = title;
        this.content = content;
    }

}
