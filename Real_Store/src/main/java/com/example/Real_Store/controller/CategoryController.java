package com.example.Real_Store.controller;

import com.example.Real_Store.dto.CategoryDTO;
import com.example.Real_Store.entity.Category;
import com.example.Real_Store.service.serviceImpl.CategoryServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {
    private static final Logger logger = LoggerFactory.getLogger(CategoryController.class);

    @Autowired
    public CategoryServiceImpl categoryService;

    @PostMapping("/addCategory")
    public CategoryDTO addCategories(@RequestBody CategoryDTO categoryDTO) throws Exception {
        logger.info("REAL_STORE: ADD CATEGORY METHOD STARTED");
        return categoryService.addCategory(categoryDTO);
    }

    @GetMapping("/getCategoryById")
    public CategoryDTO getCategoryById(@RequestParam("categoryId") Long categoryId)  {
        logger.info("REAL_STORE: GET CATEGORY BY ID METHOD STARTED");
        return categoryService.getCategoryById(categoryId);
    }

    @PutMapping("/updateCategory")
    public CategoryDTO updateCategoryDTO(@RequestBody CategoryDTO categoryDTO){
        logger.info("REAL_STORE: UPDATE CATEGORY METHOD STARTED");
        return categoryService.updateCategory(categoryDTO);
    }

    @DeleteMapping("deleteCategoryId")
    public String deleteCategory(@RequestParam ("categoryId") Long categoryId){
        logger.info("REAL_STORE: DELETE CATEGORY METHOD STARTED");
        return categoryService.deleteCategoryById(categoryId);
    }

    @GetMapping("/getAllCategories")
    public List<CategoryDTO> getAllCategories ()  {
        logger.info("REAL_STORE: GET ALL CATEGORIES METHOD STARTED");
        return categoryService.getAllCategory();
    }
}
