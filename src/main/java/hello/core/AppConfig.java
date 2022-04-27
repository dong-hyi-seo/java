package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 기획자!!!
 * 너네 할인, 주문 직접 너네가 할당하지마 내가해줄테니 너의 역할만 책임져 !
 * 기획자가 memberService, orderService 에게 주입해주는데 해당 두개 입장에서는 외부에서 주입해주는 것같이 느낄것이다.. 이를!!
 * DI(Dependency Injection) 우리말로 의존관계 주입 또느 의존성 주입이라고 한다.
 */
@Configuration
public class AppConfig {

    /**
     * @Bean??
     */

    //memberRepository 를 함수로 따로빼주면 해당 repository를 memory -> storage로 갈경우 한 함수내에서만 변경하면 됨!! (이점)
    //어플리케이션 전체 구성이 어떻게 되어있는지 빠르게 파악이가능 !!
    @Bean
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl(new MemoryMemberRepository(), discountPolicy());
    }

    @Bean
    public DiscountPolicy discountPolicy() {
        //return new FixDiscountPolicy(); //쉽게 정액 할인정책, 정률할인정책을 이 함수하나에서만 변경하면됨..
        return new RateDiscountPolicy();
    }


}
