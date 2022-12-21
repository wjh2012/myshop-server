package com.ggomg.myshop.domain.post.controller.DTO;

import com.ggomg.myshop.domain.board.Board;
import com.ggomg.myshop.domain.member.entity.Member;
import com.ggomg.myshop.domain.post.entity.Category;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class PostCreateRequestToController {
    private Board board;
    private Category category;
    private Member member;
    private String title;
    private String content;
}
