# Spring

- Spring은 지난 20년 가까지의 세월 동안 단 한번도 자바 엔터프라이즈 어플리케이션 개발의 최고의 자리를 차지중이다.
- Spring Framework의 구성은 20여가지로 구성되있다. (https://spring.io/projects/spring-framework)  
  이러한 모듈들은 스프링의 핵심 기능(DI, AOP, etc)을 제공해 주며, 필요한 모듈만 선택하여 사용 가능하다.
- 현재 단일 아키텍처(모놀리스) 마이크로서비스 아키텍처로 변환중이고  
  여기에 맞춰서 스프링도 진화하고 있는 상태이다.
- 여러 가지 모듈이 있지만 그 중에서 단연  
  Spring Boot, Spring Cloud, Spring Data, Spring Batch, Spring Security 에 중점을 둔다.  
-------------------------

- Spring의 과제는 "테스트의 용이성", "느슨한 결합" 에 중점을 두고 개발한다.
- 2000년대 초의 자바 EE 애플리케이션은 작성/테스트가 매우 어려웠으며, 한번 테스트 하기가 번거로웠다.  
  이로 인하여, 느슨한 결합이 된 애플리케이션 개발이 힘든 상태였으며, 특히 데이터베이스와 같이  
  외부에 의존성을 두는 경우 단위테스트가 불가능했다.
--------------------------
- ## Spring의 가장 큰 특징
    - POJO
    - IoC/DI (의존 관계 주입)
    - AOP (관점 중심 프로그래밍)
    - PSA (이식 가능한 추상화)  
--------------------
- IoC (Inversion Of Control)
    - 스프링이 다른 프레임워크와 가장 큰 자이점이 IoC를 통한 개발 진행이 가능하다는 점이다.
    - 스프링에서는  class 또는 service간의 데이터를 주고 받는 일반적인 Java 객체를 new로 생성하여 개발자가 관리 하는 것이 아닌 Spring Container에 모두 맡긴다.
    - Container라는 공간에 생성하고자 하는 객체가 이미 만들어져서 들어가있고, singleton의 형태로 관리가 된다.
    - 즉, 개발자에서 -> 프레임워크로의 제어의 객체 관리의 권한이 넘어갔음으로 "제어의 역전"이라고도 한다.
- DI (Dependency Injection)
    - DI의 장점
        - 의존성으로 부터 격리시켜 코드 테스트에 용이하다.
        - DI를 통하여, 불가능한 상황을 Mock와 같은 기술을 통하여, 안정적으로 테스트가 가능하다.
        - 코드를 확장하거나 변경 할 때 영향을 최소화 한다. (추상화)
        - 순환참조를 막을 수 있다.
- AOP(관점 지향 프로그래밍)
    - AOP를 사용하여 로깅, 트랜잭션 관리, 시큐리티에서의 적용 등 AspectJ와 같이 완벽하게 구현된 AOP와 통합하여 사용 가능하다.
    - 스프링 어플리케이션은 대부분 특별한 경우를 제외 하고는 MVC 웹 어플리케이션에서는  
    Web Layer, Business Layer, Data Layer로 정의한다.
      - Web Layer
        - [REST API](https://github.com/moner050/Spring_Study/tree/master/%EC%A0%95%EB%A6%AC/REST%20API)를 제공하며, Client 중심의 로직 적용
      - Business Layer
        - 내부 정책에 따른 logic을 개발하며, 주로 해당 부분을 개발한다.
      - Data Layer
        - 데이터베이스 및 외부와의 연동을 처리한다.
    - 주요 Annotation  

      |Annotation|의미|
      |---|---|
      |@Aspect|자바에서 널리 사용하는 AOP 프레임워크에 포함되며, AOP를 정의하는 Class에 할당|
      |@Pointcut|기능을 어디에 적용시킬지, 메소드? Annotation? 등 AOP를 적용 시킬 지점을 설정|
      |@Before|메소드 실행하기 이전|
      |@After|메소드가 성공적으로 실행 후, 예외가 발생 되더라도 실행|
      |@AfterReturning|메소드 호출 성공 실행 시(Not Throws)|
      |@AfterThrowing|메소드 호출 실패 예외 발생(Throws)|
      |@Around|Before / after 모두 제어|
