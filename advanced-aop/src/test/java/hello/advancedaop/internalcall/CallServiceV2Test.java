package hello.advancedaop.internalcall;

import hello.advancedaop.internalcall.aop.CallLogAspect;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

@Slf4j
@Import(CallLogAspect.class)
@SpringBootTest
class CallServiceV2Test {

    // 자기자신 주입 방식으로 메서드를 호출 시 자기 자신의 인스턴스를 호출하는것이 아닌 프록시 인스턴스를 통해 호출하기.
    @Autowired
    CallServiceV2 callServiceV2;

    @Test
    void external() {
        callServiceV2.external();
    }
}