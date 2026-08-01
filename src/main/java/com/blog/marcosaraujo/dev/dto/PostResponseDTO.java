package com.blog.marcosaraujo.dev.dto;

import com.blog.marcosaraujo.dev.model.Post;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PostResponseDTO {

    private Long id;
    private String title;
    private String slug;
    private String summary;
    private String tags;
    private LocalDateTime createdAt;

    public static PostResponseDTO fromEntity(Post post) {
        return PostResponseDTO.builder()
                .id(post.getId())
                .title(post.getTitle())
                .slug(post.getSlug())
                .summary(post.getSummary())
                .createdAt(post.getCreatedAt())
                .build();
    }
}