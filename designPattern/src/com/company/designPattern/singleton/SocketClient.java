package com.company.designPattern.singleton;

// 서버와 통신을 할때 한번 연결한 커넥트를 통해서 싱글톤 패턴을 사용하는 예제
public class SocketClient {

    // 싱글톤은 자기 자신을 객체로 가지고있어야 한다.
    private static SocketClient socketClient = null;

    // 싱글톤은 기본 생성자를 private 로 막아야 한다.
    private SocketClient()
    {

    }

    // 기본생성자로 테스트
//    public SocketClient()
//    {
//
//    }


    // 싱글톤은 static 메소드를 이용해 getInstance 를 제공해야 한다.
    public static SocketClient getInstance()
    {   // 자신의 객체가 null 이면
        if(socketClient == null)
        {   // 새로 생성해주고
            socketClient = new SocketClient();
        }
        // null 이 아니면 socketClient 를 리턴
        return socketClient;
    }

    public void connect()
    {
        System.out.println("Connect");
    }

}
