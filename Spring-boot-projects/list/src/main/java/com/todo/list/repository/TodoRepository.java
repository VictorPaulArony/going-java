package com.todo.list.repository;

import com.todo.list.model.TodoItem;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface TodoRepository extends JpaRepository<TodoItem, Long> {
//    List<TodoItem> findByCompleted(boolean completed);
}