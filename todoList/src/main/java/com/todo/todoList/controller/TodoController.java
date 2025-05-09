package com.todo.todoList.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.todo.todoList.model.Todo;
import com.todo.todoList.repository.TodoRepository;

@RestController
@RequestMapping("/todos")
public class TodoController{
    // This class will handle the CRUD operations for the Todo model
    // use an in-memory list to store the todos

    private final TodoRepository repository;

    public TodoController(TodoRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Todo> getAllTodos() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Todo getTodoById(@PathVariable Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Todo not found"));
    }

    @PostMapping
    public Todo createTodo(@RequestBody Todo todo) {
        return repository.save(todo);
    }
}
/*
 # Create a new todo
curl -X POST http://localhost:8080/todos \
     -H "Content-Type: application/json" \
     -d '{"task": "Learn Spring Boot", "completed": false} \'

# Get all todos
curl http://localhost:8080/todos

# Get todo by ID
curl http://localhost:8080/todos/1
# Update todo
curl -X PUT http://localhost:8080/todos/1 \
     -H "Content-Type: application/json" \
     -d '{"task": "Learn Spring Boot", "completed": true}'
 */