package com.clone.service.categories.controllers;

import com.clone.service.categories.dtos.SubCategoryDTO;
import com.clone.service.categories.services.SubCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/subcategories")
public class SubCategoryController {
    @Autowired
    private SubCategoryService subCategoryService;
    @GetMapping
    public ResponseEntity<List<SubCategoryDTO>> findAll(){
        return  ResponseEntity.ok(subCategoryService.findAll());
    }

    @PostMapping
    public ResponseEntity<SubCategoryDTO>create(@RequestBody SubCategoryDTO subCategoryDTO){
        return ResponseEntity.ok(subCategoryService.create(subCategoryDTO));
    }
}
