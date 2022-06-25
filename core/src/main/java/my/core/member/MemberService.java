package my.core.member;

public interface MemberService {

    // 회원 가입
    void join(Member member);
    // 회원 조회(아이디로)
    Member findMember(Long memberId);

}
