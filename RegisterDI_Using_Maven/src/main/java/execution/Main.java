package execution;

import assembler.Assembler;
import config.AppConf1;
import config.AppConfImport;
import exception.DuplicateMemberDaoException;
import exception.MemberNotFoundException;
import exception.WrongIdPasswordException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    private static AnnotationConfigApplicationContext ctx = null;

    public static void main(String[] args) {
        // DI(Dependency Injection) 의존적 주입
        // DI는 의존하는 객체를 직접 생성하는 대신 의존 객체를 전달 받는 방식으로 사용
        // Dependency -> 객체 간의 보존
        // 회원가입 예시

        // 콘솔에서 명령어를 입력받고 각 명령어에 알맞은 기능을 수행하는 코드
        // 처리할 명령어 : 1. new -> 새로운 회원 데이터 추가.   2. change 회원데이터와 암호를 변경
        //               3. exit -> 프로그램 종료

        // 콘솔로 입력을 받기 위해 System.in 을 이용해서 BufferedReader 생성
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        ctx = new AnnotationConfigApplicationContext(AppConfImport.class);

        while (true)
        {
            firstHelp();
            System.out.print("명령어를 입력하세요 : ");
            try
            {
                String command = reader.readLine();

                // 입력된 문자열이 "exit"이면 프로그램 종료.
                if (command.equalsIgnoreCase("exit"))
                {
                    System.out.println("종료합니다.");
                    break;
                }
                // 입력된 문자열이 "new" 로 시작하면 회원가입
                // 사용 예) new test1234@naver.com 이름 1234 1234
                if (command.startsWith("new"))
                {
                    processNewCommand(command.split(" "));
                    continue;
                }

                // 입력된 문자열이 "change"로 시작하면 회원정보 수정
                // 사용 예) change test1234@naver.com 현재비밀번호 바꿀비밀번호
                if (command.startsWith("change"))
                {
                    processChangeCommand(command.split(" "));
                    continue;
                }

                // 입력된 문자열이 "list"이면 그동안 가입한 회원 리스트 출력
                if (command.equals("list"))
                {
                    processListCommand();
                    continue;
                }

                // 가입한 회원 정보 단 건 출력하기
                // 사용 예) info test1234@naver.com
                if (command.startsWith("info"))
                {
                    processInfoCommand(command.split(" "));
                    continue;
                }

                // 프로그램 버전 정보 출력하기
                if (command.equals("version"))
                {
                    processVersionCommand();
                    continue;
                }
            }
            catch (Exception e)
            {
                System.out.println(e.getMessage());
            }
        }
    }

    // Assembler 객체가 생성되어 필요한 객체를 생성하고 의존을 주입.
    private static Assembler assembler = new Assembler();

    // 새로운 회원 등록 메소드.
    private static void processNewCommand(String[] arg)
    {
        // new 이메일 이름 암호 암호확인 <- 이 형식으로 입력이 안되면
        if (arg.length != 5)
        {
            printHelp();
            return;
        }

        // Assembler 객체 사용
        MemberRegisterService regSvc = assembler.getRegSvc();
        RegisterRequest req = new RegisterRequest();
        req.setEmail(arg[1]);
        req.setName(arg[2]);
        req.setPassword(arg[3]);
        req.setConfirmPassword(arg[4]);

        // 입력한 암호 값이 올바른지 확인
        if(!req.isPasswordEqualToConfirmPassword())
        {
            System.out.println("암호와 일치하지 않습니다.");
            return;
        }
        try
        {
            regSvc.register(req);
            System.out.println("등록했습니다\n");
        }
        catch (DuplicateMemberDaoException e)
        {
            System.out.println("이미 존재하는 이메일입니다.\n");
        }
    }

    // 비밀번호 변경 메소드
    private static void processChangeCommand(String[] arg)
    {
        if (arg.length != 4)
        {
            printHelp();
            return;
        }

        ChangePasswordService changePasswordService =
                ctx.getBean("changePasswordService", ChangePasswordService.class);

        try
        {
            changePasswordService.changePassword(arg[1], arg[2], arg[3]);
            System.out.println("비밀번호가 변경되었습니다.");
        }
        catch(WrongIdPasswordException e)
        {
            System.out.println("이메일과 암호가 일치하지 않습니다.");
        }
        catch (MemberNotFoundException e)
        {
            System.out.println("존재하지 않는 이메일입니다.");
        }
    }
    // 멤버 info 출력 메소드
    // 사용 예) info 이메일
    private static void processInfoCommand(String[] arg)
    {   //  명령어를 잘못 입력했을 경우
        if (arg.length != 2)
        {
            printHelp();
            return;
        }
        MemberInfoPrinter infoPrinter = ctx.getBean("infoPrinter",MemberInfoPrinter.class);
        infoPrinter.printMemberInfo(arg[1]);
    }

    // 리스트 출력 메소드
    private static void processListCommand()
    {
        MemberListPrinter listPrinter = ctx.getBean("listPrinter",MemberListPrinter.class);

        listPrinter.printAll();
    }

    // 프로그램 버전 출력 메소드
    private static void processVersionCommand()
    {
        VersionPrinter versionPrinter = ctx.getBean("versionPrinter",VersionPrinter.class);
        versionPrinter.print();
    }

    private static void printHelp()
    {
        System.out.println();
        System.out.println("잘못된 명령어입니다. 아래 명령어 사용법을 확인하세요.");
        System.out.println("========= 명령어 설명 창 ==========");
        System.out.println("new 이메일 이름 암호 암호확인");
        System.out.println("change 이메일 현재비번 변경비번");
        System.out.println("info 이메일");
        System.out.println("list <- 회원 리스트 확인");
        System.out.println("version <- 프로그램 버전 확인");
        System.out.println("=================================");
    }

    private static void firstHelp()
    {
        System.out.println();
        System.out.println("new, change, info, list, version의 명령어가 있습니다.");
    }
}