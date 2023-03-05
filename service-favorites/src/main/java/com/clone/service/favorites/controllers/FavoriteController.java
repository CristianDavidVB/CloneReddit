package com.clone.service.favorites.controllers;

import com.clone.service.favorites.dtos.FavoriteDTO;
import com.clone.service.favorites.services.FavoriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/favorites")
public class FavoriteController {
    @Autowired
    private FavoriteService favoriteService;

    @GetMapping
    public ResponseEntity<List<FavoriteDTO>> findAll(){
        return  ResponseEntity.ok(favoriteService.findAll());
    }
}
