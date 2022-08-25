package com.example.todolist.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TodoResponse {
    private Long id;
    private String title;
    private LocalDateTime time;

    public TodoResponse(TodoEntity todoEntity){
        this.id = todoEntity.getId();
        this.title = todoEntity.getTitle();
        this.time = todoEntity.getRegisterTime();
    }
    public static TodoResponse from(TodoEntity entity){
        return new TodoResponse(entity.getId(),entity.getTitle(),entity.getRegisterTime());
    }
}
