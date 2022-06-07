package com.lmh.lmhspring;

import com.lmh.lmhspring.repository.JdbcMemberRepository;
import com.lmh.lmhspring.repository.JdbcTemplateMemberRepository;
import com.lmh.lmhspring.repository.JpaMemberRepository;
import com.lmh.lmhspring.repository.MemberRepository;
import com.lmh.lmhspring.repository.MemoryMemberRepository;
import com.lmh.lmhspring.service.MemberService;
import javax.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

// 수동으로 직접 Bean 등록해주기
@Configuration
public class SpringConfig {

//    JDBC 객체 반환
//    private DataSource dataSource;
//    @Autowired
//    public SpringConfig(DataSource dataSource) {
//        this.dataSource = dataSource;
//    }

//    JPA 객체 반환
//    private EntityManager em;
//    @Autowired
//    public SpringConfig(EntityManager em) {
//        this.em = em;
//    }

//    @Bean
//    public MemberService memberService(){
//        return new MemberService(memberRepository());
//    }


    // 스프링 data JPA 를 사용할때 사용.
    private final MemberRepository memberRepository;

    @Autowired
    public SpringConfig(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository);
    }

//    @Bean
//    public MemberRepository memberRepository()
//    {
        // 메모리 저장 객체 반환
//        return new MemoryMemberRepository();
        // 순수 JDBC 객체 반환
//        return new JdbcMemberRepository(dataSource);
        // 스프링 JdbcTemplate 객체 반환
//        return new JdbcTemplateMemberRepository(dataSource);
        // JPA 객체 반환
//        return new JpaMemberRepository(em);
//    }


}
