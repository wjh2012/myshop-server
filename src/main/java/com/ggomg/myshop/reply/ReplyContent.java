package com.ggomg.myshop.reply;

import lombok.Getter;

import javax.persistence.*;

@Embeddable
@Getter
public class ReplyContent {

    private String title;
    private String content;

}
