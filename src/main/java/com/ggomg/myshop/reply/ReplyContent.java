package com.ggomg.myshop.reply;

import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
public class ReplyContent {

    @Id
    @GeneratedValue
    @Column(name="replyContent_id")
    private Long Id;

    private String title;
    private String content;

}
