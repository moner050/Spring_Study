package com.example.hello.controller;

import com.example.hello.dto.UserRequest;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/get")
public class GetApiController {

    // 명시적 방법
    // http://localhost:9090/api/get/hello
    @GetMapping(path = "/hello")
    public String hello()
    {
        return "get Hello";
    }

    // 예전방식.
    // 그냥 쓰게되면 get / post / put / delete 같은 모든 Method 가 Mapping 이 되기 때문에
    // path 와 method 를 지정해줘야 한다,
    // http://localhost:9090/api/get/hi
    @RequestMapping(path = "hi", method = RequestMethod.GET)
    public String hi()
    {
        return "hi";
    }

    // Path-Variable 변화하는 값 받기
    // http://localhost:9090/api/get/pathVariable/{name}
    // 변화하는 값을 받을려면 어노테이션을 이용해 매개변수를 선언해주면 된다
    // 하지만 GetMapping 에 넣은 변수와 매개변수의 이름이 같아야 한다.
    // 이름을 맞춰주지 못할 때에는 아래와 같이 해줘야 한다.
    @GetMapping("/path-variable/{id}")
    public String pathVariable(@PathVariable(name = "id") String pathName)
    {
        System.out.println("PathVariable : " + pathName);
        return pathName;
    }


    // Query Parameter
    // 쿼리 파라미터를 받는 첫번째 방법
    // 얼마나 들어올지 모를때 사용하면 좋다.
    // ?key=value&key2=value2
    // http://localhost:9090/api/get/query-param?user=steve&email=steve@gmail.com&age=30
    @GetMapping(path = "query-param")
    public String queryParam(@RequestParam Map<String, String> queryParam)
    {
        StringBuilder sb = new StringBuilder();

        queryParam.entrySet().forEach( entry ->
        {
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
            System.out.println("\n");
            sb.append(entry.getKey() + " = " + entry.getValue() + "\n");
        });

        return sb.toString();
    }

    // 쿼리 파라미터를 받는 두번째 방법
    // 받는 값이 별로 없을때 사용하면 좋음
    @GetMapping("query-param02")
    public String queryParam2(
            @RequestParam String name,
            @RequestParam String email,
            @RequestParam int age
    )
    {
        System.out.println(name);
        System.out.println(email);
        System.out.println(age);
        return name + " " + email + " " + age;
    }

    // 쿼리 파라미터를 받는 세번째 방법
    // 객체를 만들어서 바로 매핑이 되게 하는 방법이다.
    // 현업에서 가장 많이 사용한다.
    @GetMapping("query-param03")
    public String queryParam3(UserRequest userRequest)
    {
        System.out.println(userRequest.getName());
        System.out.println(userRequest.getEmail());
        System.out.println(userRequest.getAge());

        return userRequest.toString();
    }
}
