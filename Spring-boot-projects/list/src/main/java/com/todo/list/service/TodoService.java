package com.todo.list.service;

import com.todo.list.model.TodoItem;
import com.todo.list.repository.TodoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TodoService {

    private final TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public List<TodoItem> getAllTodos() {
        return todoRepository.findAll();
    }

    public Optional<TodoItem> getTodoById(Long id) {
        return todoRepository.findById(id);
    }

    public List<TodoItem> getTodosByStatus(boolean completed) {
        return todoRepository.findByCompleted(completed);
    }

    public TodoItem createTodo(TodoItem todoItem) {
        return todoRepository.save(todoItem);
    }

    public TodoItem updateTodo(Long id, TodoItem updatedDetails) {
        TodoItem item = todoRepository.findById(id).orElseThrow(() -> new RuntimeException("Todo not found"));
        item.setTitle(updatedDetails.getTitle());
        item.setDescription(updatedDetails.getDescription());
        item.setCompleted(updatedDetails.isCompleted());
        return todoRepository.save(item);
    }

    public void deleteTodo(Long id) {
        todoRepository.deleteById(id);
    }
}