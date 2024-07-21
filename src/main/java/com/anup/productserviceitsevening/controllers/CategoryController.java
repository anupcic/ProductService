package com.anup.productserviceitsevening.controllers;

import com.anup.productserviceitsevening.services.CategoryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products/categories")
public class CategoryController {

    private CategoryService categoryService;
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }


    @GetMapping()
    public String getAllCategories() {
        return "Categories";
    }
    @GetMapping("/{categoryId}")
    public String getProductinCategory(@PathVariable("categoryId") Long categoryId) {
        return "product in category" + categoryId;
    }
}
