package my.core;

import my.core.member.Grade;
import my.core.member.Member;
import my.core.member.MemberService;

public class MemberApp {

    public static void main(String[] args) {
        // 맴버 회원가입이 잘 동작하나 테스트
        AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService();

        Member member = new Member(1L, "memberA", Grade.VIP);
        // 회원가입.
        memberService.join(member);

        // 회원가입이 되었는지 아이디 검색해보기.
        Member findMember = memberService.findMember(1L);
        System.out.println("new Member = " + member.getName());
        System.out.println("find Member = " + findMember.getName());
    }

}
