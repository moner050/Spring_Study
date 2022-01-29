# 싱글톤 패턴(Singleton pattern)

- Singleton 패턴은 어떠한 클래스(객체)가 유일하게 1개만 존재 할 때 사용한다.
- 서로 자원을 공유 할 때 사용한다.
- 이를 주로 사용하는곳  
    - 실물세계 : 프린터
    - 실제 프로그래밍 : TCP Socket 통신에서 서버와 연결된 connect 객체에 주로 사용된다.  

- Spring에서 Bean은 기본적으로 Singleton으로 관리가 된다.
- 기본적으로 default생성자를 private로 막아버리고 getInstance를 통해서 생성되있는 객체를 가져오거나, 새로 생성한다.