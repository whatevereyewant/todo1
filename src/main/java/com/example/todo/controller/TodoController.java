package com.example.todo.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.todo.domain.ToDo;
import com.example.todo.repo.ToDoRepo;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor //TodoController라는 생성자의 작성 작업을 줄여주는 도구
public class TodoController {
    
    private final ToDoRepo toDoRepo;

    @GetMapping("/") //이 페이지로 맵핑할 것
    public String index(Model model){
        List<ToDo> todos = toDoRepo.findAll();
        model.addAttribute("todos", todos);
        return "todos";
    }
    
    @PostMapping("/addTodo") //
    public String addTodo(@RequestParam("todo") String todo){
        ToDo toDo = new ToDo();
        toDo.setTodo(todo);
        toDoRepo.save(toDo);
        return "redirect:/";
    }
}
