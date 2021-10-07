package spring.helper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import spring.model.entity.Member;

import java.time.format.DateTimeFormatter;

public class MemberPrinter {
    private DateTimeFormatter dateTimeFormatter;

    public MemberPrinter()
    {
        dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy년 MM월 dd일");
    }

    public void print(Member member)
    {
        if(dateTimeFormatter == null)
        {
            System.out.printf(
                    "회원정보 : 아이디=%d, 이메일=%s, 이름=%s, 등록일=%tF\n",
                    member.getId(), member.getEmail(), member.getName(), member.getRegisterDateTime()
            );
        }
        else
        {
            System.out.printf(
                    "회원정보 : 아이디=%d, 이메일=%s, 이름=%s, 등록일=%s\n",
                    member.getId(), member.getEmail(), member.getName(),
                    dateTimeFormatter.format(member.getRegisterDateTime())
            );
        }
    }
    // @Autowired 는 필요한 의존 객체의 타입에 해당하는 Bean 을 찾아 주입한다.
    // 생성자, setter, 필드 <- 이 3가지의 경우 @Autowired 를 사용할 수 있다,.
    @Autowired
    public void setDateTimeFormatter(@Nullable DateTimeFormatter dateTimeFormatter)
    {
        this.dateTimeFormatter = dateTimeFormatter;
    }

}
