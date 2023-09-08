package hello.advancedaop.pointcut;

import hello.advancedaop.member.MemberServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;

import java.lang.reflect.Method;

import static org.assertj.core.api.Assertions.assertThat;

/***
 * within 은 특정 타입 내의 조인 포인트에 대한 매칭을 제한한다.
 * 해당 타입이 매칭되면 그 안의 메서드(Joinpoint) 들이 자동으로 매칭된다.
 * 그리고 within 은 잘 사용되지 않는다.
 */
public class WithinTest {

    AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
    Method helloMethod;

    @BeforeEach
    public void init() throws NoSuchMethodException {
        helloMethod = MemberServiceImpl.class.getMethod("hello", String.class);
    }

    // 타입에 매칭되는 요소들은 전부 OK
    @Test
    void withinExact() {
        pointcut.setExpression("within(hello.advancedaop.member.MemberServiceImpl)");
        assertThat(pointcut.matches(helloMethod, MemberServiceImpl.class)).isTrue();
    }

    // star 표현식도 OK
    @Test
    void withinStar() {
        pointcut.setExpression("within(hello.advancedaop.member.*Service*)");
        assertThat(pointcut.matches(helloMethod, MemberServiceImpl.class)).isTrue();
    }

    // sub package 도 OK
    @Test
    void withinSubPackage() {
        pointcut.setExpression("within(hello.advancedaop..*)");
        assertThat(pointcut.matches(helloMethod, MemberServiceImpl.class)).isTrue();
    }

    // sub package 도 OK
    @Test
    @DisplayName("타겟의 타입에만 직접 적용, 인터페이스를 선정하면 안된다.")
    void withinSuperTypeFalse() {
        pointcut.setExpression("within(hello.advancedaop.member.MemberService)");
        assertThat(pointcut.matches(helloMethod, MemberServiceImpl.class)).isFalse();
    }
}
