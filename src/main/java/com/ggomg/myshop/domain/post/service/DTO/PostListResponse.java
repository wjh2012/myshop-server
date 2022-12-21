package com.ggomg.myshop.domain.post.service.DTO;

import com.ggomg.myshop.domain.board.Board;
import com.ggomg.myshop.domain.member.entity.Member;
import com.ggomg.myshop.domain.post.entity.Category;
import com.ggomg.myshop.domain.post.entity.Post;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class PostListResponse {
    private Long id;
    private Board board;
    private Category category;
    private Member member;
    private String title;
    private String content;
    private int good;
    private int bad;

    public PostListResponse(Post post) {
        this.id = post.getId();
        this.board = post.getBoard();
        this.category = post.getCategory();
        this.member = post.getMember();
        this.title = post.getTitle();
        this.content = post.getContent();
        this.good = post.getGood();
        this.bad = post.getBad();
    }
}
