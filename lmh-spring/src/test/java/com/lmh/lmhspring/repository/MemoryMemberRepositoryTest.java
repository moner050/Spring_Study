package com.lmh.lmhspring.repository;

import com.lmh.lmhspring.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;

public class MemoryMemberRepositoryTest {

    MemoryMemberRepository repository = new MemoryMemberRepository();

    // 테스트가 끝날 때 마다 repository 를 깔끔하게 지워주기.
    // 메소드가 실행이 끝날 때 마다 어떠한 동작을 하게 만드는 AfterEach 활용.
    @AfterEach
    public void afterEach(){
        repository.clearStore();
    }

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

    @Test
    public void findAll()
    {
        // member1 과 member2 인스턴스 생성
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        // result 에 repository 안에 모든 값들을 넣어준다.
        List<Member> result = repository.findAll();
        // 안에 넣은 값의 수가 2인지 확인.
        assertThat(result.size()).isEqualTo(2);
    }

}
