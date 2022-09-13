package my.core.autowired;

import my.core.member.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.lang.Nullable;

import java.util.Optional;

public class AutowiredTest {

    @Test
    void AutowiredOption() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(TestBean.class);

    }

    static class TestBean {

        // 자동 주입할 대상이 없으면 수정자 메서드 자체가 호출이 안된다.
        @Autowired(required = false)
        public void setNoBean1(Member noBean1){
            System.out.println("noBean1 = " + noBean1);
        }

        // 자동 주입할 대상이 없으면 null 이 입력된다.
        @Autowired
        public void setNoBean2(@Nullable Member noBean2){
            System.out.println("noBean2 = " + noBean2);
        }

        // 자동 주입할 대상이 없으면 Optional.empty 가 입력된다
        @Autowired
        public void setNoBean3(Optional<Member> nobBean3){
            System.out.println("nobBean3 = " + nobBean3);
        }

    }
}
