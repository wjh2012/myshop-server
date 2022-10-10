package com.ggomg.myshop.member;

import com.ggomg.myshop.board.Board;
import com.ggomg.myshop.post.Post;
import com.ggomg.myshop.reply.Reply;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Getter
public class Member {
    // meta
    @Id
    @GeneratedValue
    @Column(name="member_id")
    private Long id;

    @CreatedDate
    private LocalDateTime createdDate;

    // 단일속성
    private String name;
    private String email;
    private Date birth;
    private MemberGrade memberGrade;

    // 연관속성
    @OneToMany(mappedBy = "member")
    private List<Post> posts = new ArrayList<>();

    @OneToMany(mappedBy = "member")
    private List<Reply> replies = new ArrayList<>();

    @OneToMany(mappedBy = "member")
    private List<Board> boards = new ArrayList<>();



}

