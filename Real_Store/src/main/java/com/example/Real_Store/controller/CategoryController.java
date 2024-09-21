package com.example.Real_Store.controller;

import com.example.Real_Store.dto.CategoryDTO;
import com.example.Real_Store.entity.Category;
import com.example.Real_Store.service.serviceImpl.CategoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    public CategoryServiceImpl categoryService;

    @PostMapping("/addCategory")
    public CategoryDTO addCategories(@RequestBody CategoryDTO categoryDTO) throws Exception {
        return categoryService.addCategory(categoryDTO);
    }

    @GetMapping("/getCategoryById")
    public CategoryDTO getCategoryById(@RequestParam("categoryId") Long categoryId) throws Exception {
        return categoryService.getCategoryById(categoryId);
    }

    @PutMapping("/updateCategory")
    public CategoryDTO updateCategoryDTO(@RequestBody CategoryDTO categoryDTO){
        return categoryService.updateCategory(categoryDTO);
    }

    @DeleteMapping("deleteCategoryId")
    public String deleteCategory(@RequestParam ("categoryId") Long categoryId){
        return categoryService.deleteCategoryById(categoryId);
    }

    @GetMapping("/getAllCategories")
    public List<CategoryDTO> getAllCategories () throws Exception {
        return categoryService.getAllCategory();
    }

}
