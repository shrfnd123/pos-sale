package com.example.demo.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entity.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer>{

}
