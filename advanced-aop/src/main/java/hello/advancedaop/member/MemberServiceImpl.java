package hello.advancedaop.member;

import hello.advancedaop.member.annotation.ClassAop;
import hello.advancedaop.member.annotation.MethodAop;
import org.springframework.stereotype.Component;

@ClassAop       // 커스텀 Aop 추가
@Component      // Spring Bean 으로 자동으로 등록되게
public class MemberServiceImpl implements MemberService{

    @Override
    @MethodAop("test value")
    public String hello(String param) {
        return "OK";
    }

    public String internal(String param) {
        return "OK";
    }
}
