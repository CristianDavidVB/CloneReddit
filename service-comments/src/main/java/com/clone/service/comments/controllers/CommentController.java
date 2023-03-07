package com.clone.service.comments.controllers;
import com.clone.service.comments.dtos.CommentDTO;
import com.clone.service.comments.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comments")
public class CommentController {
    @Autowired
    private CommentService commentService;

    @GetMapping
    public ResponseEntity<List<CommentDTO>> findAll(){
        return ResponseEntity.ok(commentService.findAll());
    }

    @PostMapping
    public ResponseEntity<CommentDTO> create(@RequestBody CommentDTO commentDTO) {
        return ResponseEntity.ok(commentService.create(commentDTO));
    }
}
