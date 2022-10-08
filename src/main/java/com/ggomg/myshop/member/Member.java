package com.ggomg.myshop.member;

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
public class Member {

    @Id
    @GeneratedValue
    @Column(name="member_id")
    private Long id;

    private String name;
    private String email;
    private Date birth;
    private MemberGrade memberGrade;

    @OneToMany(mappedBy = "member")
    private List<Post> posts = new ArrayList<>();

    // meta
    @CreatedDate
    private LocalDateTime createdDate;

}

