package hello.core.member;

/**
 * DIP (의존성 역전 법칙) 위배
 * MemberServiceImpl은 MemberRepository와 MemoryMemberRepository 둘다 의존하고있다.
 * 추상화에도 의존하고 구체화에도 의존한다.
 */
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository = new MemoryMemberRepository();


    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
