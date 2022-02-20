package com.example.async.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

// 직접 쓰레드를 만들어보기
@Configuration
public class AppConfig {

    @Bean("async-thread")
    public Executor asyncThread()
    {
        ThreadPoolTaskExecutor threadPoolTaskExecutor = new ThreadPoolTaskExecutor();
        // 코어풀 사이즈가 10개가 있는데 10개를 다 쓰면 Queue 로 넘어가게 되고
        // Queue 가 다 차면 또 코어풀 사이즈만큼 10개가 늘어난다.
        // CorePool -> Queue -> MaxPool
        threadPoolTaskExecutor.setMaxPoolSize(100);
        threadPoolTaskExecutor.setCorePoolSize(10);
        threadPoolTaskExecutor.setQueueCapacity(10);
        threadPoolTaskExecutor.setThreadNamePrefix("Async-");
        return threadPoolTaskExecutor;
    }
}
