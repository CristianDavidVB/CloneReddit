package com.clone.service.likes.services;

import com.clone.service.likes.dtos.LikeDTO;
import com.clone.service.likes.models.Like;
import com.clone.service.likes.repositories.LikeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LikeServiceImp implements LikeService{
    @Autowired
    private LikeRepository likeRepository;

    @Autowired
    private ModelMapper modelMapper;
    @Override
    public List<LikeDTO> findAll() {
        List<Like> likes = likeRepository.findAll();
        return likes.stream()
                .map(like -> modelMapper.map(like, LikeDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public LikeDTO findById(Long id) {
        return null;
    }
}
