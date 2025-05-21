package com.example.blogplatform.repository;

import com.example.blogplatform.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CategoryRepository extends JpaRepository<Category, Long>{

}