package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Category;
import com.example.demo.repository.CategoryRepository;

@Service
public class CategoryService {
	
	private final CategoryRepository categoryrepository;
	
	@Autowired
	public CategoryService(CategoryRepository categoryrepo) {
		this.categoryrepository = categoryrepo;
	}
	
	public void createCategory(Category category) {
		categoryrepository.save(category);
	}

}