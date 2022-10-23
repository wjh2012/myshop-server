package com.ggomg.myshop.post.controller;

import com.ggomg.myshop.post.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class PostControllerImpl {

    private final PostService postService;

}
