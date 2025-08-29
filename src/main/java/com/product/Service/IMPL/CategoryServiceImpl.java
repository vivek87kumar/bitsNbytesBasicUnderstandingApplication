package com.product.Service.IMPL;

import com.product.DTO.CategoryDTO;
import com.product.Entity.Category;
import com.product.Repository.CategoryRepository;
import com.product.Service.CategoryService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private CategoryRepository categoryRepository;

//    @Autowired
    private ModelMapper modelMapper;

    @Override
    public CategoryDTO createCategory(CategoryDTO categoryDTO) {
        Category category = this.modelMapper.map(categoryDTO, Category.class);
        category = categoryRepository.save(category);
        return this.modelMapper.map(category, CategoryDTO.class);
    }
}
