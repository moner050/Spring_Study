package com.example.ioc;

import org.springframework.stereotype.Component;

import java.util.Base64;

// Spring Container 에서 관리를 해준다.
// 따로 컴퍼넌트의 이름을 지어줄 수 있다. 예) @Component("이름")
@Component
public class Base64Encoder implements IEncoder {

    public String encode(String message)
    {
        return Base64.getEncoder().encodeToString(message.getBytes());
    }
}
