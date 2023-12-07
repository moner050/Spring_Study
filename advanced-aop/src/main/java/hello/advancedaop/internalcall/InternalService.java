package hello.advancedaop.internalcall;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class InternalService {

    // 내부호출
    public void internal() {
        log.info("call internal");
    }

}
