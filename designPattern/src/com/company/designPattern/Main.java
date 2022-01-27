package com.company.designPattern;

import com.company.designPattern.singleton.AClazz;
import com.company.designPattern.singleton.BClazz;
import com.company.designPattern.singleton.SocketClient;

import java.net.Socket;

public class Main {

    public static void main(String[] args) {

        // 두개의 클라이언트가 서로 동일한지 확인
        AClazz aClazz = new AClazz();
        BClazz bClazz = new BClazz();

        SocketClient aClient = aClazz.getSocketClient();
        SocketClient bClient = bClazz.getSocketClient();

        System.out.println("두개의 객체가 동일한가??");
        System.out.println(aClient.equals(bClient));


    }
}
