package config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import spring.*;

@Configuration
public class AppConf2 {

//    @Autowired
    private MemberDao memberDao;

//    @Autowired
    private MemberPrinter memberPrinter;

    @Bean
    public MemberRegisterService memberRegisterService()
    {   // memberDao() 가 생성한 객체를 생성자를 통해 주입한다.
        return new MemberRegisterService(memberDao);
    }

    @Bean
    public ChangePasswordService changePasswordService()
    {
        ChangePasswordService passwordService = new ChangePasswordService();
        passwordService.setMemberDao(memberDao);
        return passwordService;
    }

    @Bean
    public MemberListPrinter listPrinter()
    {
        return new MemberListPrinter(memberDao, memberPrinter);
    }

    @Bean
    public VersionPrinter versionPrinter()
    {
        VersionPrinter versionPrinter = new VersionPrinter();
        versionPrinter.setMajorVersion(1);
        versionPrinter.setMiddleVersion(0);
        versionPrinter.setMinorVersion(0);

        return versionPrinter;
    }
}
