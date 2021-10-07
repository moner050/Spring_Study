package config;


import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

// 커스텀 어노테이션을 만들기 위해 생성함.

// @Retention() 은 애노테이션의 라이프사이클을 정하는 것.
// SOURCE : 소스코드(.java)까지 살아남는다.
// CLASS  : 클래스 파일(.class)까지 살아남는다(바이트 코드)
// RUNTIME: 런타임까지 남아있는다.(사실상 안사라짐)
@Retention(RUNTIME)
// 어노테이션이 부착될수 있는 타입 지정.
// 종류는 TYPE / CONSTRUCTOR / METHOD / FIELD 가 있다.
// TYPE 은 클래스, 인터페이스, 열거타입에 어노테이션을 붙일 수 있다는 의미.
// 나머지는 이름 그대로.
@Target(TYPE)
public @interface ManualBean {
}
