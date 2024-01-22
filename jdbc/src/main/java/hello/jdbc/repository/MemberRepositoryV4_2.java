package hello.jdbc.repository;

import hello.jdbc.domain.Member;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.jdbc.support.JdbcUtils;
import org.springframework.jdbc.support.SQLErrorCodeSQLExceptionTranslator;
import org.springframework.jdbc.support.SQLExceptionTranslator;

import javax.sql.DataSource;
import java.sql.*;
import java.util.NoSuchElementException;

/**
 * SQLExceptionTranslator
 */
@Slf4j
public class MemberRepositoryV4_2 implements MemberRepository{

    private final DataSource dataSource;
    private final SQLExceptionTranslator exTranslator;


    public MemberRepositoryV4_2(DataSource dataSource) {
        this.dataSource = dataSource;
        // 에러코드 기반으로 스프링이 잡은 예외 계층으로 예외를 반환시켜줌.
        this.exTranslator = new SQLErrorCodeSQLExceptionTranslator(dataSource);
    }

    @Override
    public Member save(Member member) {
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
            throw exTranslator.translate("save", sql, e);
        }
        finally {
            // 닫지 않으면 연결이 안끊어지고 계속 유지가 될 수 있다.
            //pstmt.close();
            //con.close();
            close(con, pstmt, null);
        }
    }

    @Override
    public Member findById(String memberId) {
        String sql = "select * from member where member_id = ?";

        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            con = getConnection();
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, memberId);

            rs = pstmt.executeQuery();

            // 한번은 호출을 해 줘야 데이터가 있는지 확인 할 수 있다.
            if(rs.next()) {
                Member member = new Member();
                member.setMemberId(rs.getString("member_id"));
                member.setMoney(rs.getInt("money"));
                return member;
            }
            else {
                throw new NoSuchElementException("member not found memberId = " + memberId);
            }
        }
        catch (SQLException e) {
            throw exTranslator.translate("findById", sql, e);
        }
        finally {
            close(con, pstmt, rs);
        }

    }


    public void update(String memberId, int money) {
        String sql = "update member set money = ? where member_id = ?";

        Connection con = null;
        PreparedStatement pstmt = null;

        try {
            con = getConnection();
            pstmt = con.prepareStatement(sql);
            // sql 파라미터 바인딩
            pstmt.setInt(1, money);
            pstmt.setString(2, memberId);

            // 쿼리를 수행하고 영향받은 행의 수를 반환한다.
            int resultSize = pstmt.executeUpdate();
            log.info("resultSize={}", resultSize);
        } catch (SQLException e) {
            throw exTranslator.translate("update", sql, e);
        } finally {
            JdbcUtils.closeStatement(pstmt);
        }
    }

    public void delete(String memberId) {
        String sql = "delete from member where member_id = ?";

        Connection con = null;
        PreparedStatement pstmt = null;

        try {
            con = getConnection();
            pstmt = con.prepareStatement(sql);
            // sql 파라미터 바인딩
            pstmt.setString(1, memberId);
            pstmt.executeUpdate();
        }
        catch (SQLException e) {
            throw exTranslator.translate("delete", sql, e);
        }
        finally {
            close(con, pstmt, null);
        }
    }

    private void close(Connection con, Statement stmt, ResultSet rs) {
        JdbcUtils.closeResultSet(rs);
        JdbcUtils.closeStatement(stmt);
        // JdbcUtils.closeConnection(con);
        // 주의! 트랜잭션 동기화를 사용하려면 DataSourceUtils 를 사용해야 한다.
        // 트랜잭션을 사용하기 위해 동기화된 커넥션은 커넥션을 닫지 않고 그대로 유지시켜준다.
        // 트랜잭션 동기화 매니저가 관리하는 커넥션이 없는 경우 해당 커넥션을 닫는다.
        DataSourceUtils.releaseConnection(con, dataSource);
    }

    private Connection getConnection() throws SQLException {
        // 주의! 트랜잭션 동기화를 사용하려면 DataSourceUtils 를 사용해야 한다.
        Connection con = DataSourceUtils.getConnection(dataSource);
        log.info("get connection={}, class={}", con, con.getClass());
        return con;
    }
}
