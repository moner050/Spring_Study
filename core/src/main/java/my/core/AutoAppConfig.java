package my.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

// 설정 정보
@Configuration
// @Component 어노테이션이 붙은 클래스를 자동으로 Spring Bean 으로 등록해준다.
// 하지만 AppConfig 클래스를 등록하지 않기 위해 @Configuration 을 필터링 처리를 해준다.
@ComponentScan( excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class))
public class AutoAppConfig {


}
