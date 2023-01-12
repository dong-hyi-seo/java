package hello.advanced.trace.template;

import hello.advanced.trace.template.code.AbstractTemplate;
import hello.advanced.trace.template.code.SubClassLogic1;
import hello.advanced.trace.template.code.SubClassLogic2;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

/**
 * logic1과 logic2를 비교해보면 시간 측정하는 로직이 동일하며 중복코드가 발생
 * 이를 해결하는 방법 중하나는 템플릿 메서드 패턴을 사용하는것이다
 * 템플릿메서드 패턴은 추상화클래스에 공통로직을 구현!
 * 변하지않는부분과 변하는부분을 분리하는것! 그리고 중복제거!
 */
@Slf4j
public class TemplateMethodTest {

    @Test
    void templateMethodV0() {
        logic1();
        logic2();
    }

    private void logic1() {
        long startTime = System.currentTimeMillis();

        //비즈니스 로직 실행
        log.info("비즈니스 로직1 실행");
        //비즈니스 로직종료
        long endTime = System.currentTimeMillis();
        long resultTime = endTime - startTime;
        log.info("resultTime = {}", resultTime);
    }

    private void logic2() {
        long startTime = System.currentTimeMillis();

        //비즈니스 로직 실행
        log.info("비즈니스 로직2 실행");
        //비즈니스 로직종료
        long endTime = System.currentTimeMillis();
        long resultTime = endTime - startTime;
        log.info("resultTime = {}", resultTime);
    }

    /**
     * Template method pattern 적용!
     */
    @Test
    void templateMethodV1() {
        AbstractTemplate template1 = new SubClassLogic1();
        template1.excute();

        AbstractTemplate template2 = new SubClassLogic2();
        template2.excute();
    }

    /**
     * 템플릿메서드 익명내부클래스사용 !
     * 익명내부클래스를 사용하면 객체 인스턴스를 생성하면서 동시에 생성할 클래스를 상속 받은 자식 클래스를 정의할수있다.
     */
    @Test
    void templateMethodV2() {
        AbstractTemplate template1 = new AbstractTemplate() {

            @Override
            protected void call() {
                //로직 바로 구현!
                log.info("비즈니스 로직1 실행");
            }
        };
        //클래스명은 자바가 임의로만들어줌!! TemplateMethodTest$1 이라고붙여줌
        log.info("익명 클래스 이름1 = {}", template1.getClass());
        template1.excute();

        AbstractTemplate template2 = new AbstractTemplate() {

            @Override
            protected void call() {
                //로직 바로 구현!
                log.info("비즈니스 로직2 실행");
            }
        };
        log.info("익명 클래스 이름2 = {}", template2.getClass());
        template2.excute();;
    }

}
