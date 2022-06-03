package com.lmh.lmhspring;

import com.lmh.lmhspring.repository.MemberRepository;
import com.lmh.lmhspring.repository.MemoryMemberRepository;
import com.lmh.lmhspring.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// 수동으로 직접 Bean 등록해주기
@Configuration
public class SpringConfig {

    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository()
    {
        return new MemoryMemberRepository();
    }

}
