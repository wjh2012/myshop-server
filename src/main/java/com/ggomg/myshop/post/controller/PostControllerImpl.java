package com.ggomg.myshop.post.controller;

import com.ggomg.myshop.post.controller.DTO.PostCreateRequestToController;
import com.ggomg.myshop.post.service.DTO.PostCreateRequestToService;
import com.ggomg.myshop.post.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class PostControllerImpl {

    private final PostService postService;

    @PostMapping("/createpost")
    public Long savePost(@RequestBody PostCreateRequestToController request) {
        return postService.save(
                new PostCreateRequestToService(
                        request.getBoard(),
                        request.getCategory(),
                        request.getMember(),
                        request.getTitle(),
                        request.getContent()));
    }


}
