package hello.advancedaop.internalcall;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class CallServiceV2 {

    // ObjectProvider, ApplicationContext 를 사용해 지연(LAZY) 조회

    /*
    // ApplicationContext 를 통해 Bean 을 찾아 주입받는것은 가능은 하지만 너무 헤비하다.
    private final ApplicationContext applicationContext;

    public CallServiceV2(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }
    */

    // ObjectProvider 는 객체를 스프링 컨테이너에서 조회하는 것을 스프링 빈 생성 시점이 아니라
    // 실제 객체를 사용하는 시점으로 지연할 수 있다.
    // callServiceProvider.getObject(); 를 호출하는 시점에 스프링 컨테이너에서 빈을 조회한다.
    private final ObjectProvider<CallServiceV2> callServiceProvider;

    public CallServiceV2(ObjectProvider<CallServiceV2> callServiceProvider) {
        this.callServiceProvider = callServiceProvider;
    }

    // 외부호출
    public void external() {
        log.info("call external");
//        CallServiceV2 callServiceV2 = applicationContext.getBean(CallServiceV2.class);
        CallServiceV2 callServiceV2 = callServiceProvider.getObject();
        callServiceV2.internal(); // 외부 메서드 호출

    }

    // 내부호출
    public void internal() {
        log.info("call internal");
    }
}
