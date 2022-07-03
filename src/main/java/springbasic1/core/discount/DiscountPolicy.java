package springbasic1.core.discount;

import springbasic1.core.Member.Member;

public interface DiscountPolicy {

    /**
     * @return discount amount
     * */
    int discount(Member member, int price);
}
