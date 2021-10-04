package spring;

import exception.MemberNotFoundException;

public class ChangePasswordService {

    private MemberDao memberDao;

    public ChangePasswordService() {}

    public ChangePasswordService(MemberDao memberDao)
    {
        this.memberDao=memberDao;
    }

    public void changePassword(String email, String oldPwd, String newPwd)
    {
        Member member = memberDao.selectByEmail(email);
        if(email == null)
        {
            throw new MemberNotFoundException();
        }

        member.changePassword(oldPwd, newPwd);
        memberDao.update(member);
    }

    public void setMemberDao(MemberDao memberDao)
    {
        this.memberDao=memberDao;
    }

}
