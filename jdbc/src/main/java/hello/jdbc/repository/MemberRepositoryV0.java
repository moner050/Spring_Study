package hello.jdbc.repository;

import hello.jdbc.connection.DBConnectionUtil;
import hello.jdbc.domain.Member;
import lombok.extern.slf4j.Slf4j;

import java.sql.*;

/**
 * JDBC - DriverManager 사용 *
 */
@Slf4j
public class MemberRepositoryV0 {

    public Member save(Member member) throws SQLException {
        String sql = "insert into member(member_id, money) values (?, ?)";

        Connection con = null;
        // 파라미터를 바인딩 할 수 있는 객체
        PreparedStatement pstmt = null;

        try {
            con = getConnection();
            pstmt = con.prepareStatement(sql);
            // sql 파라미터 바인딩
            pstmt.setString(1, member.getMemberId());
            pstmt.setInt(2, member.getMoney());
            pstmt.executeUpdate();
            return member;
        }
        catch (SQLException e) {
            log.error("db error", e);
            throw e;
        }
        finally {
            // 닫지 않으면 연결이 안끊어지고 계속 유지가 될 수 있다.
            //pstmt.close();
            //con.close();
            close(con, pstmt, null);
        }
    }

    private void close(Connection con, Statement stmt, ResultSet rs) {
        if(rs != null) {
            try {
                rs.close();
            }
            catch (SQLException e) {
                log.error("error",e);
            }
        }

        if(stmt != null) {
            try {
                stmt.close();
            }
            catch (SQLException e) {
                log.error("error",e);
            }
        }

        if(con != null) {
            try {
                con.close();
            }
            catch (SQLException e) {
                log.error("error", e);
            }
        }
    }

    private Connection getConnection() {
        return DBConnectionUtil.getConnection();
    }
}
