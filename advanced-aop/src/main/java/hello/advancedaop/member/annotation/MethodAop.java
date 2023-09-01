package hello.advancedaop.member.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)         // 메서드에만 붙힐수있는 애노테이션
@Retention(RetentionPolicy.RUNTIME) // 애플리케이션이 실행될때까지 실행될것이다.
public @interface MethodAop {
    String value();
}
