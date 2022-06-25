package my.core.member;

public class MemberServiceImpl implements MemberService{

    // 인터페이스만 가지고 있으면 NullPointException 이 발생하기 때문에
    // 구현 객체를 선택해 줘야 한다.
    private final MemberRepository memberRepository = new MemoryMemberRepository();

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
