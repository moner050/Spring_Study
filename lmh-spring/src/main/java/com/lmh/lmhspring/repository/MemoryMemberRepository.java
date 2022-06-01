package com.lmh.lmhspring.repository;

import com.lmh.lmhspring.domain.Member;

import java.util.*;

public class MemoryMemberRepository implements MemberRepository{

    // 값을 저장하기 위해 Map 사용
    private static Map<Long, Member> store = new HashMap<>();
    // key 값을 생성해주기 위한 sequence (서버에 저장할 id 고유번호)
    private static long sequence = 0L;

    @Override
    public Member save(Member member) {
        // member 에 id 값을 세팅해준다.
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        // null 값이 나올때를 대비하기 위하여 Optional 로 감싸줌
        return Optional.of(store.get(id));
    }

    @Override
    public Optional<Member> findByName(String name) {
        // member 를 다 돌면서 파라미터로 받은 이름과 같은게 하나라도 있는 것을 리턴
        return store.values().stream()
                .filter(member -> member.getName().equals(name))
                .findAny();
    }

    @Override
    public List<Member> findAll() {
        // store 에 저장된 모든 값들을 ArrayList 로 담아서 리턴해줌.
        return new ArrayList<>(store.values());
    }
}
