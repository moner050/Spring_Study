package com.company.designPattern.singleton;

public class AClazz {

    private SocketClient socketClient;

    public AClazz()
    {   // 기본 생성자를 private 로 막아버려서 getInstance 로 할당받아야 한다.
        this.socketClient = SocketClient.getInstance();
    }

//    public AClazz()
//    {
//        this.socketClient = new SocketClient();
//    }


    public SocketClient getSocketClient()
    {
        return this.socketClient;
    }
}
