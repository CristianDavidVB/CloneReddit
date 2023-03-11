package com.clone.service.categories.services;

import com.clone.service.categories.dtos.CategoryDTO;
import com.clone.service.categories.models.Category;
import com.clone.service.categories.repositories.CategoryRepository;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImp implements CategoryService{
    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired ModelMapper modelMapper;
    @Override
    public List<CategoryDTO> findAll() {
        List<Category> categories = categoryRepository.findAll();
        return categories.stream()
                .map(category -> modelMapper.map(category, CategoryDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public CategoryDTO findById(Long id) {
    Category category = categoryRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Category not found with id" + id));
        return modelMapper.map(category, CategoryDTO.class);
    }

    //modificador de acceso(public, private, protected)tipo de retorno, name (parametros)
    @Override
    // modifi  retorno  nombre del metodo y parametros
    public CategoryDTO create(CategoryDTO categoryDTO) {
        Category category = modelMapper.map(categoryDTO, Category.class);
        Category saveCategory = categoryRepository.save(category);
        return modelMapper.map(saveCategory, CategoryDTO.class);
    }

    @Override
    public CategoryDTO update(Long id, CategoryDTO categoryDTO) {
        Category category = categoryRepository.getReferenceById(id);
        category.setName(categoryDTO.getName());
        category.setIcon(categoryDTO.getIcon());
        Category updateCategory = categoryRepository.save(category);
        return modelMapper.map(updateCategory, CategoryDTO.class);
    }

    @Override
    public void delete(Long id) {
        categoryRepository.deleteById(id);
    }

}
