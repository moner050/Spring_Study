package hello.advancedaop.internalcall;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/***
 * 기능을 분리해서 구조 자체를 분리시키기.
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class CallServiceV3 {

    private final InternalService internalService;

    // 외부호출
    public void external() {
        log.info("call external");
        internalService.internal(); // 외부 메서드 호출
    }

}
