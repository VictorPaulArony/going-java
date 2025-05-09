package com.todo.todoList.repository;

import com.todo.todoList.model.Todo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class TodoRepository {
    

   private final Map<Long, Todo> store = new HashMap<>();
    private long currentId = 1;

    public List<Todo> findAll() {
        return new ArrayList<>(store.values());
    }

    public Optional<Todo> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    public Todo save(Todo todo) {
        todo.setId(currentId++);
        store.put(todo.getId(), todo);
        return todo;
    }
    
}
