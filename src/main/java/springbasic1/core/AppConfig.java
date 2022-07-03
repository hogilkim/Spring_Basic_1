package springbasic1.core;

import springbasic1.core.Member.MemberService;
import springbasic1.core.Member.MemberServiceImpl;
import springbasic1.core.Member.MemoryMemberRepository;
import springbasic1.core.discount.FixDiscountPolicy;
import springbasic1.core.order.OrderService;
import springbasic1.core.order.OrderServiceImpl;

public class AppConfig {
    public MemberService memberService(){
        return new MemberServiceImpl(new MemoryMemberRepository());
    }

    public OrderService orderService(){
        return new OrderServiceImpl(new MemoryMemberRepository(), new FixDiscountPolicy());
    }
}
