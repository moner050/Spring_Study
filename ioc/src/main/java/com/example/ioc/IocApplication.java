package com.example.ioc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// Spring Container 에서 관리되는 객체들을 Bean 이라고 한다.
@SpringBootApplication
public class IocApplication {

    public static void main(String[] args) {
        SpringApplication.run(IocApplication.class, args);

        ApplicationContext context = ApplicationContextProvider.getContext();

        // DI는 해주지만 IOC 는 new 로 관리하지 않을것이다.
        // Base64Encoder base64Encoder = context.getBean(Base64Encoder.class);
        // UrlEncoder urlEncoder = context.getBean(UrlEncoder.class);

        String url = "www.naver.com/books/it?page=10&size=20&name=spring-boot";

        // Encoder 에 두가지 타입이 있으니 이름을 지정해줘야 한다.
        Encoder encoder = context.getBean("urlEncode", Encoder.class);
        String result = encoder.encode(url);
        // base64Encoder 결과값 출력
        System.out.println(result);

        // Encoder 를 urlEncoder 로 변경
        // encoder.setIEncoder(urlEncoder);

        // result = encoder.encode(url);
        // urlEncoder 결과값 출력
        // System.out.println(result);
    }
}

// 한개의 클래스에서 여러개의 Bean 을 등록할때 사용한다.
@Configuration
class AppConfig
{
    // 동일한 이름의 Bean 을 구분하기 위해 이름을 붙혀준다.
    // 충돌을 방지하기 위해 base64Encoder 가 아닌 base64Encode 를 붙혀준다.
    @Bean("base64Encode")
    public Encoder encoder(Base64Encoder base64Encoder)
    {
        return new Encoder(base64Encoder);
    }

    @Bean("urlEncode")
    public Encoder encoder(UrlEncoder urlEncoder)
    {
        return new Encoder(urlEncoder);
    }

}