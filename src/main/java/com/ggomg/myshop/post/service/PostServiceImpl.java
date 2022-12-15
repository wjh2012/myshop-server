package com.ggomg.myshop.post.service;

import com.ggomg.myshop.member.entity.Member;
import com.ggomg.myshop.post.entity.Post;
import com.ggomg.myshop.post.repository.PostRepository;
import com.ggomg.myshop.post.service.DTO.PostCreateRequestToService;
import com.ggomg.myshop.post.service.DTO.PostListResponse;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;

    @Override
    @Transactional(readOnly = false)
    public Long save(PostCreateRequestToService request) {

        Post post = Post.builder()
                .board(request.getBoard())
                .category(request.getCategory())
                .member(request.getMember())
                .title(request.getTitle())
                .content(request.getContent())
                .build();

        postRepository.create(post);
        return post.getId();
    }

    @Override
    public List<PostListResponse> findAllPosts() {

        List<Post> findPosts = postRepository.findAll();

        return findPosts.stream()
                .map(PostListResponse::new)
                .collect((Collectors.toList()));
    }

    @Override
    public List<PostListResponse> findByTitle(String title) {
        List<Post> findPosts = postRepository.findAll();

        return findPosts.stream()
                .map(PostListResponse::new)
                .collect((Collectors.toList()));
    }

    @Override
    public List<PostListResponse> findByMember(Member member) {
        List<Post> findPosts = postRepository.findAll();

        return findPosts.stream()
                .map(PostListResponse::new)
                .collect((Collectors.toList()));
    }

    @Override
    public List<PostListResponse> findByContent(String content) {
        List<Post> findPosts = postRepository.findAll();

        return findPosts.stream()
                .map(PostListResponse::new)
                .collect((Collectors.toList()));
    }

    @Override
    public List<PostListResponse> findByTitleOrContent(String title, String content) {
        List<Post> findPosts = postRepository.findAll();

        return findPosts.stream()
                .map(PostListResponse::new)
                .collect((Collectors.toList()));
    }
}
