package com.example.aop.aop;


import com.example.aop.dto.User;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;
import java.util.Base64;

@Aspect
@Component
public class DecodeAop {

    @Pointcut("execution(* com.example.aop.controller..*.*(..))")
    private void pointCut()
    {
    }

    @Pointcut("@annotation(com.example.aop.annotation.Decode)")
    private void enableDecode()
    {
    }

    @Before("pointCut() && enableDecode()")
    public void before(JoinPoint joinPoint) throws UnsupportedEncodingException {
        Object[] args= joinPoint.getArgs();

        for(Object arg : args)
        {   // User라는 클래스와 매칭이 되면
            if(arg instanceof User)
            {   // User 라는 클래스로 형 변환을 시켜준다.
                User user = User.class.cast(arg);
                String base64Email = user.getEmail();
                // base64 로 인코딩 되있는걸 디코딩 시켜서 set 을 해준다.
                String email = new String(Base64.getDecoder().decode(base64Email), "UTF-8");
                user.setEmail(email);
            }
        }
    }

    @AfterReturning(value = "pointCut() && enableDecode()", returning = "returnObj")
    public void afterReturn(JoinPoint joinPoint, Object returnObj)
    {
        if(returnObj instanceof User)
        {   // User 라는 클래스로 형 변환을 시켜준다.
            User user = User.class.cast(returnObj);
            String email = user.getEmail();
            // email 을 다시 base64 로 인코딩을 해줘서 넣어준다.
            String base64Email = Base64.getEncoder().encodeToString(email.getBytes());
            user.setEmail(base64Email);
        }
    }

}
