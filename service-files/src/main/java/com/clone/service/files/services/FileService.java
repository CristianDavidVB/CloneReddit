package com.clone.service.files.services;

import com.clone.service.files.dtos.FileDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


public interface FileService {
    List<FileDTO> findAll();
    FileDTO findById(Long id);
}
