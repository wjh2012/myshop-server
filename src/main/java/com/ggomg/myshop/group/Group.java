package com.ggomg.myshop.group;

import com.ggomg.myshop.member.Member;
import com.ggomg.myshop.member.MemberGrade;
import com.ggomg.myshop.post.Post;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Getter
public class Group {

    // meta
    @Id
    @GeneratedValue
    @Column(name="group_id")
    private Long id;

    @CreatedDate
    private LocalDateTime createdDate;

    // 단일속성
    private String name;

    // 연관속성
    @ManyToOne
    private Member owner;
    @OneToMany
    private List<Post> posts = new ArrayList<>();


}
