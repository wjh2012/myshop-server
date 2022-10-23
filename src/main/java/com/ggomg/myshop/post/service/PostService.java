package com.ggomg.myshop.post.service;

import com.ggomg.myshop.post.entity.Post;

import java.util.List;

public interface PostService {
    void save(Post post);

    List<Post> findPosts();

}
