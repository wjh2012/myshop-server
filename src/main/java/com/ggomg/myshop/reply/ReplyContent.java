package com.ggomg.myshop.reply;

import javax.persistence.Embeddable;
import lombok.Getter;

@Embeddable
@Getter
public class ReplyContent {

    private String title;
    private String content;

}
