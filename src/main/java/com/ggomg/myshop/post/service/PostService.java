package com.ggomg.myshop.post.service;

import com.ggomg.myshop.member.entity.Member;
import com.ggomg.myshop.post.service.DTO.PostCreateRequestToService;
import com.ggomg.myshop.post.service.DTO.PostListResponse;
import java.util.List;

public interface PostService {
    Long save(PostCreateRequestToService postCreateRequestToService);

    List<PostListResponse> findAllPosts();

    List<PostListResponse> findByTitle(String title);

    List<PostListResponse> findByMember(Member member);

    List<PostListResponse> findByContent(String content);

    List<PostListResponse> findByTitleOrContent(String title, String content);
}
