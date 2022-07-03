package springbasic1.core.Member;

public interface MemberRepository {

    void save(Member member);
    Member findById(Long memberId);
}
