package com.blog.marcosaraujo.dev.controller;

import com.blog.marcosaraujo.dev.model.Post;
import com.blog.marcosaraujo.dev.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class PostWebController {

    private final PostService postService;

    @GetMapping("/")
    public String index(Model model) {
        List<Post> posts = postService.findAll();
        model.addAttribute("posts", posts);
        return "index";
    }

    @GetMapping("/post/{slug}")
    public String viewPost(@PathVariable String slug, Model model) {
        Post post = postService.findBySlug(slug);

        String contentHtml = postService.renderMarkdownToHtml(post.getContentMarkdown());

        model.addAttribute("post", post);
        model.addAttribute("contentHtml", contentHtml);
        return "post";
    }

    @GetMapping("/contato")
    public String contato() {
        return "contato";
    }
}