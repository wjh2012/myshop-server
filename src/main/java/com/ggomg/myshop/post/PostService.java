package com.ggomg.myshop.post;

import java.util.List;

public interface PostService {
    void save(Post post);

    List<Post> findPosts();

}
