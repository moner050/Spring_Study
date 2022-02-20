package com.example.async.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.concurrent.CompletableFuture;

@Slf4j
@Service
public class AsyncService {

    // Bean 에 등록된 Thread 의 이름
    // public 메소드에만 Async 를 넣어줄 수 있다.
    @Async("async-thread")
    public CompletableFuture run()
    {   // 같은 클래스 내에서 같은 메소드를 호출할 때는 @Async 가 동작하지 않는다.
        return new AsyncResult(hello()).completable();
    }

    public String hello()
    {
        for(int i = 0; i< 10; i++)
        {
            try
            {
                Thread.sleep(2000);
                log.info("thread sleep......");
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }
        return "async hello";
    }

}
