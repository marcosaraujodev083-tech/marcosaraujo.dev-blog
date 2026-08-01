package com.blog.marcosaraujo.dev.repository;

import com.blog.marcosaraujo.dev.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface PostRepository extends  JpaRepository<Post, Long> {

    @Query("SELECT p FROM Post p WHERE p.draft = false AND p.publishedAt <= CURRENT_TIMESTAMP ORDER BY p.publishedAt DESC")
    List<Post> findAllPublished();

    @Query("SELECT p FROM Post p WHERE p.slug = :slug AND p.draft = false AND p.publishedAt <= CURRENT_TIMESTAMP")
    Optional<Post> findBySlugPublished(@Param("slug") String slug);
}