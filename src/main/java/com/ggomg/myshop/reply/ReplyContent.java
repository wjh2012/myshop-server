package com.ggomg.myshop.reply;

import lombok.Getter;

import javax.persistence.Embeddable;

@Embeddable
@Getter
public class ReplyContent {

    private String title;
    private String content;

    protected ReplyContent(){
    }

    public ReplyContent(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
