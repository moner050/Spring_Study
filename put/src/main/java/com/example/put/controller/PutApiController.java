package com.example.put.controller;


import com.example.put.dto.PostRequestDto;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class PutApiController {

    // POST와 동일하게 데이터를 받기 때문에 @RequestBody 사용
    // RestController 의 경우에 Response 를 보내는 방법은 Object 자체를 return 시키면
    // spring boot 자체에서 object mapper 를 통해 json 으로 바꿔준다.
    @PutMapping("/put/{userId}")
    public PostRequestDto put(@RequestBody PostRequestDto requestDto, @PathVariable Long userId)
    {
        System.out.println(userId);
        // 내가 받은 데이터를 그대로 리턴해준다.
        return requestDto;
    }


}
