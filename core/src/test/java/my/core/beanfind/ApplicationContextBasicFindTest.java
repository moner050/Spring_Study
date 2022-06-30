package my.core.beanfind;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import my.core.AppConfig;
import my.core.member.MemberService;
import my.core.member.MemberServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApplicationContextBasicFindTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("빈 이름으로 조회")
    void findBeanByName(){
        MemberService memberService = ac.getBean("memberService", MemberService.class);

        // memberService 가 memberServiceImpl 의 인스턴스이면 통과
        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
    }

    @Test
    @DisplayName("빈 이름없이 타입으로만 조회")
    void findBeanByType(){
        MemberService memberService = ac.getBean(MemberService.class);

        // memberService 가 memberServiceImpl 의 인스턴스이면 통과
        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
    }

    // 구체타입으로 조회하면 유연성이 떨어진다.
    @Test
    @DisplayName("구체 타입으로 조회")
    void findBeanByName2(){
        MemberService memberService = ac.getBean("memberService", MemberServiceImpl.class);

        // memberService 가 memberServiceImpl 의 인스턴스이면 통과
        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
    }

    @Test
    @DisplayName("빈 이름으로 조회X")
    void findBeanByNameX(){
//        MemberService xxxxx = ac.getBean("xxxxx", MemberService.class);
        // 오른쪽의 로직을 실행하면 왼쪽의 예외가 터져야한다.
        assertThrows(NoSuchBeanDefinitionException.class,
            () -> ac.getBean("xxxxx", MemberService.class));
    }
}
