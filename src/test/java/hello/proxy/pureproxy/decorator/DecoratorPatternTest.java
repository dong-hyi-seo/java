package hello.proxy.pureproxy.decorator;

import hello.proxy.pureproxy.decorator.code.*;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * 프록시패턴으로 접근제어, 부가기능 추가가가능한데
 * 부가기능을 추가해보자 (decorator pattern)
 * 예를들어 요청값이나, 응답값을 중간에 변형, 실행 시간을 측정해서 추가로그를 남긴다.
 */
@Slf4j
public class DecoratorPatternTest {

    @Test
    void noDecorator() {
        Component realComponent = new RealComponent();
        DecoratorPatternClient client = new DecoratorPatternClient(realComponent);

        client.execute();
    }

    @DisplayName("위 기본 기능에서 추가기능을 붙인다 decorator pattern으로!!")
    @Test
    void decorator1() {
        Component realComponent = new RealComponent();
        Component messageDecorator = new MessageDecorator(realComponent);
        DecoratorPatternClient client = new DecoratorPatternClient(messageDecorator);
        client.execute();
    }

    @DisplayName("위 기본 기능에서 추가기능 2개를 붙인다 decorator pattern으로!!")
    @Test
    void decorator2() {
        Component realComponent = new RealComponent();
        Component messageDecorator = new MessageDecorator(realComponent);
        Component timeDecorator = new TimeDecorator(messageDecorator);
        DecoratorPatternClient client = new DecoratorPatternClient(timeDecorator) ;
        client.execute();
    }
}
