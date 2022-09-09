package my.core;

import my.core.member.MemberRepository;
import my.core.member.MemoryMemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

// 설정 정보
@Configuration
// @Component 어노테이션이 붙은 클래스를 자동으로 Spring Bean 으로 등록해준다.
// 하지만 AppConfig 클래스를 등록하지 않기 위해 @Configuration 을 필터링 처리를 해준다.
@ComponentScan(
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
)
public class AutoAppConfig {

    // 빈 이름이 중복되면 수동빈이 자동빈을 오버라이딩 해버린다. (application.properties 에 설정 할때만)
//    @Bean(name = "memoryMemberRepository")
//    MemberRepository memberRepository(){
//        return new MemoryMemberRepository();
//    }

}
