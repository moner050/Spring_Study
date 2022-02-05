package com.example.ioc;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

// 만약 두개 이상의 컴퍼넌트를 쓰고 싶다면 직접 Bean 으로 등록하면 된다.
public class Encoder {

    private IEncoder iEncoder;

    // 만약 Encoder 가 @Component 로 설정되면 두개의 Component 중에서 어떤것을 매칭시켜줘야 할지 오류가 뜨기 때문에
    // @Qualifier("클래스이름") 을 이용해 매칭시켜줘야 한다. (클래스 이름 첫글자는 소문자로 해줘야한다)
    public Encoder(IEncoder iEncoder)
    {
        this.iEncoder = iEncoder;
    }

    // Bean 을 주입받을수 있는 메소드 생성
    public void setIEncoder(IEncoder iEncoder)
    {
        this.iEncoder = iEncoder;
    }

    public String encode(String message)
    {
        return iEncoder.encode(message);
    }


}
