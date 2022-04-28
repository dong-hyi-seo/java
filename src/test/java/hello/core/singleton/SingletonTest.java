package hello.core.singleton;

import hello.core.AppConfig;
import hello.core.member.Member;
import hello.core.member.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SingletonTest {

    @Test
    @DisplayName("스플이 없ㅇ는 순수한 DI 컨테이너")
    void pureContainer() {
        AppConfig appConfig = new AppConfig();

        //1조회 : 호출할때 마다 객체 생성
        MemberService memberService = appConfig.memberService();

        //2조회 : 호출할떄마다 객체 생서
        MemberService memberService1 = appConfig.memberService();

        //3조회 : 호출할떄마다 객체 생서
        MemberService memberService2 = appConfig.memberService();

        //참조값이 다른것을 확인
        System.out.println("memberService1 = " + memberService1);
        System.out.println("memberService2 = " + memberService2);

        //memberService1 != memberService2
        Assertions.assertThat(memberService1).isNotSameAs(memberService2);

    }

    @Test
    @DisplayName("싱글톤 패턴을 적용한 객체 사용")
    void singletonServiceTest() {
        SingletonService instance1 = SingletonService.getInstance();
        SingletonService instance2 = SingletonService.getInstance();

        System.out.println("singletonService1 = " + instance1);
        System.out.println("singletonService2 = " + instance2);

        //sameAs ==
        Assertions.assertThat(instance1).isSameAs(instance2);
    }

    @Test
    @DisplayName("스프링 컨테이너와 싱글톤")
    void springContainer() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

        //2조회 : 호출할떄마다 객체 생서
        MemberService memberService1 = ac.getBean("memberService", MemberService.class);

        //3조회 : 호출할떄마다 객체 생서
        MemberService memberService2 = ac.getBean("memberService", MemberService.class);

        //참조값이 다른것을 확인
        System.out.println("memberService1 = " + memberService1);
        System.out.println("memberService2 = " + memberService2);

        //memberService1 != memberService2
        Assertions.assertThat(memberService1).isSameAs(memberService2);
    }


}
