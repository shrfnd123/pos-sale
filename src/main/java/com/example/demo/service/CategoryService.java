package com.example.demo.service;

import com.example.demo.entity.Category;
import com.example.demo.repository.CategoryRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CategoryService {
	
	private final CategoryRepository categoryRepository;
	
	@Autowired
	public CategoryService(CategoryRepository categoryRepository) {
		
		this.categoryRepository = categoryRepository;
	}
	
	public void createCategory(Category category) {
		
		categoryRepository.save(category);
	}
	
	public List<Category> getAllCategories() {
		
        return categoryRepository.findAll();
    }
	
	public boolean updateCategory(Integer id, Category updatedCategory) {
		
	    Optional<Category> existingCategory = categoryRepository.findById(id);
	    
	    if (existingCategory.isPresent()) {
	        Category category = existingCategory.get();
	        // Update the category fields with the values from updatedCategory
	        category.setCategoryName(updatedCategory.getCategoryName());
	        category.setCategoryType(updatedCategory.getCategoryType());
	        // ...

	        categoryRepository.save(category);
	        return true;
	    } else {
	        return false;
	    }
	}
	
	public boolean deleteCategory(Integer id) {
		
	        Optional<Category> categoryOptional = categoryRepository.findById(id);
	        
	        if (categoryOptional.isPresent()) {
	            categoryRepository.deleteById(id);
	            return true;
	        }
	        return false;
	}
	 
	public Category getCategoryById(Integer id) {
		
	        return categoryRepository.findById(id).orElse(null);
    }
}
