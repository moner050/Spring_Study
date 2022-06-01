package com.lmh.lmhspring.repository;

import com.lmh.lmhspring.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.*;

public class MemoryMemberRepositoryTest {

    MemberRepository repository = new MemoryMemberRepository();

    @Test
    public void save()
    {
        // member 인스턴스 생성
        Member member = new Member();
        // name 넣어주기
        member.setName("spring");
        // member 인스턴스 repository 에 저장
        repository.save(member);
        // result 에 repository 안에 해당 아이디가 저장된 인스턴스 저장.
        Member result = repository.findById(member.getId()).get();
        // result 와 member 가 같은지 테스트
//        Assertions.assertEquals(result, member);
        assertThat(member).isEqualTo(result);
    }

    @Test
    public void findByName()
    {
        // member1 과 member2 인스턴스 생성
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        // result 에 repository 안에 해당 이름이 저장된 인스턴스 저장.
        Member result = repository.findByName("spring1").get();

        assertThat(result).isEqualTo(member1);

    }
}
