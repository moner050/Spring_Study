import config.AppCtx;
import exception.DuplicationMemberDaoException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring.model.dto.request.RegisterRequest;
import spring.service.MemberRegisterService;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class MainSpringDI {
    private static ApplicationContext ctx = null;

    public static void main(String[] args) {
        ctx = new AnnotationConfigApplicationContext(AppCtx.class);

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while(true)
        {
            System.out.print("명령어를 입력해주세요. : ");
            try
            {
                String command = reader.readLine();

                // 입력한 문자열이 "exit"이면 프로그램 종료.
                if (command.equalsIgnoreCase("exit"))
                {
                    System.out.println("종료합니다.");
                    break;
                }

                // 입력한 문자열이 "new"로 시작하면 회원가입.
                // 사용 예) new test@naver.com 이름 비밀번호 비밀번호
                if (command.startsWith("new"))
                {
                    processNewCommand(command.split(" "));
                }

            }
            catch(Exception e)
            {
                System.out.println(e.getMessage());
            }
        }
    }

    // 회원 정보 가입 메소드
    private static void processNewCommand(String[] arg)
    {
        if (arg.length != 5)
        {
            printHelp();
            return;
        }

        MemberRegisterService regSvc = ctx.getBean(MemberRegisterService.class);

        RegisterRequest req = new RegisterRequest();
        req.setEmail(arg[1]);
        req.setName(arg[2]);
        req.setPassword(arg[3]);
        req.setConfirmPassword(arg[4]);

        // 입력한 암호 값이 올바른지 확인.
        if(!req.isPasswordEqualToConfirmPassword())
        {
            System.out.println("암호와 확인암호가 일치하지 않습니다.");
            return;
        }

        // 이미 동일한 이메일을 가진 회원 데이터가 존재하면 에러 메세지 출력.
        try
        {
            regSvc.register(req);
            System.out.println("등록했습니다.");
        }
        catch (DuplicationMemberDaoException e)
        {
            System.out.println("이미 존재하는 이메일입니다.");
        }


    }

    // 커맨드 사용법 메소드
    private static void printHelp()
    {
        System.out.println();
        System.out.println("잘못된 명령입니다. 아래 명령어 사용법을 확인하세요.");
        System.out.println("명령어 사용법:");
        System.out.println("new 이메일 이름 암호 암호확인");
        System.out.println("change 이메일 현재비번 변경비번");
        System.out.println();
    }
}
