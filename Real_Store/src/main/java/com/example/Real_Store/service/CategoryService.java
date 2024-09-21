package com.example.Real_Store.service;

import com.example.Real_Store.dto.CategoryDTO;
import com.example.Real_Store.entity.Category;

import java.util.List;

public interface CategoryService {
    CategoryDTO addCategory(CategoryDTO categoryDTO) throws Exception;

    CategoryDTO getCategoryById(Long categoryId) throws Exception;

    CategoryDTO updateCategory(CategoryDTO categoryDTO);

    String deleteCategoryById(Long categoryId);

    List<CategoryDTO> getAllCategory() throws Exception;
}
