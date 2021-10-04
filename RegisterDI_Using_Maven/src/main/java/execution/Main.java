package execution;

import assembler.Assembler;
import spring.MemberRegisterService;
import spring.RegisterRequest;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
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

        while (true)
        {
            System.out.println("명령어를 입력하세요 : ");
            try
            {
                String command = reader.readLine();

                if (command.equalsIgnoreCase("exit"))
                {
                    System.out.println("종료합니다.");
                    break;
                }

                if (command.equalsIgnoreCase("new"))
                {

                }


                if (command.equalsIgnoreCase("change"))
                {

                }
            }
            catch (Exception e)
            {
                System.out.println(e.getMessage());
            }
        }
    }


    private static Assembler assembler = new Assembler();

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

    }


    private static void printHelp()
    {
        System.out.println();
        System.out.println("잘못된 명령어입니다. 아래 명령어 사용법을 확인하세요.");
        System.out.println("new 이메일 이름 암호 암호확인");
        System.out.println("change 이메일 현재비번 변경비번");
        System.out.println();
    }
}