package com.blog.marcosaraujo.dev.controller;

import com.blog.marcosaraujo.dev.dto.PostResponseDTO;
import com.blog.marcosaraujo.dev.model.Post;
import com.blog.marcosaraujo.dev.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/posts")
@RequiredArgsConstructor
public class PostRestController {

    private final PostService postService;

    // Retorna todos os posts publicados em formato JSON
    @GetMapping
    public ResponseEntity<List<PostResponseDTO>> getAllPublishedPosts() {
        List<PostResponseDTO> posts = postService.findAllPublished()
                .stream()
                .map(PostResponseDTO::fromEntity)
                .toList();

        return ResponseEntity.ok(posts);
    }

    // Retorna os dados de um post específico pelo Slug em formato JSON
    @GetMapping("/{slug}")
    public ResponseEntity<PostResponseDTO> getPostBySlug(@PathVariable("slug") String slug) {
        Post post = postService.findBySlug(slug);
        PostResponseDTO response = PostResponseDTO.fromEntity(post);

        return ResponseEntity.ok(response);
    }
}