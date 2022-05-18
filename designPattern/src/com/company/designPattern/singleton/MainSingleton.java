package com.company.designPattern.singleton;

public class MainSingleton {
    public static void main(String[] args) {

        // 두 객체가 서로 동일한지 확인.
        AClazz aClazz = new AClazz();
        BClazz bClazz = new BClazz();

        SocketClient aClient = aClazz.getSocketClient();
        SocketClient bClient = bClazz.getSocketClient();

        // 만약 singleton 의 default 생성자가 private 가 아니면 동일하지 않다.
        System.out.println("두개의 객체가 동일한가?");
        System.out.println(aClient.equals(bClient));
    }
}
