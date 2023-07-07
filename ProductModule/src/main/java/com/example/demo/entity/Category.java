package com.example.demo.entity;

import com.example.demo.entity.Product;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.time.LocalDateTime;
import java.util.Collection;


import jakarta.validation.constraints.NotBlank;
import jakarta.persistence.Column;


@Entity
public class Category {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@NotBlank(message = "Category name must not be blank")
	private String categoryName;
	private String categoryType;
	private String categoryDescription;
	@Column(name = "created_at", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private LocalDateTime createdAt;
	@Column(name = "updated_at", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private LocalDateTime updatedAt;
	@OneToMany(mappedBy="category", fetch = FetchType.LAZY)
    Collection<Product> products;
	
	public Category() {
		// Default constructor required by JPA
	}

	public Category(String categoryName, String categoryType, String categoryDescription, LocalDateTime createdAt, LocalDateTime updatedAt) {
		this.categoryName = categoryName;
		this.categoryType = categoryType;
		this.categoryDescription = categoryDescription;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	// Getters and setters for all attributes

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getCategoryType() {
		return categoryType;
	}

	public void setCategoryType(String categoryType) {
		this.categoryType = categoryType;
	}

	public String getCategoryDescription() {
		return categoryDescription;
	}

	public void setCategoryDescription(String categoryDescription) {
		this.categoryDescription = categoryDescription;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}
}

