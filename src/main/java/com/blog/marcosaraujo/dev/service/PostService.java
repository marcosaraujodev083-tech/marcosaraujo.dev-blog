package com.blog.marcosaraujo.dev.service;

import com.blog.marcosaraujo.dev.config.MarkdownConverter;
import com.blog.marcosaraujo.dev.model.Post;
import com.blog.marcosaraujo.dev.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;
    private final MarkdownConverter markdownConverter;

    // 1. Busca apenas os posts PUBLICADOS e com data já alcançada/passada
    @Transactional(readOnly = true)
    public List<Post> findAllPublished() {
        return postRepository.findAllPublished();
    }

    // 2. Busca um post específico pelo slug garantindo que ele é público
    @Transactional(readOnly = true)
    public Post findBySlug(String slug) {
        return postRepository.findBySlugPublished(slug)
                .orElseThrow(() -> new IllegalArgumentException("Artigo não encontrado ou não disponível para leitura."));
    }

    // 3. Converte o conteúdo Markdown do banco para HTML para exibir no front-end
    public String renderMarkdownToHtml(String markdown) {
        return markdownConverter.toHtml(markdown);
    }
}