package com.clone.service.categories.services;

import com.clone.service.categories.dtos.SubCategoryDTO;

import java.util.List;

public interface SubCategoryService {
    List<SubCategoryService> findAll();
    SubCategoryDTO findById(Long id);
}
