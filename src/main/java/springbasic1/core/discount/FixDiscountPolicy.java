package springbasic1.core.discount;

import org.springframework.stereotype.Component;
import springbasic1.core.Member.Grade;
import springbasic1.core.Member.Member;

public class FixDiscountPolicy implements DiscountPolicy{

    private int discountFixAmount = 1000;

    @Override
    public int discount(Member member, int price) {
        if (member.getGrade() == Grade.VIP){
            return discountFixAmount;
        } else {
            return 0;
        }
    }
}
