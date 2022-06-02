package com.lmh.lmhspring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloByeController {

    // path 를 hello 로 설정해줌.
    @GetMapping("hello")
    public String hello(Model model)
    {   // data 라는 Attribute 에 hello!! 를 추가해줌.
        model.addAttribute("data", "hello!!");
        // 그리고 templates 에 hello 라는 이름을 가진 파일을 리턴.
        return "hello";
    }

    // path 를 bye 로 설정해줌.
    @GetMapping("bye")
    public String bye(Model model)
    {   // data 라는 Attribute 에 bye!!!!! 를 추가해줌.
        model.addAttribute("data", "bye!!!!!");
        // 그리고 templates 에 bye 라는 이름을 가진 파일을 리턴.
        return "bye";
    }

    // path 를 hello-mvc 로 설정
    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam("name") String name, Model model)
    {   // name 의 파라미터 값을 받고 name 이라는 Attribute 에 추가해줌.
        // 만약 파라미터 값을 못받으면 에러 발생
        model.addAttribute("name", name);
        // 그리고 templates 에 hello-template 라는 이름을 가진 파일을 리턴
        return "hello-template";
    }

    // path 를 hello-string 로 설정
    @GetMapping("hello-string")
    @ResponseBody   // http body 에 데이터를 직접 넣어주겠다 선언.
    public String helloString(@RequestParam("name") String name)
    {   // 바로 리턴을 해 주기 때문에 view 가 필요가 없다.
        return "hello" + name;
    }

    // path 를 hello-api 로 설정
    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name){
        // Hello 인스턴스를 생성해 객체를 넘겨주기
        Hello hello = new Hello();
        hello.setName(name);
        // 기본으로 객체를 리턴하면 JSON 방식으로 DATA 를 만들어서 HTTP 응답에 반환한다.
        return hello;
    }

    static class Hello{
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

}
