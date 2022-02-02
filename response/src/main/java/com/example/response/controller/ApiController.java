package com.example.response.controller;


import com.example.response.dto.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ApiController {

    // text
    // query parameter 의 특정한 값을 return 시킬 예정
    @GetMapping("/text")
    public String text(@RequestParam String account)
    {
        return account;
    }

    // JSON
    // response 를 내려주는 과정
    // request -> object mapper -> object -> method -> object -> object mapper -> json -> response
    @PostMapping("/json")
    public User json(@RequestBody User user)
    {
        return user;
    }

    // PUT 은 리소스가 생성되면 201을 내려줄려고 한다.
    // response 를 내려줄때 http status 를 정해주기 위해서 ResponseEntity 를 이용할것이다
    @PutMapping("/put")
    public ResponseEntity<User> put(@RequestBody User user)
    {   // 201을 내려준다음 body 에 데이터를 내려준다.
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }
}
