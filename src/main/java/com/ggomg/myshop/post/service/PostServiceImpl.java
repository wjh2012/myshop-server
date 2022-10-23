package com.ggomg.myshop.post.service;

import com.ggomg.myshop.post.entity.Post;
import com.ggomg.myshop.post.repository.PostRepository;
import com.ggomg.myshop.post.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;

    @Override
    @Transactional(readOnly = false)
    public void save(Post post) {
        postRepository.create(post);
    }

    @Override
    public List<Post> findPosts() {
        return postRepository.findAll();
    }
}
