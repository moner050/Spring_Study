package com.my.JPAProject;

import com.my.JPAProject.domain.Member;
import com.my.JPAProject.persistance.MemberRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.util.Optional;

@SpringBootTest
//@Transactional
public class CascadeTest {

    @Autowired
    private MemberRepository memberRepository;
    @Test
    void dataDelete() {

        memberRepository.deleteById(3);


    }


}
