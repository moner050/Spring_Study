package spring;

import java.util.Collection;

public class MemberListPrinter {
    private MemberDao memberDao;
    private MemberPrinter memberPrinter;

    public MemberListPrinter(MemberDao memberDao, MemberPrinter printer)
    {
        this.memberDao = memberDao;
        this.memberPrinter = printer;
    }

    public void printAll()
    {
        Collection<Member> members = memberDao.selectAll();
        members.forEach(m -> memberPrinter.print(m));
        System.out.println();
    }
}
