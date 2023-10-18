package hello.jdbc.connection;

import lombok.extern.slf4j.Slf4j;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static hello.jdbc.connection.ConnectionConst.*;

@Slf4j
public class DBConnectionUtil {

    public static Connection getConnection() {
        try {
            // DriverManager 는 라이브러리에 등록된 드라이버 목록을 자동으로 인식하고
            // 이 드라이버들에게 순서대로 다음 정보를 넘겨서 커넥션을 획득할 수 있는지 확인한다.
            // 여기서 드라이버들은 URL 정보를 체크해 본인이 처리할 수 있는 요청인지 확인한다.
            // 처리할 수 있으면 실제 DB에 연결해서 커넥션을 획득하고 이 커넥션을 클라이언트에 반환한다.
            // 처리할 수 없으면 처리할 수 없다는 결과값을 반환하고 다음 드라이버에 순서가 넘어간다.
            Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            log.info("get connection={}, class={}",connection, connection.getClass());

            return connection;
        }
        catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }
}
