package com.company.designPattern.strategy;

public class MainStrategy {
    public static void main(String[] args) {

        // encoder 인스턴스 생성
        Encoder encoder = new Encoder();

        // base64
        EncodingStrategy base64 = new Base64Strategy();

        // normal
        EncodingStrategy normal = new NormalStrategy();

        // append
        EncodingStrategy append = new AppendStrategy();

        // encoder 에 인코딩 방식 지정해주고 결과 출력해보기.
        String message = "hello java";

        // base64 방식
        encoder.setEncodingStrategy(base64);
        String base64Result = encoder.getMessage(message);

        // normal (아무것도 없는) 방식
        encoder.setEncodingStrategy(normal);
        String normalResult = encoder.getMessage(message);

        // append (사용자가 지정해준 대로 앞, 또는 뒤에 붙어있는) 방식
        encoder.setEncodingStrategy(append);
        String appendResult = encoder.getMessage(message);

        System.out.println("base64Result : " + base64Result);
        System.out.println("normalResult : " + normalResult);
        System.out.println("appendResult : " + appendResult);
    }
}
