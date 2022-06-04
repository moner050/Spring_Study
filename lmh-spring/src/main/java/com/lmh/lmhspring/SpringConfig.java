package com.lmh.lmhspring;

import com.lmh.lmhspring.repository.JdbcMemberRepository;
import com.lmh.lmhspring.repository.JdbcTemplateMemberRepository;
import com.lmh.lmhspring.repository.MemberRepository;
import com.lmh.lmhspring.repository.MemoryMemberRepository;
import com.lmh.lmhspring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

// 수동으로 직접 Bean 등록해주기
@Configuration
public class SpringConfig {

    private DataSource dataSource;

    @Autowired
    public SpringConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository()
    {
        // 메모리 저장 객체 반환
//        return new MemoryMemberRepository();
        // 순수 JDBC 객체 반환
//        return new JdbcMemberRepository(dataSource);
        // 스프링 JdbcTemplate 객체 반환
        return new JdbcTemplateMemberRepository(dataSource);
    }


}
