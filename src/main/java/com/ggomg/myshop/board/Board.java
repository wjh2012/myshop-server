package com.ggomg.myshop.board;

import com.ggomg.myshop.member.Member;
import com.ggomg.myshop.post.Post;
import lombok.Getter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
public class Board {

    // meta
    @Id
    @GeneratedValue
    @Column(name="board_id")
    private Long id;

    @CreatedDate
    private LocalDateTime createdDate;

    // 단일속성
    private String name;

    // 연관속성
    @ManyToOne
    @JoinColumn(name="member_id")
    @CreatedBy
    private Member member;

    @OneToMany(mappedBy = "board")
    private List<Post> posts = new ArrayList<>();


}
