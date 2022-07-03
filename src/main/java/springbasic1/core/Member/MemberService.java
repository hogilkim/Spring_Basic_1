package springbasic1.core.Member;

public interface MemberService {

    void join(Member member);

    Member findMember(Long memberId);
}
