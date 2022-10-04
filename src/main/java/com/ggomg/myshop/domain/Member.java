package com.ggomg.myshop.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Setter
@Getter
public class Member {

    @Id
    @GeneratedValue
    @Column(name="member_id")
    private Long id;

    private String name;

    @CreatedDate
    private LocalDateTime createdDate;

    private String email;

    private Date birth;

    @OneToMany(mappedBy = "member")
    private List<Post> posts = new ArrayList<>();


}

