package spring.dao;


import org.springframework.stereotype.Repository;
import spring.model.entity.Member;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;


// @Repository 어노테이션은 해당 클래스를 루트 컨테이너에 Bean 객체로 생성해주는 어노테이션이다.
// 주로 외부I/O 처리 (퍼시스턴스 레이어, DB나 파일같은 외부 I/O 작업을 처리) 에 쓰인다.
@Repository
public class MemberDao {
    private static long nextId = 0;

    private Map<String, Member> mapBaseEmail = new HashMap<String, Member>();

    // 회원조회(단건)
    public Member selectByEmail(String email)
    {
        return mapBaseEmail.get(email);
    }

    // 회원 등록
    public void insert(Member member)
    {   // 회원정보
        member.setId(++nextId);

        mapBaseEmail.put(member.getEmail(), member);
    }

    // 회원 수정(단건)
    public void update(Member member)
    {
        mapBaseEmail.put(member.getEmail(), member);
    }

    // 회원 전체 정보 가져오기.
    public Collection<Member> selectAll()
    {
        return mapBaseEmail.values();
    }
}
