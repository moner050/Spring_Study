package config;


import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import spring.helper.MemberPrinter;
import spring.helper.MemberSummaryPrinter;

// @Configuration 은 클래스가 하나 이상의 @Bean 메소드를 제공하고 스프링 컨테이너가 Bean 정의를 생성하고 런타임시
// 그 Bean 들이 요청을 처리할 것을 선언하게 된다.
@Configuration
// @ComponentScan 은 @Component 어노테이션 및 stereotype(@Service, @Repository, @Controller)어노테이션이 부여된
// Class 들을 자동으로 Scan 하여 Bean 으로 등록해 주는 역활을 한다.
// basePackages 의 경우 직접 패키지경로를 적어주어 스캔할 위치를 적어줄 수 있다.
// basePackageClasses 의 경우 괄호안에 적힌 Class 가 위치한 곳에서부터 모든 어노테이션이 부여된 Class 를 Bean 으로 등록해준다.
// Class 를 통해 기입하기 때문에 훨씬 Typesafe 한 방법이다.
@ComponentScan(basePackages = {"spring.dao", "spring.model","spring.service"})
public class AppCtx {

    // Bean 이란 Spring IoC 컨테이너가 관리하는 자바 객체이다.
    // new 연산자로 어떤 객체를 생성했을때 그 객체는 Bean 이 아니지만
    // ApplicationContext.getBean() 으로 얻을수 있는 객체는 Bean이다.
    // @Bean 은 Bean 설정파일에 직접 Bean 을 등록하는 방법이다.
    @Bean
    @Qualifier("printer")
    public MemberPrinter memberPrinter1()
    {
        return new MemberPrinter();
    }

    // @Qualifier 이란 동일 타입의 Bean 객체가 여러개 있을 때 Exception 이 발생하는 문제를 해결하기 위해 사용된다.
    // Spring Container 가 여러개의 Bean 을 찾았을 때, 추가적으로 판단할 수 있는 정보를 주는 원리이다.
    // @Qualifier("찾는이름")

    @Bean
    @Qualifier("summaryPrinter")
    public MemberSummaryPrinter memberPrinter2()
    {
        return new MemberSummaryPrinter();
    }
}
