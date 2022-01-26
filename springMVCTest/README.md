# SpringBoot와 Springfox(swagger)를 이용해서 유저 정보가 Response 되는지 테스트  
- ## SpringBoot2.6.X 버전에서는 Springfox3.0.0(Swagger, AOP)가 적용이 안되서 SpringBoot 버전을 2.5.3버전으로 썼다
  - ## 하지만 2.6.X 버전에 강제로 Springfox3.0.0 를 적용하는 법이 있다.
    - spring.mvc.pathmatch.matching-strategy 옵션을 ant-path-matcher 로 변경한다. (application.properties에서 변경하면 된다.)
    - WebMvcRequestsHandlerProvider 클래스 파일을 찾아서 통째로 복사해서 내 소스 안에 붙여넣는다. 
    - 해당 클래스의 생성자에서 handlerMappings의 내용을 다음과 같이 변경한다.  
  
    ~~~
      this.handlerMappings = handlerMappings.stream().filter(mapping->mapping.getPatternParser()==null).collect(toList());
    ~~~
    
> 출처 : https://dboostudio.github.io/%EC%82%BD%EC%A7%88%EB%A9%88%EC%B6%B0!/2021/12/16/SpringBoot_swagger_hack.html