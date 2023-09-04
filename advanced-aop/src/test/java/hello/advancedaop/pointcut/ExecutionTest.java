package hello.advancedaop.pointcut;

import hello.advancedaop.member.MemberServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;

import java.lang.reflect.Method;

import static org.assertj.core.api.Assertions.*;

@Slf4j
public class ExecutionTest {

    AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
    Method helloMethod;

    @BeforeEach
    public void init() throws NoSuchMethodException {
        helloMethod = MemberServiceImpl.class.getMethod("hello", String.class);
    }

    @Test
    void printMethod() {
        // public java.lang.String hello.advancedaop.member.MemberServiceImpl.hello(java.lang.String)
        log.info("helloMethod={}", helloMethod);
    }

    @Test
    void exactMatch() {
        // execution(접근제어자? 반환타입 선언타입?메서드이름(파라미터) 예외?)
        /***
         * 접근제어자?   : public
         * 반환타입     : String
         * 선언타입?    : hello.advancedaop.member.MemberServiceImpl
         * 메서드이름    : hello
         * 파라미터     : (String)
         * 예외?      : 생략
         ***/
        pointcut.setExpression("execution(public String hello.advancedaop.member.MemberServiceImpl.hello(String))");
        assertThat(pointcut.matches(helloMethod, MemberServiceImpl.class)).isTrue();
    }

    @Test
    void allMatch() {
        /***
         * 접근제어자?   : 생략
         * 반환타입     : *
         * 선언타입?    : 생략
         * 메서드이름    : *
         * 파라미터     : (..)
         * 예외?      : 없음
         ***/
        pointcut.setExpression("execution(* *(..))");
        assertThat(pointcut.matches(helloMethod, MemberServiceImpl.class)).isTrue();
    }

    @Test
    void nameMatch() {
        /***
         * 접근제어자?   : 생략
         * 반환타입     : *
         * 선언타입?    : 생략
         * 메서드이름    : hello
         * 파라미터     : (..)
         * 예외?      : 없음
         ***/
        pointcut.setExpression("execution(* hello(..))");
        assertThat(pointcut.matches(helloMethod, MemberServiceImpl.class)).isTrue();
    }

    @Test
    void nameMatchStar1() {
        // 패턴매칭
        /***
         * 접근제어자?   : 생략
         * 반환타입     : *
         * 선언타입?    : 생략
         * 메서드이름    : hel*
         * 파라미터     : (..)
         * 예외?      : 없음
         ***/
        pointcut.setExpression("execution(* hel*(..))");
        assertThat(pointcut.matches(helloMethod, MemberServiceImpl.class)).isTrue();
    }

    @Test
    void nameMatchStar2() {
        // 패턴매칭
        /***
         * 접근제어자?   : 생략
         * 반환타입     : *
         * 선언타입?    : 생략
         * 메서드이름    : *el*
         * 파라미터     : (..)
         * 예외?      : 없음
         ***/
        pointcut.setExpression("execution(* *el*(..))");
        assertThat(pointcut.matches(helloMethod, MemberServiceImpl.class)).isTrue();
    }

    @Test
    void nameMatchFalse() {
        /***
         * 접근제어자?   : 생략
         * 반환타입     : *
         * 선언타입?    : 생략
         * 메서드이름    : nono
         * 파라미터     : (..)
         * 예외?      : 없음
         ***/
        pointcut.setExpression("execution(* nono(..))");
        assertThat(pointcut.matches(helloMethod, MemberServiceImpl.class)).isFalse();
    }

    @Test
    void packageExactMatch1() {
        // 패턴매칭
        /***
         * 접근제어자?   : 생략
         * 반환타입     : *
         * 선언타입?    : hello.advancedaop.member.MemberServiceImpl
         * 메서드이름    : hello
         * 파라미터     : (..)
         * 예외?      : 없음
         ***/
        pointcut.setExpression("execution(* hello.advancedaop.member.MemberServiceImpl.hello(..))");
        assertThat(pointcut.matches(helloMethod, MemberServiceImpl.class)).isTrue();
    }

    @Test
    void packageExactMatch2() {
        // 패턴매칭
        /***
         * 접근제어자?   : 생략
         * 반환타입     : *
         * 선언타입?    : hello.advancedaop.member.*
         * 메서드이름    : *
         * 파라미터     : (..)
         * 예외?      : 없음
         ***/
        pointcut.setExpression("execution(* hello.advancedaop.member.*.*(..))");
        assertThat(pointcut.matches(helloMethod, MemberServiceImpl.class)).isTrue();
    }

    @Test
    void packageExactFalse() {
        // 패턴매칭
        /***
         * 접근제어자?   : 생략
         * 반환타입     : *
         * 선언타입?    : hello.advancedaop.*
         * 메서드이름    : *
         * 파라미터     : (..)
         * 예외?      : 없음
         ***/
        pointcut.setExpression("execution(* hello.advancedaop.*.*(..))");
        assertThat(pointcut.matches(helloMethod, MemberServiceImpl.class)).isTrue();
    }

    @Test
    void packageMatchSubPackage1() {
        // 패턴매칭
        /***
         * 접근제어자?   : 생략
         * 반환타입     : *
         * 선언타입?    : hello.advancedaop.member..
         * 메서드이름    : *
         * 파라미터     : (..)
         * 예외?      : 없음
         ***/
        // member 패키지와 그 하위에 있는 패키지들을 선언타입으로 설정
        pointcut.setExpression("execution(* hello.advancedaop.member..*(..))");
        assertThat(pointcut.matches(helloMethod, MemberServiceImpl.class)).isTrue();
    }

    @Test
    void packageMatchSubPackage2() {
        // 패턴매칭
        /***
         * 접근제어자?   : 생략
         * 반환타입     : *
         * 선언타입?    : hello.advancedaop..*
         * 메서드이름    : *
         * 파라미터     : (..)
         * 예외?      : 없음
         ***/
        // member 패키지와 그 하위에 있는 패키지들을 선언타입으로 설정
        pointcut.setExpression("execution(* hello.advancedaop..*.*(..))");
        assertThat(pointcut.matches(helloMethod, MemberServiceImpl.class)).isTrue();
    }
}
