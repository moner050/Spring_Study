package hello.advancedaop.proxyvs;

import hello.advancedaop.member.MemberService;
import hello.advancedaop.member.MemberServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.aop.framework.ProxyFactory;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
public class ProxyCastingTest {

    @Test
    void jdkProxy() {
        MemberServiceImpl target = new MemberServiceImpl();
        ProxyFactory proxyFactory = new ProxyFactory(target);
        proxyFactory.setProxyTargetClass(false); // JDK 동적 프록시

        // 프록시를 인터페이스로 캐스팅 성공
        Object memberServiceProxy = (MemberService) proxyFactory.getProxy();

        log.info("jdk proxy={}", memberServiceProxy.getClass());

        // JDK 동적 프록시는 구현 클래스로 캐스팅이 불가능하다. ClassCastException
        assertThrows(ClassCastException.class, () -> {
            MemberServiceImpl castingMemberService = (MemberServiceImpl) memberServiceProxy;
        });
    }

    @Test
    void cglibProxy() {
        MemberServiceImpl target = new MemberServiceImpl();
        ProxyFactory proxyFactory = new ProxyFactory(target);
        proxyFactory.setProxyTargetClass(true); // CGLIB 프록시

        // 프록시를 인터페이스로 캐스팅 성공
        Object memberServiceProxy = (MemberService) proxyFactory.getProxy();

        log.info("proxy class={}", memberServiceProxy.getClass());

        // CGLIB 프록시는 구현 클래스로 캐스팅이 가능하다
        MemberServiceImpl castingMemberService = (MemberServiceImpl) memberServiceProxy;

    }
}
