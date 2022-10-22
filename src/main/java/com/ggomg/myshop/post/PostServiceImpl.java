package com.ggomg.myshop.post;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class PostServiceImpl implements PostService{

    private final PostRepository postRepository;

    @Override
    public void save(Post post) {
        postRepository.create(post);
    }

    @Override
    public List<Post> findPosts() {
        return postRepository.findAll();
    }
}
