package com.example.exception.controller;

import com.example.exception.dto.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/user")
public class RestApiController {


    // required = false 는 RequestParam 가 없어도 동작은 하되, null 이 되는 것.
    @GetMapping("")
    public User get(@RequestParam(required = false) String name, @RequestParam(required = false) Integer age)
    {
        User user = new User();
        user.setName(name);
        user.setAge(age);

        int a = 10 + age;

        return user;
    }

    @PostMapping("")
    public User post(@Valid @RequestBody User user)
    {
        System.out.println("post 확인");
        return user;
    }

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseEntity methodArgumentNotValidException(MethodArgumentNotValidException e)
    {
        System.out.println("RestApiController Exception");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }

}
