package com.ggomg.myshop.post.service.DTO;

import com.ggomg.myshop.board.Board;
import com.ggomg.myshop.member.entity.Member;
import com.ggomg.myshop.post.entity.Category;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class PostCreateRequestToService {
      private Board board;
      private Category category;
      private Member member;
      private String title;
      private String content;
}
