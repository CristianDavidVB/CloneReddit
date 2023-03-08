package com.clone.service.posts.services;

import com.clone.service.posts.dtos.PostDTO;
import com.clone.service.posts.models.Post;
import com.clone.service.posts.repositories.PostRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImp implements PostService{

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private ModelMapper modelMapper;
    @Override
    public List<PostDTO> findAll() {
        List<Post> posts = postRepository.findAll();
        return posts.stream()
                .map(post -> modelMapper.map(post,PostDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public PostDTO findById(Long id) {
        return null;
    }

    @Override
    public PostDTO create(PostDTO postDTO) {
        Post post = modelMapper.map(postDTO, Post.class);
        Post savepost = postRepository.save(post);
        return modelMapper.map(savepost, PostDTO.class);

    }
}
