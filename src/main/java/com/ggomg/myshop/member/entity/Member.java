package com.ggomg.myshop.member.entity;

import com.ggomg.myshop.board.Board;
import com.ggomg.myshop.post.entity.Post;
import com.ggomg.myshop.reply.Reply;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EntityListeners(AuditingEntityListener.class)
public class Member {
    // meta
    @Id
    @GeneratedValue
    @Column(name="member_id")
    private Long id;

    @CreatedDate
    private LocalDateTime createdDate;

    private String name;
    private String email;
    private LocalDate birth;

    @Enumerated(EnumType.STRING)
    private MemberGrade memberGrade;

    // 연관속성
    @OneToMany(mappedBy = "member")
    private List<Post> posts = new ArrayList<>();

    @OneToMany(mappedBy = "member")
    private List<Reply> replies = new ArrayList<>();

    @OneToMany(mappedBy = "member")
    private List<Board> boards = new ArrayList<>();

    @Builder
    public Member(String name, String email, LocalDate birth, MemberGrade memberGrade){
        this.name = name;
        this.email = email;
        this.birth = birth;
        this.memberGrade = memberGrade;
    }

}

