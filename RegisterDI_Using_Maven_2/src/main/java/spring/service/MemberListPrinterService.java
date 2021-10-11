package spring.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import spring.dao.MemberDao;
import spring.helper.MemberPrinter;
import spring.model.entity.Member;

import java.util.Collection;

// @Component 는 Bean 을 설정하는 어노테이션이지만 Bean 과는 차이점이 있다.
// @Bean 은 개발자가 class 코드를 수정할 수 없고 같은 클래스 타임의 Bean 을 여러개 등록할 때 사용되고
// @Component 는 개발자가 Class 코드를 수정할 수 있지만 Bean 의 이름을 같은 패키지 안에서 여러개 지정할 수가 없다.
@Component("listPrinter")
public class MemberListPrinterService {
    private MemberDao memberDao;
    private MemberPrinter printer;


    @Autowired
    public void setMemberDao(MemberDao memberDao){ this.memberDao=memberDao; }

    @Autowired
    @Qualifier("printer")
    public void setMemberPrinter(MemberPrinter printer){ this.printer=printer; }

    public MemberListPrinterService() {}

    public void printAll()
    {
        Collection<Member> members = memberDao.selectAll();
        members.forEach(m -> printer.print(m));
        System.out.println();
    }
}
