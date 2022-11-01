package com.ggomg.myshop.post.service;

import com.ggomg.myshop.member.entity.Member;
import com.ggomg.myshop.post.entity.Post;

import java.util.List;

public interface PostService {
    void save(Post post);

    List<Post> findPosts();

    List<Post> findByTitle(String title);

    List<Post> findByMember(Member member);

    List<Post> findByContent(String content);

    List<Post> findByTitleOrContent(String title, String content);
}
