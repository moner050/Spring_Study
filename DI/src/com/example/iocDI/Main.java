package com.example.iocDI;

public class Main {

    public static void main(String[] args) {

        String url = "www.naver.com/books/it?page=10&size=20&name=spring-boot";

        // Base 64 encoding
//        IEncoder base64Encoder = new Base64Encoder();
//        String base64Result = base64Encoder.encode(url);

        // url encoding
//        IEncoder urlEncoder = new UrlEncoder();
//        String urlResult = urlEncoder.encode(url);

        // DI를 적용한 Encoder
        // 외부 객체를 주입받는 형태가 DI 이다.
        Encoder encoder = new Encoder(new Base64Encoder());

        String result = encoder.encode(url);
        System.out.println(result);
    }
}
