package com.clone.service.posts.repositories;

import com.clone.service.posts.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}
