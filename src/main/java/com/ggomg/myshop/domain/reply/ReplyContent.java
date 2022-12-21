package com.ggomg.myshop.domain.reply;

import javax.persistence.Embeddable;
import lombok.Getter;

@Embeddable
@Getter
public class ReplyContent {

    private String title;
    private String content;

}
