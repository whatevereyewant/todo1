package com.example.todo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller //컨트롤러 선언
public class IndexController {
    @GetMapping(value = "/hello") 
    public String hello() { //스트링을 반환할 것을 선언하기 위해 string 선언
        return "hello"; //html 요청
    }
}

//클라이언트가 localhost:8080/hello 페이지를 get 요청하면 hello.html의 내용을 꺼내줘
// "/hello" 경로로 GET 요청이 오면 "hello" 문자열을 반환하는 컨트롤러를 정의