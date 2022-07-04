package springbasic1.core;

import springbasic1.core.Member.Grade;
import springbasic1.core.Member.Member;
import springbasic1.core.Member.MemberService;
import springbasic1.core.order.Order;
import springbasic1.core.order.OrderService;

public class OrderApp {
    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService();
        OrderService orderService = appConfig.orderService();

        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 20000);

        System.out.println("order = " + order);
    }
}
