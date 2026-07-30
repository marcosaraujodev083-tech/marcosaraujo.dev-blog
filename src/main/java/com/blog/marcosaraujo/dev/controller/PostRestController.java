package com.blog.marcosaraujo.dev.controller;

import com.blog.marcosaraujo.dev.dto.PostCreateDTO;
import com.blog.marcosaraujo.dev.dto.PostResponseDTO;
import com.blog.marcosaraujo.dev.model.Post;
import com.blog.marcosaraujo.dev.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/posts")
@RequiredArgsConstructor
public class PostRestController {

    private final PostService postService;

    @PostMapping
    public ResponseEntity<PostResponseDTO> createPost(@RequestBody PostCreateDTO dto) {
        Post createdPost = postService.createPost(dto);
        PostResponseDTO response = PostResponseDTO.fromEntity(createdPost);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}