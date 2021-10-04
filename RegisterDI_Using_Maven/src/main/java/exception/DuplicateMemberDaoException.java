package exception;

/**
    -- 맴버 중복이 발생했을때 실행되는 Exception 클래스
 **/

public class DuplicateMemberDaoException extends RuntimeException{
    public DuplicateMemberDaoException(String message)
    {
        // super는 자식클래스가 부모클래스로부터 상속받은 맴버를 참조할때 사용한다.
        super(message);
    }
}
