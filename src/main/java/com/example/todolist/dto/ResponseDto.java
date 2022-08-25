package com.example.todolist.dto;

import com.example.todolist.model.TodoEntity;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@ToString
public class ResponseDto {
    private Long id;
    private String title;
    private LocalDateTime registerTime;

    public ResponseDto(TodoEntity entity){
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.registerTime = entity.getRegisterTime();
    }
}
