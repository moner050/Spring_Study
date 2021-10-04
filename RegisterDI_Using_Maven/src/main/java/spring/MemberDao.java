package spring;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

// DAO = Data Access Object -> Repository
public class MemberDao {
    private static long nextId = 0;

    // Map으로 인터페이스 선언 후 HashMap으로 객체 생성.
    // HashMap은 본인 메소드 외에 부모인 Map의 메소드를 강제로 상속받음.
    private Map<String, Member> mapBaseEmail = new HashMap<String, Member>();

    // 회원조회(단건)
    public Member selectByEmail(String email)
    {
        return mapBaseEmail.get(email);
    }

    // 회원 등록 목적
    public void insert(Member member)
    {
        member.setId(++nextId);
        mapBaseEmail.put(member.getEmail(), member);
    }

    // 회원 수정(단건)
    public void update(Member member)
    {
        mapBaseEmail.put(member.getEmail(), member);
    }

    public Collection<Member> selectAll()
    {
        return mapBaseEmail.values();
    }
}
