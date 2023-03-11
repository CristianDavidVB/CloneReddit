package com.clone.service.categories.services;

import com.clone.service.categories.dtos.SubCategoryDTO;
import com.clone.service.categories.models.SubCategory;
import com.clone.service.categories.repositories.SubCategoryRepository;
import jakarta.persistence.EntityNotFoundException;
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
        SubCategory subCategory = subCategoryRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Subcategorie not found with by id" + id));
        return modelMapper.map(subCategory, SubCategoryDTO.class);
    }

    @Override
    public SubCategoryDTO create(SubCategoryDTO subCategoryDTO) {
        SubCategory subCategory = modelMapper.map(subCategoryDTO, SubCategory.class);
        SubCategory saveSubCategory = subCategoryRepository.save(subCategory);
        return modelMapper.map(saveSubCategory, SubCategoryDTO.class);
    }

   @Override
   public SubCategoryDTO update(Long id, SubCategoryDTO subCategoryDTO) {
        SubCategory subCategory = subCategoryRepository.getReferenceById(id);
        subCategory.setName(subCategoryDTO.getName());
        SubCategory updateSubCategory = subCategoryRepository.save(subCategory);
        return modelMapper.map(updateSubCategory, SubCategoryDTO.class);
   }

    @Override
    public void delete(Long id) {
        subCategoryRepository.deleteById(id);
    }
}
