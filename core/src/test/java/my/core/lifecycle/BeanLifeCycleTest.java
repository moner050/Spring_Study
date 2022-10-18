package my.core.lifecycle;

import org.junit.jupiter.api.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class BeanLifeCycleTest {

    @Test
    public void lifeCycleTest() {
        ConfigurableApplicationContext ac = new AnnotationConfigApplicationContext(LifeCycleConfig.class);
        NetworkClient client = ac.getBean(NetworkClient.class);
        ac.close();
    }

    // 스프링 빈의 이벤트 라이프사이클
    // 스프링 컨테이너 생성 -> 스프링 빈 생성 -> 의존관계 주입 -> 초기화 콜백 -> 사용 -> 소멸전 콜백 -> 스프링 종료
    @Configuration
    static class LifeCycleConfig {

        // 스프링 빈에 의존관계 주입 전, 빈 소멸전에 호출되는 메서드명을 지정해줄 수 있다.
        // destroyMethod 의 default 값은 (inferred) 이다.
        // 이 (inferred) 는 close 나 shutdown 이라는 이름의 메서드를 자동으로 호출해준다.
        // 그래서 따로 설정을 해주지않아도 자동으로 해당 이름의 메서드를 자동으로 호출해준다.
        @Bean(initMethod = "init")
        public NetworkClient networkClient() {
            NetworkClient networkClient = new NetworkClient();
            networkClient.setUrl("https://hello-spring.io");
            return networkClient;
        }
    }
}
