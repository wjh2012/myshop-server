package com.ggomg.myshop.domain.post.service;

import com.ggomg.myshop.domain.member.entity.Member;
import com.ggomg.myshop.domain.post.service.DTO.PostListResponse;
import com.ggomg.myshop.domain.post.service.DTO.PostCreateRequestToService;
import java.util.List;

public interface PostService {
    Long save(PostCreateRequestToService postCreateRequestToService);

    List<PostListResponse> findAllPosts();

    List<PostListResponse> findByTitle(String title);

    List<PostListResponse> findByMember(Member member);

    List<PostListResponse> findByContent(String content);

    List<PostListResponse> findByTitleOrContent(String title, String content);
}
