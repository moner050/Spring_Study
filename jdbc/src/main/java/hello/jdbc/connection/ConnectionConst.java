package hello.jdbc.connection;

// 상수를 모아둔 클래스이기 때문에 객체 생성 방지를 위해 추상화 클래스로 생성
public abstract class ConnectionConst {
    public static final String URL = "jdbc:h2:tcp://localhost/~/jdbc";
    public static final String USERNAME = "sa";
    public static final String PASSWORD = "";
}
