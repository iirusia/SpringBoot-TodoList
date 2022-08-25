package com.example.todolist.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Data
@Setter
@NoArgsConstructor
public class TodoRequest {

    private String title;
    private LocalDateTime time;

    public TodoEntity toEntity(){
        return new TodoEntity(null,this.title,this.time);

    }
}
