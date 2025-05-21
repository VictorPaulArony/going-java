package com.example.blogplatform.service;

import com.example.blogplatform.model.Category;
import com.example.blogplatform.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository){
        this.categoryRepository = categoryRepository;
    }

    //creating a category
    public Category createCategory(Category category){
        if(categoryRepository.findByName(category.getName()).isPresent()) {
            throw  new IllegalArgumentException("Category already exist");
        }
        return categoryRepository.save(category);
    }

    //deleting category
    public void deleteCategory(Long id) {
        Category category = getCategoryById(id);
                category.getPosts().forEach(post -> post.setCategory(null));
        categoryRepository.deleteById(id);
    }

    //updating a category
    public Category updateCategory(Long id, Category updatedCategory) {
        Category category = getCategoryById(id);
        category.setName(updatedCategory.getName());
        return categoryRepository.save(category);
    }

    //get all categories
    public List<Category> getAllCategories(){
        return categoryRepository.findAll();
    }

    //get category by id
    public Category getCategoryById(Long id) {
        return categoryRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Category not found"));
    }
}