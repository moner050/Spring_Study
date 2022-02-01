package com.example.post.controller;

import com.example.post.dto.PostRequestDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class PostApiController {


    // POST 를 받는 가장 기초적인 방법
    //@PostMapping("/post")
//    public void post(@RequestBody Map<String, Object> requestData)
//    {
//        requestData.forEach((key, value) -> {
//            System.out.println("key : " + key);
//            System.out.println("key : " + value);
//        });
//    }

    // 객체를 이용하여 POST를 받는 방법
    @PostMapping("/post")
    public void post(@RequestBody PostRequestDto requestData)
    {
        System.out.println(requestData);
    }

}
