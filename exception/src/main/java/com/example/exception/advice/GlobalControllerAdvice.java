package com.example.exception.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

// 전체적인 Exception 을 잡을것
@RestControllerAdvice(basePackages = "com.example.exception")
public class GlobalControllerAdvice {

    // 모든 예외를 다 잡아서
    @ExceptionHandler(value = Exception.class)
    public ResponseEntity exception(Exception e)    // 예외값을 매개변수로 받아 출력.
    {   // 어디에서 잘못된 예외인지 출력
        System.out.println(e.getClass().getName());
        System.out.println("-----------------------");
        System.out.println(e.getLocalizedMessage());
        System.out.println("-----------------------");
        // 서버에서 발생한 에러를 리턴(문구 지정 가능)
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("");
    }

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseEntity methodArgumentNotValidException(MethodArgumentNotValidException e)
    {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }

}
