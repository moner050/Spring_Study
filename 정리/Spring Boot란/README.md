# Spring Boot란

- ### Spring Boot는 단순히 실행되며, 프로덕션 제품 수준의 스프링 기반 어플리케이션을 쉽게 만들 수 있다.
- ### Spring Boot 어플리케이션에는 Spring 구성이 거의 필요하지 않다.
- ### Spring Boot java -jar 로 실행하는 Java 어플리케이션을 만들 수 있다.
--------------------------------------------

- ## Spring Boot 의 특징
    - Spring 개발에 대해 빠르고, 광범위하게 적용할 수 있는 환경을 제공한다.
    - 어플리케이션 개발에 필수 요소들만 모아두었다.
    - 간단한 설정으로 개발 및 커스텀이 가능하다
    - 기본값 설정이 있지만 설정을 바꿀 수 있다.
    - 간단하고, 빠르게 어플리케이션 실행 및 배포가 가능하다.
    - 대규모프로젝트(운영환경)에 필요한 비 기능적 기능도 제공한다. (보안, 모니터링 등등)
    - 오랜 경험에서 나오는 안정적인 운영이 가능하다
    - 어노테이션 기반으로 바뀌어서 Spring에서 불편한 설정이 없어졌다. (XML 설정 등등)

----------------------------------

- ## 여러가지 Spring Boot Annotation  

    |Annotation|의미|
    |---|---|
    |@SpringBootApplication|Spring boot application 으로 설정|
    |@Controller|View를 제공하는 controller로 설정|
    |@RestController|REST API를 제공하는 controller로 설정|
    |@RequestMapping|URL 주소를 맵핑|
    |@GetMapping|Http GetMethod URL 주소 맵핑|
    |@PostMapping|Http PostMethod URL 주소 맵핑|
    |@PutMapping|Http PutMethod URL 주소 맵핑|
    |@DeleteMapping|Http DeleteMethod URL 주소 맵핑|
    |@RequestParam|URL Query Parameter 맵핑|
    |@RequestBody|Http Body를 Parsing 맵핑|
    |@Valid|POJO Java class의 검증|
    |@Configration|1개 이상의 bean을 등록 할 때 설정|
    |@Component|1개의 Class 단위로 등록 할 때 사용|
    |@Bean|1개의 외부 library로부터 생성한 객체를 등록 시 사용|
    |@Autowired|DI를 위한 곳에 사용|
    |@Qualifier|@Autowired 사용시 bean이 2개 이상 일 때 명시적 사용|
    |@Resource|@Autowired + @Qualifier 의 개념으로 이해|
    |@Aspect|AOP 적용시 사용|
    |@Before|AOP 메소드 이전 호출 지정|
    |@After|AOP 메소드 호출 이후 지정 예외 발생 포함|
    |@Around|AOP 이전/이후 모두 포함 예외 발생 포함|
    |@AfterReturning|AOP 메소드의 호출이 정상일 때 실행|
    |@AfterThrowing|AOP시 해당 메소드가 예외 발생시 지정|
    
