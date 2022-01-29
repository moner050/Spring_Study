package com.company.designPattern.adapter;

public class SocketAdapter implements Electronic110V{

    // 연결 시켜줘야 할 220V 를 가지고 있어야 함.
    private Electronic220V electronic220V;

    // 기본 생성자에서 220V인 제품을 받을예정
    public SocketAdapter(Electronic220V electronic220V)
    {
        this.electronic220V = electronic220V;
    }

    @Override
    public void powerOn() {
        electronic220V.connect();
    }
}
