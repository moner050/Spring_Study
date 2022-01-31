# URI, URL

- ## URI(Uniform Resource Identifier)
    - 인터넷에서 특정 자원을 나타내는 주소 값. 해당 값은 유일하다.(응답은 달라질 수 있다)
        ~~~
        요청 : https://www.fastcampus.co.kr/resource/sample/1
        응답 : fastcampus.pdf, fastcampus.docx
        ~~~

    - URL(Uniform Resource Locator)
    - 인터넷 상에서의 자원, 특정 파일이 어디에 위치하는지 식별 하는 주소
        ~~~
        요청 : https://www.fastcampus.co.kr/fastcampus.pdf
        ~~~

    - URL은 URI의 하위 개념이다.
--------------------
- ## URI 설계 원칙(RFC-3986)
    - 슬래시 구분자(/)는 계층 관계를 나타내는 데 사용한다.
    - URI 마지막 문자로 (/)는 포함하지 않는다.
    - 하이픈(-)은 가독성을 높이는데 사용한다
    - 밑줄(_)은 사용하지 않는다.
    - URI경로에는 소문자가 적합하다.
    - 파일 확장자는 URI에 포함하지 않는다.  
    (/web-master.jsp (X) )
    - 프로그래밍 언어에 의존적인 확장자를 사용하지 않는다.  
    (/web-master.do (X) )
    - 구현에 의존적인 경로를 사용하지 않는다.  
    (.../servlet/classes/java/curriculums/web-master (X))  
    (.../classes/java/curriculums/web-master (O))
    - 세션 ID를 포함하지 않는다  
    (..../web-master?session-id=asdf (X) )
    - 프로그래밍 언어의 Method명을 이용하지 않는다  
    (/web-master?action=intro (X) )
    - 명사에 단수형 보다는 복수형을 사용해야 한다. 컬렉션에 대한 표현은 복수로 사용
    - 컨트롤러 이름으로는 동사나 동사구를 사용한다.
    - 경로 부분 중 변하는 부분은 유일한 값으로 대체 한다.  
    (/web-master/lessons/{lesson-id}/users/{user-id})  
    ↓  
    (/web-master/lessons/2/users/100)
    - CRUD 기능을 나타내는 것은 URI에 사용하지 않는다.  
    (......./lessons/2/users/100/READ(X))  
    (......./lessons/2/users/100 (O))
------------------------
- ## URI Query Parameter 디자인
    - URI 쿼리 부분으로 컬렉션 결과에 대해서 필터링 할 수 있다.  
    (/web-master?chapter=2)
    - URI쿼리는 컬렉션의 결과를 페이지로 구분하여 나타내는데 사용한다.  
    (/web-master?chapter-2&page=0&size=10&sort=asc)
    - API에 있어서 서브 도메인은 일관성 있게 사용해야 한다.  
        ~~~
        (https://fastcapmus.co.kr)
        ↓
        (https://api.fastcapmus.co.kr)
        (https://api-fastcapmus.co.kr)
        ~~~
    - 클라이언트 개발자 포탈 서브 도메인은 일관성 있게 만든다.
        ~~~
        (https://dev-fastcapmus.co.kr)
        (https://developer-fastcapmus.co.kr)
        ~~~
