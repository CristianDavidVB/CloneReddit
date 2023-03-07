package com.clone.service.categories.services;

import com.clone.service.categories.dtos.SubCategoryDTO;
import com.clone.service.categories.models.SubCategory;
import com.clone.service.categories.repositories.SubCategoryRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SubCategoryServiceImp implements SubCategoryService{
    @Autowired
    private SubCategoryRepository subCategoryRepository;

    @Autowired
    private ModelMapper modelMapper;
    @Override
    public List<SubCategoryDTO> findAll() {
        List<SubCategory> subCategories = subCategoryRepository.findAll();
        return subCategories.stream()
                .map(subCategory -> modelMapper.map(subCategory, SubCategoryDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public SubCategoryDTO findById(Long id) {
        return null;
    }

    @Override
    public SubCategoryDTO create(SubCategoryDTO subCategoryDTO) {
        SubCategory subCategory = modelMapper.map(subCategoryDTO, SubCategory.class);
        SubCategory saveSubCategory = subCategoryRepository.save(subCategory);
        return modelMapper.map(saveSubCategory, SubCategoryDTO.class);
    }
}
