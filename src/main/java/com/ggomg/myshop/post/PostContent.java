package com.ggomg.myshop.post;

import lombok.Getter;

import javax.persistence.*;

@Embeddable
@Getter
public class PostContent {

    private String title;
    private String content;

    protected PostContent(){
    }

    public PostContent(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
