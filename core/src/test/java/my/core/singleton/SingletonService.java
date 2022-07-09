package my.core.singleton;

public class SingletonService {

    // static 영역에 객체 instance 를 미리 하나 생성해서 올려둔다
    private static final SingletonService instance = new SingletonService();

    // 외부에서 new 키워드로 생성을 못하게 private 으로 막아둔다
    private SingletonService(){
    }

    // 이 객체의 인스턴스가 필요하면 getInstance() 메서드를 통해서만 조회 가능하다.
    public static SingletonService getInstance(){
        return instance;
    }

    public void logic(){
        System.out.println("싱글톤 객체 로직 호출");
    }
}
