package hello.proxy.pureproxy.proxy.code;

import lombok.extern.slf4j.Slf4j;

// 프록시도 실제 객체와 모양이 같아야 하기 때문에 Subject 인터페이스를 구현한다.
@Slf4j
public class CacheProxy implements Subject{

    private Subject target;
    private String cacheValue;

    public CacheProxy(Subject target) {
        this.target = target;
    }

    @Override
    public String operation() {
        log.info("프록시 호출");
        if(cacheValue == null)  cacheValue = target.operation();
        return cacheValue;
    }
}
