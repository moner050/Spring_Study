package com.company.designPattern.adapter;

public class MainAdapter {

    // 콘센트
    public static void connect(Electronic110V electronic110V)
    {
        electronic110V.powerOn();
    }


    public static void main(String[] args) {

        // 헤어드라이기 연결
        HairDryer hairDryer = new HairDryer();
        connect(hairDryer);

        // 청소기 연결
        // 하지만 청소기는 220V 여서 어댑터로 변환시켜줘야 한다.
        Cleaner cleaner = new Cleaner();
        Electronic110V adapter = new SocketAdapter(cleaner);
        connect(adapter);

        // 에어컨 연결
        // 하지만 에어컨은 220V 여서 어댑터로 변환시켜줘야 한다.
        AirConditional airConditional = new AirConditional();
        Electronic110V airAdapter = new SocketAdapter(airConditional);
        connect(airAdapter);
    }
}
