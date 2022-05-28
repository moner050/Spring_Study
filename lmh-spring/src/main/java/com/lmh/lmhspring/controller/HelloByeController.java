package com.lmh.lmhspring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloByeController {

    // path 를 hello 로 설정해줌.
    @GetMapping("hello")
    public String hello(Model model)
    {   // data 라는 Attribute 에 hello!! 를 추가해줌.
        model.addAttribute("data", "hello!!");
        // 그리고 templates 에 hello 라는 이름을 가진 html 파일을 리턴.
        return "hello";
    }

    // path 를 bye 로 설정해줌.
    @GetMapping("bye")
    public String bye(Model model)
    {   // data 라는 Attribute 에 bye!!!!! 를 추가해줌.
        model.addAttribute("data", "bye!!!!!");
        // 그리고 templates 에 bye 라는 이름을 가진 html 파일을 리턴.
        return "bye";
    }
}
