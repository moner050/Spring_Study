package my.core.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MemberServiceImpl implements MemberService{

    // 인터페이스만 가지고 있으면 NullPointException 이 발생하기 때문에
    // 구현 객체를 선택해 줘야 한다.
    private final MemberRepository memberRepository;

    // @Autowired 를 생성자에 붙혀주면 의존관계 주입을 자동으로 해준다.
    @Autowired // ac.getBean(MemberRepository.class)
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }

    // 테스트 용도
    public MemberRepository getMemberRepository(){
        return memberRepository;
    }
}
