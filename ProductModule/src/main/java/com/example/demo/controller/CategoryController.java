package com.example.demo.controller;

import java.awt.PageAttributes.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.entity.Category;
import com.example.demo.service.CategoryService;

@Controller
public class CategoryController {

	private final CategoryService categoryservice;
	
	@Autowired
	public CategoryController(CategoryService categoryservice) {
		this.categoryservice = categoryservice;
	}
	
	@PostMapping(value = "/store-category", consumes = "application/json")
	public ResponseEntity<String> createCategory(@RequestBody Category category){
		System.out.print(category);
		categoryservice.createCategory(category);
		return ResponseEntity.ok("Category created successfully");
	}
	
}
