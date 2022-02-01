package com.example.hello.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// 이 Class 는 RestApi 를 처리하는 Controller
@RestController
// RequestMapping URI 를 지정해주는 Annotation
@RequestMapping("/api")
public class ApiController {

    // http://localhost:9090/api/hello
    @GetMapping("/hello")
    public String hello()
    {
        return "hello Spring Boot";
    }

}
