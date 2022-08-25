package com.example.todolist.controller;

import com.example.todolist.dto.ResponseDto;
import com.example.todolist.model.TodoEntity;
import com.example.todolist.model.TodoRequest;
import com.example.todolist.model.TodoResponse;
import com.example.todolist.service.TodoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@Slf4j
@Controller
@RequiredArgsConstructor
public class TodoController {

    private final TodoService todoService;

    @PostMapping("/index")
    public String create(TodoRequest request){
        log.info(request.getTitle());
        request.setTime(LocalDateTime.now());
        TodoEntity result = todoService.saveData(request);
        return "redirect:/index";
    }
    @GetMapping("/index")
    public String get(Model model) throws Exception{
        try{
                model.addAttribute("result",todoService.findAll());
        }catch(Exception e){
            throw new Exception(e.getMessage());
        }

        return "index";
    }

    @PostMapping("/delete")
    public String delete(@RequestParam() Long id) throws Exception{
        try{
            todoService.deleteById(id);
        }catch(Exception e){
            throw new Exception(e.getMessage());
        }
        return "redirect:/index";

    }

}
