package com.blog.marcosaraujo.dev.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "posts")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String slug;

    @Column(columnDefinition = "TEXT")
    private String summary;

    @Column(columnDefinition = "TEXT")
    private String content; // Nome exato igual ao Admin

    private boolean draft = true;

    // Nome exato da coluna gerada pelo Admin
    @Column(name = "reading_time_minutes")
    private Integer readingTimeMinutes;

    private LocalDateTime publishedAt;

    @Column(updatable = false)
    private LocalDateTime createdAt;

    private LocalDateTime updateAt;

    // TRATAMENTO DE NULL para o tempo de leitura
    public Integer getReadingTimeMinutes() {
        return readingTimeMinutes != null ? readingTimeMinutes : 1;
    }
}