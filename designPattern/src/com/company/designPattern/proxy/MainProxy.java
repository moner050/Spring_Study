package com.company.designPattern.proxy;

import com.company.designPattern.aop.AopBrowser;

import java.util.concurrent.atomic.AtomicLong;

public class MainProxy {
    public static void main(String[] args) {

        // 캐시기능 없이 사용하기
        /*
        Browser browser = new Browser("www.naver.com");
        browser.show();
        browser.show();
        browser.show();
         */

        // 캐시기능 있이 사용하기
        /*
        IBrowser iBrowser = new BrowserProxy("www.naver.com");
        iBrowser.show();
        iBrowser.show();
        iBrowser.show();
         */

        // aop 기능 이용해보기
        AtomicLong start = new AtomicLong();
        AtomicLong end = new AtomicLong();

        IBrowser aopBrowser = new AopBrowser("www.naver.com",
                () ->{
                    System.out.println("before");
                    start.set(System.currentTimeMillis());
                },
                () ->{
                    long now = System.currentTimeMillis();
                    end.set(now - start.get());
                });

        // 첫번째는 로딩을 해야해서 1.5초가 걸리지만
        aopBrowser.show();
        System.out.println("로딩시간 : " + end.get());
        // 두번째 호출하면 캐시를 이용하기 때문에 0초가 걸린다.
        aopBrowser.show();
        System.out.println("로딩시간 : " + end.get());

    }
}
