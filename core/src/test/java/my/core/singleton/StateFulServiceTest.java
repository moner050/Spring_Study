package my.core.singleton;

import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

class StateFulServiceTest {

    @Test
    @DisplayName("무상태로 설계하기")
    void stateFulServiceSingleton(){

        ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
        StateFulService stateFulService1 = ac.getBean(StateFulService.class);
        StateFulService stateFulService2 = ac.getBean(StateFulService.class);

        // ThreadA: A사용자가 10000원 주문
        int userAPrice = stateFulService1.order("UserA", 10000);
        // ThreadB: B사용자가 20000원 주문
        int userBPrice =stateFulService2.order("UserB", 20000);

        // ThreadA: 사용자A 주문 금액 조회
//        int price = stateFulService1.getPrice();
        System.out.println("price = " + userAPrice);

        Assertions.assertThat(userAPrice).isEqualTo(10000);
    }

    static class TestConfig{
        @Bean
        public StateFulService stateFulService(){
            return new StateFulService();
        }
    }
}