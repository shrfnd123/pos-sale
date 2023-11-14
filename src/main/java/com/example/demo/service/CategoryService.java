package com.example.demo.service;

import com.example.demo.entity.Category;
import com.example.demo.repository.CategoryRepository;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class CategoryService {
	
	private final CategoryRepository categoryRepository;
	
	public Category create(Category category) {
		return categoryRepository.save(category);
	}
	
	public List<Category> getCategories() {
        return categoryRepository.findAll();
    }
	
	public Category update(Category updatedCategory) {
		updatedCategory.setUpdatedAt(LocalDateTime.now());
	    return categoryRepository.save(updatedCategory);
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
