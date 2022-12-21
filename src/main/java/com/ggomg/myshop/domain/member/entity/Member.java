package com.ggomg.myshop.domain.member.entity;

import com.ggomg.myshop.domain.board.Board;
import com.ggomg.myshop.domain.post.entity.Post;
import com.ggomg.myshop.domain.reply.Reply;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EntityListeners(AuditingEntityListener.class)
public class Member {
    // 연관속성
    @OneToMany(mappedBy = "member")
    private final List<Post> posts = new ArrayList<>();
    @OneToMany(mappedBy = "member")
    private final List<Reply> replies = new ArrayList<>();
    @OneToMany(mappedBy = "member")
    private final List<Board> boards = new ArrayList<>();
    // meta
    @Id
    @GeneratedValue
    @Column(name = "member_id")
    private Long id;
    @CreatedDate
    private LocalDateTime createdDate;
    private String name;
    private String email;
    private String password;
    private LocalDate birth;
    @Enumerated(EnumType.STRING)
    private MemberGrade memberGrade;

    @Builder
    public Member(String name, String email, String password, LocalDate birth, MemberGrade memberGrade) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.birth = birth;
        this.memberGrade = memberGrade;
    }

}

