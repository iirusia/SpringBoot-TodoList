package com.example.todolist.repository;

import com.example.todolist.model.TodoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoListRepository extends JpaRepository<TodoEntity,Long> {
}
