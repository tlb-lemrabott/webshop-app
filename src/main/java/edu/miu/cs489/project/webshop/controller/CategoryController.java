package edu.miu.cs489.project.webshop.controller;

import edu.miu.cs489.project.webshop.service.CategoryService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CategoryController {
    private CategoryService categoryService;
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }







}
