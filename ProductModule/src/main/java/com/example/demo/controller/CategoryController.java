package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import jakarta.validation.Valid;

import com.example.demo.entity.Category;
import com.example.demo.service.CategoryService;

@RestController
public class CategoryController {

    private final CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping(value = "/store-category", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> createCategory(@Valid @RequestBody Category category) {
        categoryService.createCategory(category);
        return ResponseEntity.ok("Category created successfully");
    }
    @GetMapping("/category-list")
    public ResponseEntity<List<Category>> getCategories(){
    	List<Category> categories = categoryService.getAllCategories();
    	return ResponseEntity.ok(categories);
    }
}

