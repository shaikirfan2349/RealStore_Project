package com.example.Real_Store.service.serviceImpl;

import com.example.Real_Store.conversion.ConversionClass;
import com.example.Real_Store.dto.CategoryDTO;
import com.example.Real_Store.entity.Category;
import com.example.Real_Store.entity.Product;
import com.example.Real_Store.repository.CategoryRepository;
import com.example.Real_Store.repository.ProductRepository;
import com.example.Real_Store.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    public CategoryRepository categoryRepository;
    @Autowired
    public ConversionClass conversionClass;
    @Autowired
    public ProductRepository productRepository;

    @Override
    public CategoryDTO addCategory(CategoryDTO categoryDTO) throws Exception {
        if(categoryDTO!=null){
            Category category = conversionClass.CategoryDTO_To_CategoryEntity(categoryDTO);
            categoryRepository.save(category);
            return conversionClass.CategoryEntity_To_CategoryDTO(category);
        }else{
            throw new Exception("categoryDTO should not null");
        }
    }

    @Override
    public CategoryDTO getCategoryById(Long categoryId) throws Exception {

        try{
            if(categoryId!=null){
                Category category = categoryRepository.findById(categoryId).get();
                CategoryDTO categoryDTO = conversionClass.CategoryEntity_To_CategoryDTO(category);
                return categoryDTO;
            }
        }catch (Exception e){
            throw new Exception("categoryId not found");
        }
        return null;
    }

    @Override
    public CategoryDTO updateCategory(CategoryDTO categoryDTO) {
        Long categoryId = categoryDTO.getCategoryId();
        Category category = categoryRepository.findById(categoryId).get();
        category.setName(categoryDTO.getName());
        category.setDescription(categoryDTO.getDescription());
        CategoryDTO categoryDTO1 = conversionClass.CategoryEntity_To_CategoryDTO(category);
        return categoryDTO1;
    }

    @Override
    public String deleteCategoryById(Long categoryId) {
        try{
            categoryRepository.deleteById(categoryId);
            return "category deleted";
        }catch (NoSuchElementException e){
            return  "category not found";
        }
    }

    @Override
    public List<CategoryDTO> getAllCategory() throws Exception {
        try{
            List<Category> categoryDTOList = categoryRepository.findAll().stream().collect(Collectors.toList());
            return categoryDTOList.stream().map(category -> conversionClass.CategoryEntity_To_CategoryDTO(category)).toList();
        } catch (Exception e){
            throw new Exception("Category List is Empty");
        }

    }


}
