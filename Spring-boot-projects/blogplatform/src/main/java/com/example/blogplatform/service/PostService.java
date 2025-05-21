package com.example.blogplatform.service;

import com.example.blogplatform.model.Category;
import com.example.blogplatform.model.Post;
import com.example.blogplatform.repository.CategoryRepository;
import com.example.blogplatform.repository.PostRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class PostService {

    private final PostRepository postRepository;
    private final CategoryRepository categoryRepository;

    public PostService(PostRepository postRepository, CategoryRepository categoryRepository) {
        this.postRepository = postRepository;
        this.categoryRepository = categoryRepository;
    }

    // Create Post
    public Post createPost(Post post, Long categoryId) {
        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new NoSuchElementException("Category not found"));

        post.setCategory(category);
        return postRepository.save(post);
    }

    // Update Post
    public Post updatePost(Long id, Post updatedPost) {
        Post post = getPostById(id);

        post.setTitle(updatedPost.getTitle());
        post.setContent(updatedPost.getContent());

        if (!post.getCategory().getId().equals(updatedPost.getCategory().getId())) {
            Category newCategory = categoryRepository.findById(updatedPost.getCategory().getId())
                    .orElseThrow(() -> new NoSuchElementException("New category not found"));
            post.setCategory(newCategory);
        }

        return postRepository.save(post);
    }

    // Delete Post
    public void deletePost(Long id) {
        Post post = getPostById(id);
        post.setCategory(null); // Remove association before deletion
        postRepository.deleteById(id);
    }

    // Get All Posts
    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    // Get Post by ID
    public Post getPostById(Long id) {
        return postRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Post not found"));
    }

    // Get Posts by Category
    public List<Post> getPostsByCategory(Long categoryId) {
        return postRepository.findByCategoryId(categoryId);
    }
}