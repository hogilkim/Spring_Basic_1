package springbasic1.core;

import springbasic1.core.Member.MemberRepository;
import springbasic1.core.Member.MemberService;
import springbasic1.core.Member.MemberServiceImpl;
import springbasic1.core.Member.MemoryMemberRepository;
import springbasic1.core.discount.DiscountPolicy;
import springbasic1.core.discount.FixDiscountPolicy;
import springbasic1.core.discount.RateDiscountPolicy;
import springbasic1.core.order.OrderService;
import springbasic1.core.order.OrderServiceImpl;

public class AppConfig {
    public MemberService memberService(){
        return new MemberServiceImpl(memberRepository());
    }

    public OrderService orderService(){
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    private MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

//    private DiscountPolicy discountPolicy() {
//        return new FixDiscountPolicy();
//    }

    private DiscountPolicy discountPolicy() {
        return new RateDiscountPolicy();
    }
}
