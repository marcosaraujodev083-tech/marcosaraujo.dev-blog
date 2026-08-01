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

    // Listagem da Home: busca apenas os posts publicados e dentro do prazo
    @GetMapping("/")
    public String index(Model model) {
        List<Post> posts = postService.findAllPublished();
        model.addAttribute("posts", posts);
        return "index";
    }

    // Leitura do Artigo: busca o post pelo slug e converte o Markdown para HTML
    @GetMapping("/post/{slug}")
    public String viewPost(@PathVariable("slug") String slug, Model model) {
        Post post = postService.findBySlug(slug);

        // Converte o Markdown armazenado no Supabase (campo 'content') para HTML
        String contentHtml = postService.renderMarkdownToHtml(post.getContent());

        model.addAttribute("post", post);
        model.addAttribute("contentHtml", contentHtml);
        return "post";
    }

    // Página de Contato
    @GetMapping("/contato")
    public String contato() {
        return "contato";
    }
}