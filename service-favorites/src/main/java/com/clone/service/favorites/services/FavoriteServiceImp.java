package com.clone.service.favorites.services;

import com.clone.service.favorites.dtos.FavoriteDTO;
import com.clone.service.favorites.models.Favorite;
import com.clone.service.favorites.repositories.FavoriteRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FavoriteServiceImp implements FavoriteService {
    @Autowired
    private FavoriteRepository favoriteRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<FavoriteDTO> findAll() {
        List<Favorite> favorites = favoriteRepository.findAll();
        return favorites.stream()
                .map(favorite -> modelMapper.map(favorite, FavoriteDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public FavoriteDTO findById(Long id) {
        return null;
    }
}
