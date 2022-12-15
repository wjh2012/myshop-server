package com.ggomg.myshop.reply;

import com.ggomg.myshop.member.entity.Member;
import com.ggomg.myshop.post.entity.Post;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import lombok.Getter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;

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
    @JoinColumn(name = "member_id")
    @CreatedBy
    private Member member;

    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;

    @Embedded
    private ReplyContent replyContent;

    // 대댓글
    @ManyToOne
    @JoinColumn(name = "parent_id")
    private Reply parent;

    @OneToMany(mappedBy = "parent")
    private List<Reply> child = new ArrayList<>();


}
