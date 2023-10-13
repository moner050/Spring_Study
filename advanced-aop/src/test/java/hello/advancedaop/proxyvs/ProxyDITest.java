package hello.advancedaop.proxyvs;

import hello.advancedaop.member.MemberService;
import hello.advancedaop.member.MemberServiceImpl;
import hello.advancedaop.proxyvs.code.ProxyDIAspect;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

/**
 * JDK 동적 프록시에 구체 클래스 타입을 주입하면 문제가 발생한다.
 * JDK 프록시는 인터페이스를 기반으로 만들어 진다.
 * JDK 프록시는 MemberServiceImpl 의 타입이 뭔지 전혀 모르기 때문에 해당 타입에 주입할 수 없다.
 *
 * CGLIB 프록시는 구체클래스 기반으로 만들어 진다.
 * 따라서 해당 MemberServiceImpl 타입으로 의존관계 주입을 할 수 있다.
 */
@Slf4j
@Import(ProxyDIAspect.class)
//@SpringBootTest(properties = {"spring.aop.proxy-target-class=false"})   // false = JDK 동적 프록시
@SpringBootTest(properties = {"spring.aop.proxy-target-class=true"})   // false = JDK 동적 프록시
public class ProxyDITest {

    @Autowired
    MemberService memberService;

    @Autowired
    MemberServiceImpl memberServiceImpl;

    @Test
    void go() {
        log.info("memberService class={}", memberService.getClass());
        log.info("memberServiceImpl class={}", memberServiceImpl.getClass());
        memberServiceImpl.hello("hello");
    }
}
