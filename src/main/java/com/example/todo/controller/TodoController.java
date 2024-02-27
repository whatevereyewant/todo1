package com.example.todo.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.todo.entity.ToDo;
import com.example.todo.repo.ToDoRepo;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor //TodoController라는 생성자의 작성 작업을 줄여주는 도구 final 에 쓰여있는 아이들을 데리고 옴
public class TodoController {
    
    private final ToDoRepo toDoRepo;

    @GetMapping("/") //이 페이지로 맵핑할 것
    public String index(Model model){ //모델 객체를 받아서
        List<ToDo> todos = toDoRepo.findAll(); //투두 목록을 조회한 후
        model.addAttribute("todos", todos);
        return "todos"; //투두스란 이름으로 뷰에 전달
    }
    
    @PostMapping("/addTodo") //새로운 투두를 등록하기 위해 호출할 수 있음
    public String addTodo(@RequestParam("todo") String todo){ //해당 메서드는 투두값을 받아서
        ToDo toDo = new ToDo(); //새로운 투두 객체를 생성하고
        toDo.setTodo(todo); 
        toDoRepo.save(toDo); //해당 객체를 저장한 후
        return "redirect:/"; // /이라는 경로로 리다이렉트함
    }
}
