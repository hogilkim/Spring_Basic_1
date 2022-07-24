package springbasic1.core;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springbasic1.core.Member.MemberRepository;
import springbasic1.core.Member.MemberService;
import springbasic1.core.Member.MemberServiceImpl;
import springbasic1.core.Member.MemoryMemberRepository;
import springbasic1.core.discount.DiscountPolicy;
import springbasic1.core.discount.FixDiscountPolicy;
import springbasic1.core.discount.RateDiscountPolicy;
import springbasic1.core.order.OrderService;
import springbasic1.core.order.OrderServiceImpl;

@Configuration
public class AppConfig {
    @Bean
    public MemberService memberService(){
        System.out.println("call AppConfig.memberService");
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public OrderService orderService(){
        System.out.println("call AppConfig.orderService");
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean
    public MemberRepository memberRepository() {
        System.out.println("call AppConfig.memberRepository");
        return new MemoryMemberRepository();
    }

//    public DiscountPolicy discountPolicy() {
//        return new FixDiscountPolicy();
//    }

    @Bean
    public DiscountPolicy discountPolicy() {
        return new RateDiscountPolicy();
    }

}
