package core.advanced.trace.threadlocal;

import core.advanced.trace.threadlocal.code.FieldService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class FieldServiceTest {
    // 여러 쓰레드가 동시에 같은 인스턴스의 필드 값을 변경하면서 동시성 문제가 발생하는데
    // 싱글톤 객체의 필드를 변경하면서 사용할 때 이런 동시성 문제가 발생한다.
    // 동시성 문제는 지역 변수에는 발생하지 않는다.(지역변수는 쓰레드마다 각각 다른 메모리 영역에 할당된다)
    // 주로 같은 인스턴스의 필드, 또는 static 공용 필드에 접근할 때 발생한다.
    private FieldService fieldService = new FieldService();

    @Test
    void field() {
        log.info("main start");
        Runnable userA = () -> {
            fieldService.logic("userA");
        };
        Runnable userB = () -> {
            fieldService.logic("userB");
        };

        Thread threadA = new Thread(userA);
        threadA.setName("thread-A");
        Thread threadB = new Thread(userB);
        threadB.setName("thread-B");

        threadA.start();
//        sleep(2000);    // 동시성 문제가 발생 X
        sleep(100);    // 동시성 문제가 발생 O
        threadB.start();

        // CountDownLatch 를 쓰면 되지만 복잡하니 sleep 으로 테스트
        sleep(3000);    // 메인 쓰레드 종료 대기
        log.info("main exit");
    }

    private void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
