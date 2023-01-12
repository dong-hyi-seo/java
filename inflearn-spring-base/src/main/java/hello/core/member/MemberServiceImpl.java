package hello.core.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * DIP (의존성 역전 법칙) 위배
 * MemberServiceImpl은 MemberRepository와 MemoryMemberRepository 둘다 의존하고있다.
 * 추상화에도 의존하고 구체화에도 의존한다.
 */
@Component
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;

    //해당 부분은 AppConfig(기획자) 내가 할당해줄게 !! 이런뜻...
    //@Autowired가 자동으로 MemberRMepository를 주입해준다.
    @Autowired // = ac.getBean(MemberRepository.class) 와 같다
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }

    //test
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
