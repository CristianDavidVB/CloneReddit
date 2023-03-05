package com.clone.service.files.services;

import com.clone.service.files.dtos.FileDTO;
import com.clone.service.files.models.File;
import com.clone.service.files.repositories.FileRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FileServiceImp implements FileService{
    @Autowired
    private FileRepository fileRepository;

    @Autowired
    private ModelMapper modelMapper;
    @Override
    public List<FileDTO> findAll() {
        List<File> files = fileRepository.findAll();
        return files.stream()
                .map(file -> modelMapper.map(file, FileDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public FileDTO findById(Long id) {
        return null;
    }
}
