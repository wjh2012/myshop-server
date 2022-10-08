package com.ggomg.myshop.group;

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

    @Id
    @GeneratedValue
    @Column(name="group_id")
    private Long id;

    private String name;

    // meta
    @CreatedDate
    private LocalDateTime createdDate;
}
