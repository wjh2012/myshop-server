package com.ggomg.myshop.board;

import com.ggomg.myshop.member.entity.Member;
import com.ggomg.myshop.post.entity.Post;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
public class Board {

    // meta
    @Id
    @GeneratedValue
    @Column(name = "board_id")
    private Long id;

    @CreatedDate
    private LocalDateTime createdDate;

    // 단일속성
    private String name;

    // 연관속성
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    @CreatedBy
    private Member member;

    @OneToMany(mappedBy = "board")
    private List<Post> posts = new ArrayList<>();


}
