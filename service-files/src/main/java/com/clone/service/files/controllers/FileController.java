package com.clone.service.files.controllers;

import com.clone.service.files.dtos.FileDTO;
import com.clone.service.files.services.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/files")
public class FileController {
    @Autowired
    private FileService fileService;

    @GetMapping
    public ResponseEntity<List<FileDTO>> findAll(){
        return ResponseEntity.ok(fileService.findAll());
    }

    @PostMapping
    public ResponseEntity<FileDTO> create(@RequestBody FileDTO fileDTO) {
        return ResponseEntity.ok(fileService.create(fileDTO));
    }
}
