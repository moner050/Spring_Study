package my.core;

import my.core.member.Grade;
import my.core.member.Member;
import my.core.member.MemberService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {

    public static void main(String[] args) {
        // 맴버 회원가입이 잘 동작하나 테스트
//        AppConfig appConfig = new AppConfig();
//        MemberService memberService = appConfig.memberService();

        // Spring 이 모든 객체들을 관리해 줄 수 있게 applicationContext 생성.
        // 어노테이션 기반으로 Config 를 관리해주고 있으니 AnnotationConfigApplicationContext
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);

        // AppConfig 에서 memberService 객체를 찾고 반환타입을 설정해준다.
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);
        Member member = new Member(1L, "memberA", Grade.VIP);
        // 회원가입.
        memberService.join(member);

        // 회원가입이 되었는지 아이디 검색해보기.
        Member findMember = memberService.findMember(1L);
        System.out.println("new Member = " + member.getName());
        System.out.println("find Member = " + findMember.getName());
    }

}
