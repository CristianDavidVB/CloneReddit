package com.clone.service.files.controllers;

import com.clone.service.files.dtos.FileDTO;
import com.clone.service.files.services.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
