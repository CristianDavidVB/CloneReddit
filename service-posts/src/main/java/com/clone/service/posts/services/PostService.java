package com.clone.service.posts.services;

import com.clone.service.posts.dtos.PostDTO;

import java.util.List;

public interface PostService {
    List<PostDTO> findAll();
    PostDTO findById(Long id);
    PostDTO create(PostDTO postDTO);
    PostDTO update(Long id, PostDTO postDTO);
    void delete(Long id);
}
