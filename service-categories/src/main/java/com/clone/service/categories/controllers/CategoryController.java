package com.clone.service.categories.controllers;

import com.clone.service.categories.dtos.CategoryDTO;
import com.clone.service.categories.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;
    @GetMapping
    public ResponseEntity<List<CategoryDTO>> findAll(){return ResponseEntity.ok(categoryService.findAll());
    }
    //ResponseEntity para proveer una peticionn completa(Body, header, status)
    @PostMapping
    public ResponseEntity<CategoryDTO> create(@RequestBody CategoryDTO categoryDTO){
        return ResponseEntity.ok(categoryService.create(categoryDTO));
    }

    /*@DeleteMapping("/api/categories/{id}")
    public void deleteCategory(@PathVariable Long id) {
        categoryService.delete(id);
    } */
}
