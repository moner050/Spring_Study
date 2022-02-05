package com.example.ioc;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
// 1. ApplicationContextProvider 를 만들때
public class ApplicationContextProvider implements ApplicationContextAware {

    // 3. static 변수에 applicationContext 를 할당시켜준다.
    private static ApplicationContext context;

    // Web 으로부터 Spring 이 알아서 주입을 해준다
    // 2. set Method 에 applicationContext 를 주입해 주고
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        context = applicationContext;
    }

    public static ApplicationContext getContext()
    {
        return context;
    }
}
