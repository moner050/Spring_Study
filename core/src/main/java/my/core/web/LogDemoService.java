package my.core.web;

import lombok.RequiredArgsConstructor;
import my.core.common.MyLogger;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LogDemoService {

    private final MyLogger myLogger;

    public void logic(String id) {
        myLogger.log("service id : " + id);
    }
}
