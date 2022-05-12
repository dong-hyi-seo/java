package hello.advanced.trace.strategy;

import hello.advanced.trace.strategy.code.strategy.ContextV2;
import hello.advanced.trace.strategy.code.strategy.Strategy;
import hello.advanced.trace.strategy.code.strategy.StrategyLogic1;
import hello.advanced.trace.strategy.code.strategy.StrategyLogic2;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

/**
 * 전략 패턴 두번쨰 방법!
 * context 생성시 주입이아닌 excute시에 파라미터 전달!
 *
 * 선조립 후실행하는 것이아닌 실행할 떄마다 전략을 인수로 전달한다.
 * ContextV1보다 ContextV2 방식이 더좋음!
 * 지금 우리가 원하는 것은 애플리케이션 의존관계를 설정하는 것처럼 선조립, 후실행이아니라.. 단순히 코드를 실행 할 때 변하지 않는
 * 템플릿이 있고, 그템플릿 안에서 원하는 부분만 살짝 다른 코드를 실행하고 싶을뿐이다.!!
 */
@Slf4j
public class ContextV2Test {

    @Test
    void strategyV1() {
        ContextV2 context = new ContextV2();
        context.execute(new StrategyLogic1());
        context.execute(new StrategyLogic2());
    }

    /**
     * 전략패턴 파라미터 방식의 익명클래스
     */
    @Test
    void strategyV2() {
        ContextV2 context = new ContextV2();
        context.execute(new Strategy() {
            @Override
            public void call() {
                log.info("비즈니스 로직1 실행");
            }
        });
        context.execute(new Strategy() {
            @Override
            public void call() {
                log.info("비즈니스 로직2 실행");
            }
        });
    }

    /**
     * 전략패턴 파라미터 방식의 익명클래스 람다
     */
    @Test
    void strategyV3() {
        ContextV2 context = new ContextV2();
        context.execute(() -> log.info("비즈니스 로직1 실행"));
        context.execute(() -> log.info("비즈니스 로직2 실행"));
    }
}
