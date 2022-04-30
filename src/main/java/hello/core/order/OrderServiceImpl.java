package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class OrderServiceImpl implements OrderService {

    private final MemberRepository memberRepository;
    /**
     * 아래 고정 할인에서 그 밑의 비율할인정책으로 변경했을때 문제점??
     */
    //private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
    //private final DiscountPolicy discountPolicy = new RateDiscountPolicy();

    /**
     * 위주석코드 해결방법!
     * 근데 순수자바에서 아래와같이만 하고 .. 하면 nullpoint exception 에러남..
     * 그렇다면? 누군가가 생성해줘야한다.. 누가? (AppConfig class가!! 즉 기획자가 해줄게!)
     * 지금 DIP를 잘 지켜짐 (추상화에 의존해라!!)
     */
    private final DiscountPolicy discountPolicy;


    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }

    //test
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
