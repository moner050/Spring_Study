package com.company.designPattern.singleton;

public class BClazz {

    private SocketClient socketClient;

    public BClazz()
    {   // 기본 생성자를 private 로 막아버려서 getInstance 로 할당받아야 한다.
        this.socketClient = SocketClient.getInstance();
    }

//    public BClazz()
//    {
//        this.socketClient = new SocketClient();
//    }

    public SocketClient getSocketClient()
    {
        return this.socketClient;
    }


}
