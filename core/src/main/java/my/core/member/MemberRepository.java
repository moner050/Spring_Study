package my.core.member;

public interface MemberRepository {

    // 회원 저장
    void save(Member member);
    // 회원찾기(아이디로)
    Member findById(Long memberId);
}
