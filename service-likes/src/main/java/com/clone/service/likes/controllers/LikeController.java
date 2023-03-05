package com.clone.service.likes.controllers;

import com.clone.service.likes.dtos.LikeDTO;
import com.clone.service.likes.services.LikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/likes")
public class LikeController {
    @Autowired
    private LikeService likeService;
    @GetMapping
    public ResponseEntity<List<LikeDTO>> findAll(){
        return ResponseEntity.ok(likeService.findAll());
    }
}


