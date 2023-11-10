package hello.jdbc.service;

import hello.jdbc.domain.Member;
import hello.jdbc.repository.MemberRepositoryV2;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * 트랜잭션 - 파라미터 연동, 풀을 고려한 종료
 */
@Slf4j
@RequiredArgsConstructor
public class MemberServiceV2 {

    private final DataSource dataSource;
    private final MemberRepositoryV2 memberRepository;

    // 계좌이체 로직
    public void accountTransfer(String fromId, String toId, int money) throws SQLException {
        Connection con = dataSource.getConnection();
        try {
            // 트랜잭션 시작
            con.setAutoCommit(false);

            // 비즈니스 로직
            bizLogic(con, fromId, toId, money);
            con.commit();
        }
        catch (Exception e) {
            // 실패시 롤백
            con.rollback();
            throw new IllegalStateException(e);
        }
        finally {
            release(con);
        }
    }

    // 비즈니스 로직
    private void bizLogic(Connection con, String fromId, String toId, int money) throws SQLException {
        Member fromMember = memberRepository.findById(con, fromId);
        Member toMember = memberRepository.findById(con, toId);

        memberRepository.update(con, fromId, fromMember.getMoney() - money);
        validation(toMember); // 예외상황 터트리기
        memberRepository.update(con, toId, toMember.getMoney() + money);
    }

    // 커넥션을 모두 사용하고 나서 정리하기
    private void release(Connection con) {
        if(con != null) {
            try {
                // 그냥 닫으면 오토커밋 모드가 false 여서 문제가 발생할 수 있다.
                con.setAutoCommit(true);
                con.close();
            }
            catch(Exception e) {
                log.info("error", e);
            }
        }
    }

    private void validation(Member toMember) {
        if (toMember.getMemberId().equals("ex")) {
            throw new IllegalStateException("이체중 예외 발생");
        }
    }
}
