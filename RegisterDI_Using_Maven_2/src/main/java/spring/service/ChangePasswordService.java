package spring.service;

import exception.MemberNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.dao.MemberDao;
import spring.model.entity.Member;

// @Service 는 Bean 객체를 생성해주지만 주로 로직처리(서비스레이어, 내부 자바 로직)를 할때 쓰여진다.

@Service
public class ChangePasswordService {
    @Autowired
    private MemberDao memberDao;

    public ChangePasswordService() { }

    public void changePassword(String email, String oldPwd, String newPwd)
    {
        Member member = memberDao.selectByEmail(email);

        if(member == null)
        {
            throw new MemberNotFoundException();
        }
        member.changePassword(oldPwd, newPwd);
        memberDao.update(member);
    }

    public void setMemberDao(MemberDao memberDao){ this.memberDao = memberDao;}
}
