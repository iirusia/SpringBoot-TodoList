package com.example.todolist.service;

import com.example.todolist.model.TodoEntity;
import com.example.todolist.model.TodoRequest;

import com.example.todolist.model.TodoResponse;
import com.example.todolist.repository.TodoListRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class TodoService {
    private final TodoListRepository todoListRepository;

    public TodoService(TodoListRepository todoListRepository) {
        this.todoListRepository = todoListRepository;
    }

    public TodoEntity saveData(TodoRequest request){
        TodoEntity result = todoListRepository.save(request.toEntity());

        return result;
    }

    public List<TodoResponse> findAll(){
        return todoListRepository.findAll().stream().map(TodoResponse::from).collect(Collectors.toList());
    }
    public void deleteById(Long id){
        todoListRepository.deleteById(id);
    }



}
