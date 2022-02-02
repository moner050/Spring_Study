package com.example.delete.controller;


import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class DeleteApiController {


    // Delete 의 같은 경우에는 삭제 됐거나 데이터가 없는 경우에도 정상적으로 처리된다.
    @DeleteMapping("/delete/{userId}")
    public void delete(@PathVariable String userId, @RequestParam String account)
    {
        System.out.println(userId);
        System.out.println(account);
    }


}
