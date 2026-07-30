package com.blog.marcosaraujo.dev.service;

import com.blog.marcosaraujo.dev.config.MarkdownConverter;
import com.blog.marcosaraujo.dev.dto.PostCreateDTO;
import com.blog.marcosaraujo.dev.model.Post;
import com.blog.marcosaraujo.dev.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.Normalizer;
import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;
    private final MarkdownConverter markdownConverter;

    private static final Pattern NONLATIN = Pattern.compile("[^\\w-]");
    private static final Pattern WHITESPACE = Pattern.compile("[\\s]");

    @Transactional(readOnly = true)
    public List<Post> findAll() {
        return postRepository.findAllByOrderByCreatedAtDesc();
    }

    @Transactional(readOnly = true)
    public Post findBySlug(String slug) {
        return postRepository.findBySlug(slug)
                .orElseThrow(() -> new IllegalArgumentException("Artigo não encontrado para o slug: " + slug));
    }

    @Transactional
    public Post createPost(PostCreateDTO dto) {
        String generatedSlug = generateSlug(dto.getTitle());

        if (postRepository.existsBySlug(generatedSlug)) {
            generatedSlug = generatedSlug + "-" + System.currentTimeMillis();
        }

        Post post = Post.builder()
                .title(dto.getTitle())
                .slug(generatedSlug)
                .summary(dto.getSummary())
                .contentMarkdown(dto.getContentMarkdown())
                .tags(dto.getTags())
                .build();

        return postRepository.save(post);
    }

    public String renderMarkdownToHtml(String markdown) {
        return markdownConverter.toHtml(markdown);
    }

    private String generateSlug(String input) {
        if (input == null) return "";
        String nowhitespace = WHITESPACE.matcher(input).replaceAll("-");
        String normalized = Normalizer.normalize(nowhitespace, Normalizer.Form.NFD);
        String slug = NONLATIN.matcher(normalized).replaceAll("");
        return slug.toLowerCase(Locale.ENGLISH);
    }
}