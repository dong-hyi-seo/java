package hello.advanced;

import hello.advanced.trace.logtrace.FieldLogTrace;
import hello.advanced.trace.logtrace.LogTrace;
import hello.advanced.trace.logtrace.ThreadLocalLogTrace;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LogTraceConfig {

    @Bean
    public LogTrace logTrace() {
        //return new FieldLogTrace(); //동시성이슈 발생함!! 서로 다른 thread가 동일한 자원을 접근함!
        return new ThreadLocalLogTrace(); //ThreadLocal을통하여 동시성이슈 해결
    }
}
