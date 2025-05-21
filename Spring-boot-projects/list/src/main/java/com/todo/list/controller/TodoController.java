package com.todo.list.controller;

import com.todo.list.model.TodoItem;
import com.todo.list.service.TodoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/todos")
public class TodoController {

    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    // CREATE
    @PostMapping
    public ResponseEntity<TodoItem> createTodo(@RequestBody TodoItem todoItem) {
        return new ResponseEntity<>(todoService.createTodo(todoItem), HttpStatus.CREATED);
    }

    // READ all
    @GetMapping
    public ResponseEntity<List<TodoItem>> getAllTodos() {
        return ResponseEntity.ok(todoService.getAllTodos());
    }

    // READ by ID
    @GetMapping("/{id}")
    public ResponseEntity<TodoItem> getTodoById(@PathVariable Long id) {
        return ResponseEntity.ok(todoService.getTodoById(id).orElseThrow());
    }

    // UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<TodoItem> updateTodo(@PathVariable Long id, @RequestBody TodoItem updatedDetails) {
        return ResponseEntity.ok(todoService.updateTodo(id, updatedDetails));
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTodo(@PathVariable Long id) {
        todoService.deleteTodo(id);
        return ResponseEntity.noContent().build();
    }

    // FILTER
    @GetMapping("/completed/{status}")
    public ResponseEntity<List<TodoItem>> getTodosByStatus(@PathVariable boolean status) {
        return ResponseEntity.ok(todoService.getTodosByStatus(status));
    }
}