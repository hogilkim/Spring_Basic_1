package springbasic1.core.discount;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import springbasic1.core.Member.Grade;
import springbasic1.core.Member.Member;

import static org.junit.jupiter.api.Assertions.*;

class RateDiscountPolicyTest {

    RateDiscountPolicy discountPolicy = new RateDiscountPolicy();

    @Test
    @DisplayName("VIP should get 10% discount")
    void vip_o() {
        //given
        Member member = new Member(1L, "memberVIP", Grade.VIP);

        //when
        int discount = discountPolicy.discount(member, 10000);

        //then
        Assertions.assertThat(discount).isEqualTo(1000);
    }

    @Test
    @DisplayName("Non-VIP should not get 10% discount")
    void vip_x(){
        Member memberBASIC = new Member(2L, "memberBASIC", Grade.BASIC);

        int discount = discountPolicy.discount(memberBASIC, 10000);

        Assertions.assertThat(discount).isEqualTo(0);
    }
}