package com.example.response.controller;

import com.example.response.dto.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

// html 페이지를 리턴해주는 컨트롤러
// @Controller 는 String 을 리턴하게되면 리소스를 찾게 되지만
// @ResponseBody 를 붙혀주면 ResponseBody 를 만들어서 내려준다.
@Controller
public class PageController {

    @RequestMapping("/main")
    public String main()
    {
        return "main.html";
    }

    // json 을 내려주는 방법
    // 1. @ResponseEntity
    // 2. @ResponseBody
    @ResponseBody
    @GetMapping("/user")
    public User user()
    {
        // 타입 추론을 할 수 있는 var 사용
        // 값을 넣어주지 않으면 null 값이 리턴된다.
        var user = new User();
        user.setName("steve");
        user.setAddress("서울시 관악구");
        return user;
    }

}
