package com.example.validation.controller;

import com.example.validation.dto.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.lang.reflect.Field;

@RestController
@RequestMapping("/api")
public class ApiController {

    // 검사하고 싶은 객체에는 @Valid 를 붙혀주면 된다.
    @PostMapping("/user")
    public ResponseEntity User(@Valid @RequestBody User user, BindingResult bindingResult)
    {
        if(bindingResult.hasErrors())
        {
            StringBuilder sb = new StringBuilder();
            bindingResult.getAllErrors().forEach(objectError ->
            {
                FieldError field = (FieldError) objectError;
                String message = objectError.getDefaultMessage();
                System.out.println("field : " + field.getField());
                System.out.println(message);

                sb.append("field : " + field.getField());
                sb.append("message : " + message);
            });
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(sb.toString());
        }

        System.out.println(user);

        return ResponseEntity.ok(user);
    }

}
