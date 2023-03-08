package com.clone.service.posts.controllers;

import com.clone.service.posts.dtos.PostDTO;
import com.clone.service.posts.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
public class PostController {
    @Autowired
    private PostService postService;

    @GetMapping
    public ResponseEntity<List<PostDTO>> findAll(){
        return ResponseEntity.ok(postService.findAll());
    }

    @PostMapping
    public ResponseEntity<PostDTO> craete(@RequestBody PostDTO postDTO){
        return ResponseEntity.ok(postService.create(postDTO));
    }


}
