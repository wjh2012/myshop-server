package com.ggomg.myshop.post;

import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
public class PostContent {

    @Id
    @GeneratedValue
    @Column(name="postContent_id")
    private Long Id;

    private String title;
    private String content;

}
