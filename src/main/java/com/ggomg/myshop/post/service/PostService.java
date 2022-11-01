package com.ggomg.myshop.post.service;

import com.ggomg.myshop.member.entity.Member;
import com.ggomg.myshop.post.entity.Post;
import com.ggomg.myshop.post.service.DTO.PostCreateRequestToService;
import com.ggomg.myshop.post.service.DTO.PostListResponse;

import java.util.List;

public interface PostService {
    Long save(PostCreateRequestToService postCreateRequestToService);

    List<PostListResponse> findAllPosts();

    List<Post> findByTitle(String title);

    List<Post> findByMember(Member member);

    List<Post> findByContent(String content);

    List<Post> findByTitleOrContent(String title, String content);
}
