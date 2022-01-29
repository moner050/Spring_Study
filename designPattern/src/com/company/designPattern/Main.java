package com.company.designPattern;

import com.company.designPattern.adapter.*;
import com.company.designPattern.aop.AopBrowser;
import com.company.designPattern.decorator.*;
import com.company.designPattern.facade.Ftp;
import com.company.designPattern.facade.Reader;
import com.company.designPattern.facade.SftpClient;
import com.company.designPattern.facade.Writer;
import com.company.designPattern.obsever.Button;
import com.company.designPattern.obsever.IButtonListener;
import com.company.designPattern.proxy.Browser;
import com.company.designPattern.proxy.BrowserProxy;
import com.company.designPattern.proxy.IBrowser;
import com.company.designPattern.singleton.AClazz;
import com.company.designPattern.singleton.BClazz;
import com.company.designPattern.singleton.SocketClient;
import com.company.designPattern.strategy.*;

import java.net.Socket;
import java.util.concurrent.atomic.AtomicLong;

public class Main {

    public static void main(String[] args) {

        /*
        // Singleton
        // 두개의 클라이언트가 서로 동일한지 확인
        AClazz aClazz = new AClazz();
        BClazz bClazz = new BClazz();

        SocketClient aClient = aClazz.getSocketClient();
        SocketClient bClient = bClazz.getSocketClient();

        System.out.println("두개의 객체가 동일한가??");
        System.out.println(aClient.equals(bClient));
        */

        /*
        // Adapter
        // 헤어드라이기는 110V
        HairDryer hairDryer = new HairDryer();
        connect(hairDryer);

        Cleaner cleaner = new Cleaner();
        // 청소기는 220V 를 사용해야해서 문제가 발생한다
        // connect(cleaner);
        Electronic110V adapter = new SocketAdapter(cleaner);
        connect(adapter);

        // 에어컨은 220V
        AirConditional airConditional = new AirConditional();
        // 220V를 110V 로 꽂을수 있는 어댑터를 이용해 연결한다.
        Electronic110V airAdapter = new SocketAdapter(airConditional);
        connect(airAdapter);
        */

        /*
        // proxy
        // 계속 해당 주소로부터 가져온다.
//        Browser browser = new Browser("www.naver.com");
//        browser.show();
//        browser.show();
//        browser.show();
//        browser.show();
        // Proxy 패턴을 이용하면 한번 가져온다음 캐시를 이용해 가져올수 있다.
//        IBrowser browser = new BrowserProxy("www.naver.com");
//        browser.show();
//        browser.show();
//        browser.show();
//        browser.show();
//        browser.show();
        // AOP를 이용하면 모든 흩어져있는 기능들을 Proxy 패턴으로 제공 받을 수 있다.
        AtomicLong start = new AtomicLong();
        AtomicLong end = new AtomicLong();
        IBrowser aopBrowser = new AopBrowser("www.naver.com",
                () ->
                {   // 시작시간 구하기.
                    System.out.println("before");
                    start.set(System.currentTimeMillis());
                },
                () ->
                {   // 끝나는 시간 구하기
                    long now = System.currentTimeMillis();
                    end.set(now - start.get());
                });
        aopBrowser.show();
        System.out.println("loading time : " + end.get());
        // 두번째부터는 캐시를 사용하고 있기 때문에 0초가 걸린다.
        aopBrowser.show();
        System.out.println("loading time : " + end.get());
        */

        /*
        // decorator
        ICar audi = new Audi(1000);
        audi.showPrice();

        // 등급이 올라갈때 마다 1000원씩 올라간다.
        // a3
        ICar audi3 = new A3(audi, "A3");
        audi3.showPrice();

        // a4
        ICar audi4=  new A4(audi, "A4");
        audi4.showPrice();

        // a5
        ICar audi5=  new A5(audi, "A5");
        audi5.showPrice();
        */

        /*
        // observer
        Button button = new Button("버튼");


        button.addListener(new IButtonListener() {
            @Override
            public void clickEvent(String event) {
                System.out.println(event);
            }
        });

        button.click("메시지 전달 : click 1");
        button.click("메시지 전달 : click 2");
        button.click("메시지 전달 : click 3");
        button.click("메시지 전달 : click 4");
         */

        /*
        // facade
        // facade pattern 미적용
        Ftp ftpClient = new Ftp("www.naver.com", 22, "/home/etc");

        Writer writer = new Writer("text.tmp");
        writer.fileConnect();
        writer.write();

        Reader reader = new Reader("text.tmp");
        reader.fileConnect();
        reader.fileRead();

        reader.fileDisconnect();
        writer.fileDisConnect();
        ftpClient.disConnect();

        // facade pattern 적용
        SftpClient sftpClient = new SftpClient("www.naver.com", 22, "/home/etc", "text.temp");
        sftpClient.connect();

        sftpClient.write();
        sftpClient.read();

        sftpClient.disConnect();
        */

        Encoder encoder = new Encoder();

        // base64
        EncodingStrategy base64 = new Base64Strategy();

        // normal
        EncodingStrategy normal = new NormalStrategy();

        String message = "hello java";

        // base64로 set 인코딩
        encoder.setEncodingStrategy(base64);
        String base64Result = encoder.getMessage(message);
        System.out.println(base64Result);

        // normal 로 set 인코딩
        encoder.setEncodingStrategy(normal);
        String normalResult = encoder.getMessage(message);
        System.out.println(normalResult);

        // append 로 set 인코딩
        encoder.setEncodingStrategy(new AppendStrategy());
        String appendResult = encoder.getMessage(message);
        System.out.println(appendResult);
    }

    // 콘센트
    public static void connect(Electronic110V electronic110V)
    {
        electronic110V.powerOn();
    }


}
